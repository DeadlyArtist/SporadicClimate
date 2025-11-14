package sporadicclimate;

import net.blay09.mods.balm.api.Balm;
import net.blay09.mods.balm.api.config.reflection.Comment;
import net.blay09.mods.balm.api.config.reflection.Config;
import net.minecraft.util.math.MathHelper;

@Config(value = ModEntry.MOD_ID, type = "common")
public class ModConfig {

    public static ModConfig get() {
        return Balm.getConfig().getActiveConfig(ModConfig.class);
    }

    @Comment("Multiplies the scale of temperature zones")
    public float zoneScaleMultiplier = 0.2f;

    public float getZoneScaleMultiplier() {
        return 1 / MathHelper.clamp(zoneScaleMultiplier, 0.01f, 100f);
    }
}
