package net.electric.comp_sci_mod.item;

import net.electric.comp_sci_mod.COMPSCIMOD;
import net.electric.comp_sci_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

import static java.awt.Component.*;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, COMPSCIMOD.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("mod_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get())).title(net.minecraft.network.chat.Component.literal("Mod Stuff"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.SAPPHIRE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());

                        pOutput.accept(ModItems.GRAPPLER.get());

                        pOutput.accept(ModItems.GOLD_BAND.get());

                    })
                    .build());





    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
