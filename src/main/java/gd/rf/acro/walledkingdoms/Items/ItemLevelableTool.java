package gd.rf.acro.walledkingdoms.Items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLevelableTool extends ItemBase {
    public ItemLevelableTool(String name) {
        super(name);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> lore, ITooltipFlag flag) {
        super.addInformation(stack,world,lore,flag);
        try
        {
            lore.add("Tool level: "+stack.getTagCompound().getInteger("level"));
        }catch (Exception ignored){}

    }

}
