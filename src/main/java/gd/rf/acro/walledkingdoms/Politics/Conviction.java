package gd.rf.acro.walledkingdoms.Politics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.world.World;

public class Conviction {

    public static void addConviction(EntityPlayer player, int days,int severity)
    {
        //a players gains conviction in there city, a timer is set before the outcome is decided
        //the severity weights what the outcome is, higher severity = more likely worse outcome
        World world = player.world;
        Scoreboard scoreboard = world.getScoreboard();
        //scoreboard.getOrCreateScore(player.getCachedUniqueIdString(),scoreboard.getObjective("WK_PlayerConviction")).setScorePoints(days);
    }
}
