package wiicustomorigins.common.registry;

import io.github.apace100.apoli.power.*;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import wiicustomorigins.common.WiiCustomOrigins;
import wiicustomorigins.common.power.*;
import net.minecraft.registry.Registry;

import java.util.Collections;

public class ModPowers {
	public static final PowerFactory<Power> MODIFY_SIZE = new PowerFactory<>(WiiCustomOrigins.id("modify_size"), new SerializableData().add("scale_types", SerializableDataTypes.IDENTIFIERS).add("scale", SerializableDataTypes.FLOAT), data -> (type, entity) -> new ModifySizePower(type, entity, data.get("scale_types"), data.getFloat("scale"))).allowCondition();
	public static final PowerFactory<Power> MOB_NEUTRALITY = new PowerFactory<>(WiiCustomOrigins.id("mob_neutrality"), new SerializableData().add("entity_types", SerializableDataType.list(SerializableDataTypes.ENTITY_TYPE), Collections.emptyList()).add("inverted", SerializableDataTypes.BOOLEAN, false), data -> (type, entity) -> new MobNeutralityPower(type, entity, data.get("entity_types"), data.getBoolean("inverted"))).allowCondition();

	public static void init() {
		Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_SIZE.getSerializerId(), MODIFY_SIZE);
		Registry.register(ApoliRegistries.POWER_FACTORY, MOB_NEUTRALITY.getSerializerId(), MOB_NEUTRALITY);
	}
}