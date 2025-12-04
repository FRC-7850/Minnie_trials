package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class intakeSubsystem extends SubsystemBase {
    
    public SparkMax popballMotor; 
    private CommandXboxController  m_popballController;

    public intakeSubsystem(CommandXboxController xboxController){

     popballMotor = new SparkMax(32, MotorType.kBrushless);
     
     m_popballController = xboxController;
    }

   
   public Command popballRunCommand(double speed) {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return run(
            () -> { runMotor(speed);
              /* one-time action goes here */
            });
      }
   
   
   
   
   
    private void runMotor (Double Wspeed) {
        popballMotor.set(Wspeed);
    }
}