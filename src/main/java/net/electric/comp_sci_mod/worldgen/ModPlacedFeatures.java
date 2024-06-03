package net.electric.comp_sci_mod.worldgen;

import net.electric.comp_sci_mod.COMPSCIMOD;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");

    public static final ResourceKey<PlacedFeature> RAW_RUBY_BLOCK_PLACED_KEY = registerKey("raw_ruby_block_placed");

    public static final ResourceKey<PlacedFeature> RAW_SAPPHIRE_BLOCK_PLACED_KEY = registerKey("raw_sapphire_block_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,SAPPHIRE_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(80))));
        register(context,RUBY_ORE_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(80))));
        register(context,RAW_SAPPHIRE_BLOCK_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.RAW_SAPPHIRE_BLOCK_KEY),
                ModOrePlacement.commonOrePlacement(10,HeightRangePlacement.triangle(VerticalAnchor.absolute(-10),VerticalAnchor.absolute(50))));
        register(context,RAW_RUBY_BLOCK_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.RAW_RUBY_BLOCK_KEY),
                ModOrePlacement.commonOrePlacement(10,HeightRangePlacement.triangle(VerticalAnchor.absolute(-10),VerticalAnchor.absolute(50))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String n){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(COMPSCIMOD.MOD_ID,n));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
