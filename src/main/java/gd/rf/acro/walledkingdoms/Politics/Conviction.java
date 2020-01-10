package gd.rf.acro.walledkingdoms.Politics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.util.List;

import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class Conviction {

    //method is called by command class
    public static void applyConviction(EntityPlayer player, String crime,int kingdomNo)
    {
        String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+kingdomNo+"/";
        List<String> politics = readLines(pref+"politics.wk");
        //when a player is convicted they are assigned a scoreboard value in WK_response that tells the command handler
        //what the player is allowed to type, with this, the string crime can be assumed to always be valid
        switch (crime)
        {
            case "no-permit":
                applyPunishment(player,politics.get(17));
                break;
            case "vandalism":
                applyPunishment(player,politics.get(18));
                break;
            case "assault":
                applyPunishment(player,politics.get(19));
                break;
            case "murder":
                applyPunishment(player,politics.get(20));
                break;
            case "theft":
                applyPunishment(player,politics.get(21));
                break;
        }
    }

    private static void applyPunishment(EntityPlayer player, String punishment)
    {
        switch (punishment)
        {
            case "confiscation":
                break;
            case "banishment":
                break;
            case "revocation":
                break;
            case "enemy":
                break;
        }
    }
}
