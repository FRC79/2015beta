/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krunch17.intake;

import krunch17.CommandBase;

/**
 *
 * @author Sebastian
 */
public class RollerTeleop extends CommandBase {
    
    public RollerTeleop() {
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
            intake.roller.enableControl();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        float power = CommandBase.oi.getDPadAxisY(CommandBase.oi.getManipGamepad()) * -1.0f; // Scaling factor
        
        intake.setRoller(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
            intake.roller.disableControl();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
