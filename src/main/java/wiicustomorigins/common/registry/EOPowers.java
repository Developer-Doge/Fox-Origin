package wiicustomorigins.common.registry;

import io.github.apace100.origins.power.Power;
import io.github.apace100.origins.power.factory.PowerFactory;
import io.github.apace100.origins.registry.ModRegistries;
import io.github.apace100.origins.util.SerializableData;
import io.github.apace100.origins.util.SerializableDataType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wiicustomorigins.common.WiiCustomOrigins;
import wiicustomorigins.common.power.ModifySizePower;

import java.util.LinkedHashMap;
import java.util.Map;

public class EOPowers {
	private static final Map<PowerFactory<?>, Identifier> POWER_FACTORIES = new LinkedHashMap<>();
	public static final PowerFactory<Power> MODIFY_SIZE = create(new PowerFactory<>(new Identifier(WiiCustomOrigins.MODID, "modify_size"), new SerializableData().add("scale", SerializableDataType.FLOAT), data -> (type, player) -> new ModifySizePower(type, player, data.getFloat("scale"))).allowCondition());
	
	private static <T extends Power> PowerFactory<T> create(PowerFactory<T> factory) {
		POWER_FACTORIES.put(factory, factory.getSerializerId());
		return factory;
	}
	
	public static void init() {
		POWER_FACTORIES.keySet().forEach(powerType -> Registry.register(ModRegistries.POWER_FACTORY, POWER_FACTORIES.get(powerType), powerType));
	}
}
