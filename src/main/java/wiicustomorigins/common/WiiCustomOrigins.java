package wiicustomorigins.common;

import wiicustomorigins.common.registry.*;
import net.fabricmc.api.ModInitializer;

public class WiiCustomOrigins implements ModInitializer {
	public static final String MOD_ID = "wiicustomorigins";
	
	@Override
	public void onInitialize() {
		ModScaleTypes.init();
		ModPowers.init();
	}
}
