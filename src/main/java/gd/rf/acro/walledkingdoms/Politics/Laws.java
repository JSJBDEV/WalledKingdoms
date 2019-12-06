package gd.rf.acro.walledkingdoms.Politics;

import net.minecraftforge.common.DimensionManager;
import org.apache.commons.lang3.RandomUtils;
import scala.collection.$colon$plus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class Laws {

    public static boolean ProposeLaw(String law,Object context,int kingdomNo)
    {
        String pref = DimensionManager.getCurrentSaveRootDirectory() + "/WalledKingdoms/"+kingdomNo+"/";
        List<String> politics = readLines(pref+"politics.wk");
        int votes = 0;
        switch (politics.get(0))
        {
            case "Republic of": //adjusted by alignments of all citizens
                votes = RandomUtils.nextInt(0,51);
                if(votes<25)
                {
                    return false;
                }
                break;
            case "Demarchy of": //adjusted by political alignment of 5 random citizens
                votes = RandomUtils.nextInt(0,5);
                if(votes<3)
                {
                    return false;
                }
                break;
            case "Federation of": //adjusted by political alignment of governors
                votes = RandomUtils.nextInt(0,11);
                if(votes<5)
                {
                    return false;
                }
                break;
            default:
                //nothing happens
        }
        //if the vote passed, carry on to the actual law application

        switch (law)
        {
            //outcomes of laws go here
        }
        return true;
    }

}
