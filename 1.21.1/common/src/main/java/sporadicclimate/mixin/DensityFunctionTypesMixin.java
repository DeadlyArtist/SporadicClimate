package sporadicclimate.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.densityfunction.DensityFunction;
import net.minecraft.world.gen.densityfunction.DensityFunctionTypes;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sporadicclimate.ModConfig;

@Mixin(DensityFunctionTypes.class)
public class DensityFunctionTypesMixin {

    @Inject(method = "shiftedNoise", at = @At("HEAD"))
    private static void changeScale(DensityFunction shiftX, DensityFunction shiftZ, double xzScale, RegistryEntry<DoublePerlinNoiseSampler.NoiseParameters> noiseParameters, CallbackInfoReturnable<DensityFunction> cir, @Local LocalDoubleRef xzScaleRef) {
        if (noiseParameters.matchesKey(NoiseParametersKeys.TEMPERATURE) || noiseParameters.matchesKey(NoiseParametersKeys.TEMPERATURE_LARGE)) xzScaleRef.set(xzScaleRef.get() * ModConfig.get().getZoneScaleMultiplier());
    }
}
