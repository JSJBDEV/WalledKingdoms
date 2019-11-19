package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemTrinket extends ItemBase {
    public ItemTrinket(String name) { super(name); }

    @Override
    /**public ActionResult<ItemStack> onItemRightClick(World p_onItemRightClick_1_, EntityPlayer p_onItemRightClick_2_, EnumHand p_onItemRightClick_3_) {
        
    }*/
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        EntityEquipmentSlot entityequipmentslot = EntityEquipmentSlot.HEAD;
        ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

        if (itemstack1.isEmpty())
        {
            playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
            itemstack.setCount(0);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }


    @SubscribeEvent
    public void onItemTick(World world, EntityPlayer playerIn)
    {
        if(!world.isRemote)
            playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2, 1));
        if(!world.isRemote)
            playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2, 1));

    }


}

