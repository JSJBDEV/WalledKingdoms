package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.Citizens.Citizens;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemDebug extends ItemBase {
    public ItemDebug(String name) {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        //p_onItemRightClick_2_.setHeldItem(p_onItemRightClick_3_,Utils.createBook("me","a book","{\"text\":\"Minecraft Tools book\"}","book.page2.text"));
        player.sendMessage(new TextComponentString(Citizens.getHouseTypeFromCurrentCoords(player,0)));
        return super.onItemRightClick(world, player, hand);
    }
}
