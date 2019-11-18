package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBow extends ItemBase {
    public ItemBow(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World p_onItemRightClick_1_, EntityPlayer p_onItemRightClick_2_, EnumHand p_onItemRightClick_3_) {
        Utils.makeRangedAttack(p_onItemRightClick_2_);
        return super.onItemRightClick(p_onItemRightClick_1_, p_onItemRightClick_2_, p_onItemRightClick_3_);
    }
}
