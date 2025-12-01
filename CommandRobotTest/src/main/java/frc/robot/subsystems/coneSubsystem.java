package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class coneSubsystem extends SubsystemBase {
    
    public SparkMax coneMotor; 
    private CommandXboxController m_coneController;
    private RelativeEncoder m_coneEncoder;


    public coneSubsystem (CommandXboxController xboxController) { 
     coneMotor = new SparkMax(22, MotorType.kBrushless);

     m_coneController = xboxController; 
    }

    public double coneEncoder() {  
      m_coneEncoder = coneMotor.getEncoder();
      System.out.println(m_coneEncoder.getVelocity());
        return m_coneEncoder.getVelocity(); 
    }


    public Command coneRunCommand(double speed) {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return run(
            () -> { runMotor(speed);
              /* one-time action goes here */
            });
      }

     

      
      private void runMotor (double Cspeed) {
        coneMotor.set(Cspeed);
       
  }
    
}
