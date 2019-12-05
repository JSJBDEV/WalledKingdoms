package gd.rf.acro.walledkingdoms.Items;

import gd.rf.acro.walledkingdoms.Citizens.Citizens;
import gd.rf.acro.walledkingdoms.Dominion.Dominion;
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
        if(!world.isRemote && hand.equals(EnumHand.MAIN_HAND)) {
            //p_onItemRightClick_2_.setHeldItem(p_onItemRightClick_3_,Utils.createBook("me","a book","{\"text\":\"Minecraft Tools book\"}","book.page2.text"));
            //player.sendMessage(new TextComponentString(Citizens.getHouseTypeFromCurrentCoords(player,0)));
            //Dominion.makeVillageCensus(world,player.getPosition(),player);
            Citizens.createBuilder(world, player.getPosition());
        }
        return super.onItemRightClick(world, player, hand);
    }
}
