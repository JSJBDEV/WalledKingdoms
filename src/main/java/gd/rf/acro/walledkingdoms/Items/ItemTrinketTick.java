package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ItemTrinketTick {
    @SubscribeEvent
    public void onTickPlayerEvent(TickEvent.PlayerTickEvent event){

        //if(!event.player.worldObj.isRemote){
        if(event.phase == TickEvent.Phase.START){
            EntityPlayer player = (EntityPlayer) event.player;
            EntityEquipmentSlot entityequipmentslot = EntityEquipmentSlot.HEAD;
            String head_item = (player.getItemStackFromSlot(entityequipmentslot)).getUnlocalizedName();
            //System.out.println(head_item);
            if(head_item.equals("item.circlet_enderpearl")){

                //System.out.println("Activated");
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 3, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 3, -10));
            }
            if(event.phase == TickEvent.Phase.END){

            }
        }
    }
}

