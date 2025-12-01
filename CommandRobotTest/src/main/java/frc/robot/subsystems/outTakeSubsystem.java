
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

//this should work but not tested. Making the flywheel can ID 24 run
public class outTakeSubsystem extends SubsystemBase {

    public SparkMax wheelMotor; 
    private CommandXboxController m_wheelController;

    public outTakeSubsystem(CommandXboxController xboxController){

    wheelMotor = new SparkMax(24, MotorType.kBrushless);

     m_wheelController = xboxController; 

    } 


    public Command wheelRunCommand(double speed) {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return run(
            () -> { runMotor(speed);
              /* one-time action goes here */
            });
      }

     

      
      private void runMotor (double Wspeed) {
        wheelMotor.set(Wspeed);
    }


}
