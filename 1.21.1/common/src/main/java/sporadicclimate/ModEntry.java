package sporadicclimate;

import net.blay09.mods.balm.api.Balm;
import sporadicclimate.component.ModComponents;
import sporadicclimate.item.ModBlocks;
import sporadicclimate.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ModEntry {
    public static final String MOD_ID = "sporadicclimate";
    public static final Logger _LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        Balm.getConfig().registerConfig(ModConfig.class);

        ModComponents.init();
        ModBlocks.init();
        ModItems.init();
    }

    public static void preInitialize() {

    }
}
