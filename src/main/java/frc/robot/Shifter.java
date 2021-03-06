package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shifter extends Component
{
	DoubleSolenoid shifter;
	boolean current = true;
	boolean past = false;

    public Shifter()
    {
        shifter = new DoubleSolenoid(RobotMap.SHIFTER_HIGH, RobotMap.SHIFTER_LOW);
    }
	
	public void update()
	{
		current = RobotMap.driveController.getRawButton(XboxMap.B);
		
		if(current == true && past == false){
            if(shifter.get() == DoubleSolenoid.Value.kForward)
            {
                shifter.set(DoubleSolenoid.Value.kReverse);
            }
            else
            {
                shifter.set(DoubleSolenoid.Value.kForward);
            }
		}
		SmartDashboard.putBoolean("Gear", shifter.get().equals(DoubleSolenoid.Value.kForward));
		past = current;
	}


	@Override
	public void autoUpdate() 
	{
		
	}


	@Override
	public void disable() 
	{
		
	}
	
	
}
/*package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Shifter extends Component
{
	Solenoid shifter = new Solenoid(RobotMap.SHIFTER_HIGH);
	boolean current = true;
	boolean past = false;
	
	
	public void update()
	{
		current = RobotMap.driveController.getRawButton(XboxMap.B);
		
		if(current == true && past == false){
			shifter.set(!shifter.get());
		}
		past = current;
	}


	@Override
	public void autoUpdate() 
	{
		update();
	}


	@Override
	public void disable() 
	{
		reset();
    }
    
    public void reset()
    {
        //resets everything to default (not extended and upOrDown false)
        //TODO: Check which direction is which :)
        shifter.set(false);
    }
	
	
}
*/
