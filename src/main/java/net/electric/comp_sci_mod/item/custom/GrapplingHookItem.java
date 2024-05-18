package net.electric.comp_sci_mod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class GrapplingHookItem extends Item {

    public GrapplingHookItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand pHand){
        ItemStack itemstack = p.getItemInHand(pHand);

        if(!l.isClientSide){
            ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(l, p);
            thrownenderpearl.setItem(itemstack);
            thrownenderpearl.shootFromRotation(p, p.getXRot(), p.getYRot(), 0.0F, 1.5F, 1.0F);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, l.isClientSide());
    }
}
