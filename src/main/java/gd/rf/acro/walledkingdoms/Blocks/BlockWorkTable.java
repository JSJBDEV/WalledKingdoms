package gd.rf.acro.walledkingdoms.Blocks;

import gd.rf.acro.walledkingdoms.Citizens.Citizens;
import gd.rf.acro.walledkingdoms.Citizens.EntityCitizenPassive;
import gd.rf.acro.walledkingdoms.Items.ModItems;
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

import static gd.rf.acro.walledkingdoms.Utils.directRecipe;


public class BlockWorkTable extends BlockBase {

    /**
     * The intention of this block is to make components that the player can then craft into objects using a standard
     * crafting table, for example a ring base can be created on a blacksmith table using 4 iron nuggets, this can then
     * be used in crafting of rings
     */
    

    public BlockWorkTable(Material material, String name) {
        super(material, name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing_6_, float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {
        if(!world.isRemote && hand.equals(EnumHand.MAIN_HAND)) {
            Item item;
            try {
                EntityCitizenPassive citizen = world.getEntitiesWithinAABB(EntityCitizenPassive.class, new AxisAlignedBB(pos.add(-5, -5, -5), pos.add(5, 5, 5))).get(0);
                item = citizen.getHeldItem(EnumHand.MAIN_HAND).getItem();
                player.sendMessage(new TextComponentString("This Worktable is currently manned by " + citizen.getCustomNameTag() + ", they are a " + Citizens.getProfessionNameFromItem(item, true)));
            }
            catch(Exception e) {
                item = Item.getItemFromBlock(Blocks.FIRE);
            }

            if (item == Items.PORKCHOP) {
                processButcher(player);
            }
            if (item == Items.BREAD) {
                processBaker(player);
            }
            if (item == Items.CLOCK) {
                processClockmaker(player);
            }
            if (item == Item.getItemFromBlock(Blocks.ANVIL)) {
                processBlacksmith(player);
            }
            if (item == Items.GOLD_INGOT) {
                processGoldsmith(player);
            }
        }

        return super.onBlockActivated(world, pos, state, player, hand, facing_6_, p_onBlockActivated_7_, p_onBlockActivated_8_, p_onBlockActivated_9_);
    }



    private static void processButcher(EntityPlayer player) {
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);
        Item ToolItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();

        if(ToolItem.equals(ModItems.butchersKnife))
        {
            if(ingredientStack.getItem().equals(ModItems.carcassChicken))
            {
                Item[] returnItems = {ModItems.chickenBreast, ModItems.chickenDrumstick, ModItems.chickenWing};
                int[] returnAmounts = {2,2,2};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassCow))
            {
                Item[] returnItems = {ModItems.beefMince};
                int[] returnAmounts = {3};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassDonkey))
            {
                Item[] returnItems = {ModItems.beefMince};
                int[] returnAmounts = {2};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassHorse))
            {
                Item[] returnItems = {ModItems.beefMince, ModItems.tongue, ModItems.horseSteak};
                int[] returnAmounts = {3, 1, 1};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassPig))
            {
                Item[] returnItems = {ModItems.porkMince};
                int[] returnAmounts = {2};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassRabbit))
            {
                Item[] returnItems = {};
                int[] returnAmounts = {};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassSheep))
            {
                Item[] returnItems = {ModItems.lambMince};
                int[] returnAmounts = {2};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.carcassSquid))
            {
                Item[] returnItems = {};
                int[] returnAmounts = {};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }
        }

    }



    private static void processBaker(EntityPlayer player) {
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);
        Item ToolItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();

        if(ToolItem.equals(ModItems.grindStone))
        {
            if(ingredientStack.getItem().equals(Items.WHEAT))
            {
                Item[] returnItems = {ModItems.flourWheat};
                int[] returnAmounts = {1};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }

            if(ingredientStack.getItem().equals(ModItems.riceRaw))
            {
                Item[] returnItems = {ModItems.flourRice};
                int[] returnAmounts = {1};
                directRecipe(returnItems, returnAmounts, player, ingredientStack, 1);
            }
        }
    }



    private static void processClockmaker(EntityPlayer player) {
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);
        Item ToolItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();

        if(ToolItem.equals(ModItems.clockmakersTools))
        {
        }
    }



    private static void processBlacksmith(EntityPlayer player) {
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);
        Item ToolItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();

        if(ToolItem.equals(ModItems.smithsHammer))
        {
        }
    }



    private static void processGoldsmith(EntityPlayer player) {
        ItemStack ingredientStack = player.getHeldItem(EnumHand.OFF_HAND);
        Item ToolItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();

        if(ToolItem.equals(ModItems.goldsmith))
        {
            if(ingredientStack.getItem().equals(Items.IRON_NUGGET))
            {
                directRecipe(ModItems.ringbase, 1, player, ingredientStack, 4);
            }
        }

    }
}
