package net.electric.comp_sci_mod.datagen;

import net.electric.comp_sci_mod.COMPSCIMOD;
import net.electric.comp_sci_mod.block.ModBlocks;
import net.electric.comp_sci_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, COMPSCIMOD.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.CUSTOM_ORE).add(ModBlocks.RUBY_ORE.get());


        this.tag(ModTags.Blocks.CUSTOM_ORE).add(ModBlocks.SAPPHIRE_ORE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.RUBY_ORE.get());


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.RUBY_ORE.get(),
                ModBlocks.RUBY_BLOCK.get(),
                ModBlocks.SAPPHIRE_BLOCK.get());
    }
}
