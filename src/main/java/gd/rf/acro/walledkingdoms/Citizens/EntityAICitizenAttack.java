package gd.rf.acro.walledkingdoms.Citizens;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackMelee;

public class EntityAICitizenAttack extends EntityAIAttackMelee {
    private int raiseArmTicks;
    private EntityCitizen citizen;

    public EntityAICitizenAttack(EntityCitizen citizenIn, double speedIn, boolean longMemoryIn) {
        super(citizenIn, speedIn, longMemoryIn);
        this.citizen = citizenIn;
    }


    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        super.resetTask();
        this.citizen.setArmsRaised(false);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        super.updateTask();
        ++this.raiseArmTicks;

        if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
            this.citizen.setArmsRaised(true);
        } else {
            this.citizen.setArmsRaised(false);
        }
    }
}