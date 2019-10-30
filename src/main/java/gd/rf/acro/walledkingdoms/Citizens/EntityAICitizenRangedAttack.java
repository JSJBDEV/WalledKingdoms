package gd.rf.acro.walledkingdoms.Citizens;

import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;

public class EntityAICitizenRangedAttack extends EntityAIAttackRanged {

    private EntityCitizen citizen;
    public EntityAICitizenRangedAttack(EntityCitizen citizen, double p_i1649_2_, int p_i1649_4_, float p_i1649_4_2) {
        super(citizen, p_i1649_2_, p_i1649_4_, p_i1649_4_2);
        this.citizen = citizen;
    }

    @Override
    public void updateTask() {
        super.updateTask();
    }
}
