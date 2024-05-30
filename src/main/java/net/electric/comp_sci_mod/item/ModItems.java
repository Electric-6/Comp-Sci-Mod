package net.electric.comp_sci_mod.item;

import net.electric.comp_sci_mod.COMPSCIMOD;
import net.electric.comp_sci_mod.item.custom.GrapplingHookItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, COMPSCIMOD.MOD_ID);

    //gem items
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",()->new Item(new Item.Properties()));

    //raw items
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby",()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_BAND = ITEMS.register("gold_band",()->new Item((new Item.Properties())));

    public static final RegistryObject<Item> GRAPPLER= ITEMS.register("grappler",()->new GrapplingHookItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
