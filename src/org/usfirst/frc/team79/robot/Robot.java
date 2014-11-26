
package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {

	Solenoid sol;
	DoubleSolenoid doubleSol;
	PowerDistributionPanel pdp;
	
	public void robotInit() {
		sol = new Solenoid(0);
		doubleSol = new DoubleSolenoid(6, 7);
		pdp = new PowerDistributionPanel();
    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        while(isOperatorControl() && isEnabled()){
        	// Test single solenoid
        	sol.set(true);
        	Timer.delay(1);
        	sol.set(false);
        	Timer.delay(1);
        	
        	// Test double solenoid
        	doubleSol.set(Value.kForward);
        	Timer.delay(1);
        	doubleSol.set(Value.kReverse);
        	Timer.delay(1);
        	doubleSol.set(Value.kOff);
        	Timer.delay(1);
        }
    }
    
    public void testPeriodic() {
    	// Test PDP value readings
    	SmartDashboard.putNumber("VOLTAGE", pdp.getVoltage());
    	SmartDashboard.putNumber("TEMPERATURE", pdp.getTemperature());
    }
    
}
