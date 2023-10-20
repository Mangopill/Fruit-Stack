package com.fruitstack.fruitstack.common.entity;

import com.fruitstack.fruitstack.common.registry.ModEntityTypes;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RawMoonCakeEntity extends ThrowableItemProjectile
{
	public RawMoonCakeEntity(EntityType<? extends RawMoonCakeEntity> entityType, Level level) {
		super(entityType, level);
	}

	public RawMoonCakeEntity(Level level, LivingEntity entity) {
		super(ModEntityTypes.RAW_BLUEBERRIES_MOON_CAKE.get(), entity, level);
	}

	public RawMoonCakeEntity(Level level, double x, double y, double z) {
		super(ModEntityTypes.RAW_BLUEBERRIES_MOON_CAKE.get(), x, y, z, level);
	}

	@Override
	protected Item getDefaultItem() {
			return ModItems.RAW_HAMIMELON_MOON_CAKE.get();
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		ItemStack entityStack = new ItemStack(this.getDefaultItem());
		if (id == 3) {
			ParticleOptions iparticledata = new ItemParticleOption(ParticleTypes.ITEM, entityStack);

			for (int i = 0; i < 12; ++i) {
				this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(),
						((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F,
						((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F + 0.1F,
						((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F);
			}
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		entity.hurt(DamageSource.thrown(this, this.getOwner()), 0);
		this.playSound(SoundEvents.SNOW_BREAK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte) 3);
			this.playSound(SoundEvents.SNOW_BREAK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.discard();
		}
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
