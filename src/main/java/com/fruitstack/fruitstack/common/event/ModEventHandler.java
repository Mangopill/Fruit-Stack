package com.fruitstack.fruitstack.common.event;

import com.fruitstack.fruitstack.common.block.LowWoodenBarrelBlock;
import com.fruitstack.fruitstack.common.registry.ModBlocks;
import com.fruitstack.fruitstack.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static com.fruitstack.fruitstack.common.block.LowWoodenBarrelBlock.AGE;


@Mod.EventBusSubscriber(modid = "fruitstack", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandler {
    // 玩家死亡事件处理方法
    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        // 检查实体是否为玩家
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Level world = player.level;
            // 创建掉落物实体对象并添加到游戏世界中
            ItemStack itemStack = new ItemStack(ModItems.CORPSE.get());
            ItemEntity itemEntity = new ItemEntity(world, player.getX(), player.getY(), player.getZ(), itemStack);
            world.addFreshEntity(itemEntity);
        }
    }
    // 村民死亡事件处理方法
    @SubscribeEvent
    public static void onVillagerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Villager) {
            Villager villager = (Villager) event.getEntity();
            Level world = villager.level;

            // 创建掉落物实体对象并添加到游戏世界中
            ItemStack itemStack = new ItemStack(ModItems.CORPSE.get());
            ItemEntity itemEntity = new ItemEntity(world, villager.getX(), villager.getY(), villager.getZ(), itemStack);
            world.addFreshEntity(itemEntity);
        }
    }
}