package net.electric.comp_sci_mod.worldgen;

import io.netty.bootstrap.Bootstrap;
import net.electric.comp_sci_mod.COMPSCIMOD;
import net.electric.comp_sci_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>>  SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>>  RUBY_ORE_KEY = registerKey("ruby_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>>  RAW_SAPPHIRE_BLOCK_KEY = registerKey("raw_sapphire_block");

    public static final ResourceKey<ConfiguredFeature<?,?>>  RAW_RUBY_BLOCK_KEY= registerKey("raw_ruby_block");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> sapphireOre = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> rubyOre = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.RUBY_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> rawSapphreBlock = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.RAW_SAPPHIRE_BLOCK.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> rawRubyBlock = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.RAW_RUBY_BLOCK.get().defaultBlockState()));

        register(context,SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(sapphireOre,5));
        register(context,RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubyOre,5));
        register(context,RAW_SAPPHIRE_BLOCK_KEY,Feature.ORE,new OreConfiguration(rawSapphreBlock,5));
        register(context,RAW_RUBY_BLOCK_KEY,Feature.ORE,new OreConfiguration(rawRubyBlock,5));
    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(COMPSCIMOD.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


