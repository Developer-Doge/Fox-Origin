package wiicustomorigins.common;

import wiicustomorigins.common.registry.EOPowers;
import wiicustomorigins.common.registry.EOScaleTypes;
import net.fabricmc.api.ModInitializer;

public class WiiCustomOrigins implements ModInitializer {
	public static final String MOD_ID = "wiicustomorigins";
	
	@Override
	public void onInitialize() {
		EOScaleTypes.init();
		EOPowers.init();
	}
}
