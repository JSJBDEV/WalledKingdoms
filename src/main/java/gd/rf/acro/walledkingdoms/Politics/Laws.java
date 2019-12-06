package gd.rf.acro.walledkingdoms.Politics;

import net.minecraftforge.common.DimensionManager;
import org.apache.commons.lang3.RandomUtils;
import scala.Int;
import scala.collection.$colon$plus;

import java.util.*;

import static gd.rf.acro.walledkingdoms.Utils.readLines;

public class Laws {

    public static boolean ProposeLaw(String law,String context,int kingdomNo)
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
        List<String> csv;
        switch (law)
        {
            case "residency":
                if(Arrays.asList(Politics.residency).contains(context))
                {
                    politics.set(3, context);
                }
                break;
            case "revocable":
                if(Arrays.asList(Politics.revocable).contains(context))
                {
                    politics.set(4, context);
                }
                break;
            case "stay":
                try{
                politics.set(5,""+Integer.valueOf(context));
                }catch (Exception ignored){}
                break;
            case "hgoods":
                if(Arrays.asList(Politics.hgoods).contains(context))
                {
                    politics.set(6,context);
                }
                break;
            case "lgoods":
                if(Arrays.asList(Politics.lgoods).contains(context))
                {
                    politics.set(7,context);
                }
                break;
            case "addroute":
                csv = Arrays.asList(politics.get(8).split(","));
                csv.add(context);
                politics.set(8,String.join(",",csv));
                break;
            case "removeroute":
                csv = Arrays.asList(politics.get(8).split(","));
                csv.remove(context);
                politics.set(8,String.join(",",csv));
                break;
            case "auction":
                if(Arrays.asList(Politics.auctions).contains(context))
                {
                    politics.set(10,context);
                }
                break;
            case "land":
                if(Arrays.asList(Politics.land).contains(context))
                {
                    politics.set(11,context);
                }
                break;
            case "gates":
                if(Arrays.asList(Politics.gates).contains(context))
                {
                    politics.set(12,context);
                }
                break;
            case "guards":
                if(Arrays.asList(Politics.guards).contains(context))
                {
                    politics.set(13,context);
                }
                break;
            case "residencytax":
                try{
                    politics.set(14,""+Integer.valueOf(context));
                }catch (Exception ignored){}
                break;
            case "htax":
                try{
                    politics.set(15,""+Integer.valueOf(context));
                }catch (Exception ignored){}
                break;
            case "ltax":
                try{
                    politics.set(16,""+Integer.valueOf(context));
                }catch (Exception ignored){}
                break;
        }
        return true;
    }

}
