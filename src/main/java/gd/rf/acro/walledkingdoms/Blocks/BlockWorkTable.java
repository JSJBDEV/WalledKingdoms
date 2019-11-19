package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.Citizens.Citizens;
import gd.rf.acro.walledkingdoms.Citizens.EntityCitizenPassive;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockWorkTable extends BlockBase {
    public BlockWorkTable(Material material, String name) {
        super(material, name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing_6_, float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {
        EntityCitizenPassive citizen = world.getEntitiesWithinAABB(EntityCitizenPassive.class,new AxisAlignedBB(pos.add(-5,-5,-5),pos.add(5,5,5))).get(0);
        Item item = citizen.getHeldItem(EnumHand.MAIN_HAND).getItem();
        player.sendMessage(new TextComponentString("This Worktable is currently manned by "+citizen.getCustomNameTag()+", they are a "+ Citizens.getProfessionNameFromItem(item,true)));

        if(item==Items.PORKCHOP)
        {

        }
        if(item==Items.BREAD)
        {

        }
        if(item==Items.CLOCK)
        {

        }
        if(item==Item.getItemFromBlock(Blocks.ANVIL))
        {

        }
        if(item==Items.GOLD_INGOT)
        {

        }


        return super.onBlockActivated(world, pos, state, player, hand, facing_6_, p_onBlockActivated_7_, p_onBlockActivated_8_, p_onBlockActivated_9_);
    }
}
