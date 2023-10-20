package com.fruitstack.fruitstack.common.advancement;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
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
	protected TriggerInstance createInstance(JsonObject json, ContextAwarePredicate player, DeserializationContext conditionsParser) {
		return new TriggerInstance(player);
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance
	{
		public TriggerInstance(ContextAwarePredicate player) {
			super(Litchi.ID, player);
		}

		public static TriggerInstance simple() {
			return new TriggerInstance(ContextAwarePredicate.ANY);
		}

		public boolean test() {
			return true;
		}
	}
}
