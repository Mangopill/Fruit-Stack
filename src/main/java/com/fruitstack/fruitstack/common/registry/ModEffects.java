package com.fruitstack.fruitstack.common.registry;

import com.fruitstack.fruitstack.common.effect.WarmStomachEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.fruitstack.fruitstack.fruitstack;
import com.fruitstack.fruitstack.common.effect.CrispEffect;
import com.fruitstack.fruitstack.common.effect.SweetEffect;
import com.fruitstack.fruitstack.common.effect.TipsyEffect;

public class ModEffects
{
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, fruitstack.MODID);

	public static final RegistryObject<MobEffect> SWEET = EFFECTS.register("sweet", SweetEffect::new);
	public static final RegistryObject<MobEffect> CRISP = EFFECTS.register("crisp", CrispEffect::new);
	public static final RegistryObject<MobEffect> TIPSY = EFFECTS.register("tipsy", TipsyEffect::new);
	public static final RegistryObject<MobEffect> WARM_STOMACH = EFFECTS.register("warm_stomach", WarmStomachEffect::new);
}
