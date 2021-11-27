package wiicustomorigins.common.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import wiicustomorigins.common.WiiCustomOrigins;
import wiicustomorigins.common.power.ModifySizePower;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import virtuoel.pehkui.api.ScaleRegistries;

import java.util.Collections;
import java.util.List;

public class EOPowers {	
	@SuppressWarnings("unchecked")
	public static final PowerFactory<Power> MODIFY_SIZE = new PowerFactory<>(new Identifier(WiiCustomOrigins.MOD_ID, "modify_size"), new SerializableData().add("scale_types", SerializableDataTypes.IDENTIFIERS, Collections.singletonList(ScaleRegistries.getId(ScaleRegistries.SCALE_TYPES, EOScaleTypes.MODIFY_SIZE_TYPE))).add("scale", SerializableDataTypes.FLOAT), data -> (type, entity) -> new ModifySizePower(type, entity, (List<Identifier>) data.get("scale_types"), data.getFloat("scale"))).allowCondition();
	
	public static void init() {
		Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_SIZE.getSerializerId(), MODIFY_SIZE);
	}
}