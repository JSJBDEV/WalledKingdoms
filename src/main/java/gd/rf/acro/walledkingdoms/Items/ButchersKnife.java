package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.Dominion.Dominion;
import gd.rf.acro.walledkingdoms.WalledKingdoms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ButchersKnife extends ItemBase {
    public ButchersKnife(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        Item ingredient = player.getHeldItem(EnumHand.OFF_HAND).getItem();
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);

        if(ingredient==ModItems.carcassChicken) {

            if(ingredientStack.getCount()>1)
            {
                ingredientStack.setCount(ingredientStack.getCount()-1);
            }
            else
            {
                player.inventory.deleteStack(ingredientStack);
            }
            ItemStack resultStack = new ItemStack(Items.CHICKEN, 64);
            player.addItemStackToInventory(resultStack);
        }

        return super.onItemRightClick(world, player, hand);
    }
}
