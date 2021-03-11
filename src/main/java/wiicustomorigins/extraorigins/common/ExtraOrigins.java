package wiicustomorigins.extraorigins.common;

import wiicustomorigins.extraorigins.common.registry.EOPowers;
import wiicustomorigins.extraorigins.common.registry.EOScaleTypes;
import net.fabricmc.api.ModInitializer;

public class ExtraOrigins implements ModInitializer {
	public static final String MODID = "wiicustomorigins";
	
	@Override
	public void onInitialize() {
		EOScaleTypes.init();
		EOPowers.init();
	}
}
