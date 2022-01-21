package wiicustomorigins.common.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import wiicustomorigins.common.WiiCustomOrigins;
import wiicustomorigins.common.power.ModifySizePower;
import wiicustomorigins.common.power.MobNeutralityPower;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import virtuoel.pehkui.api.ScaleRegistries;
import java.util.Collections;

public class ModPowers {	
	public static final PowerFactory<Power> MODIFY_SIZE = new PowerFactory<>(new Identifier(WiiCustomOrigins.MOD_ID, "modify_size"), new SerializableData().add("scale_types", SerializableDataTypes.IDENTIFIERS, Collections.singletonList(ScaleRegistries.getId(ScaleRegistries.SCALE_TYPES, ModScaleTypes.MODIFY_SIZE_TYPE))).add("scale", SerializableDataTypes.FLOAT), data -> (type, entity) -> new ModifySizePower(type, entity, data.get("scale_types"), data.getFloat("scale"))).allowCondition();
	
	public static final PowerFactory<Power> MOB_NEUTRALITY = new PowerFactory<>(new Identifier(WiiCustomOrigins.MOD_ID, "mob_neutrality"), new SerializableData().add("entity_types", SerializableDataType.list(SerializableDataTypes.ENTITY_TYPE)), data -> (type, entity) -> new MobNeutralityPower(type, entity, data.get("entity_types"))).allowCondition();

	public static void init() {
		Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_SIZE.getSerializerId(), MODIFY_SIZE);
		Registry.register(ApoliRegistries.POWER_FACTORY, MOB_NEUTRALITY.getSerializerId(), MOB_NEUTRALITY);
	}
}