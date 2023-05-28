package wiicustomorigins.common;

import wiicustomorigins.common.registry.ModPowers;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class WiiCustomOrigins implements ModInitializer {
	public static final String MOD_ID = "wiicustomorigins";

	@Override
	public void onInitialize() {
		ModPowers.init();
	}

	public static Identifier id(String value) {
		return new Identifier(MOD_ID, value);
	}
}