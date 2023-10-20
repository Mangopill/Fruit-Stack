package com.fruitstack.fruitstack.common.advancement;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import com.fruitstack.fruitstack.fruitstack;

public class Litchi extends SimpleCriterionTrigger<Litchi.TriggerInstance>
{
	private static final ResourceLocation ID = new ResourceLocation(fruitstack.MODID, "get_litchi");

	public ResourceLocation getId() {
		return ID;
	}

	public void trigger(ServerPlayer player) {
		this.trigger(player, TriggerInstance::test);
	}

	@Override
	protected TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite player, DeserializationContext conditionsParser) {
		return new TriggerInstance(player);
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance
	{
		public TriggerInstance(EntityPredicate.Composite player) {
			super(Litchi.ID, player);
		}

		public static TriggerInstance simple() {
			return new TriggerInstance(EntityPredicate.Composite.ANY);
		}

		public boolean test() {
			return true;
		}
	}
}
