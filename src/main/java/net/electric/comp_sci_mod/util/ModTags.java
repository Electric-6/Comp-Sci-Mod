package net.electric.comp_sci_mod.util;

import net.electric.comp_sci_mod.COMPSCIMOD;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CUSTOM_ORE = tag("custom_ore");

        private static TagKey<Block> tag(String n) {
            return BlockTags.create(new ResourceLocation(COMPSCIMOD.MOD_ID, n));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String n) {
            return ItemTags.create(new ResourceLocation(COMPSCIMOD.MOD_ID, n));
        }
    }
}
