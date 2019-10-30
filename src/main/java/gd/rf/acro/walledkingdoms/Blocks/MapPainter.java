package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import org.apache.commons.io.FileUtils;

import java.util.Arrays;
import java.util.Objects;

public class MapPainter extends BlockBase {
    public MapPainter(Material material, String name) {
        super(material, name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing p_onBlockActivated_6_, float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {

        if(player.getHeldItem(hand).getItem()== Items.FILLED_MAP)
        {
            ItemMap map = (ItemMap) player.getHeldItem(hand).getItem();
            MapData data = map.getMapData(player.getHeldItem(hand),world);
            data.colors = Utils.imageUrlToMap("https://upload.wikimedia.org/wikipedia/commons/1/1c/Crystal_128_penguin.png");
            data.dimension=777;
            data.trackingPosition=false;
            map.updateMapData(world,player,data);
            player.setHeldItem(hand,new ItemStack(map));

        }
        return super.onBlockActivated(world, pos, state, player, hand, p_onBlockActivated_6_, p_onBlockActivated_7_, p_onBlockActivated_8_, p_onBlockActivated_9_);
    }

    @Override
    public MapPainter setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
