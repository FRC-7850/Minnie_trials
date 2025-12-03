// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class driveTrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private SparkMax leftFront; 
  private SparkMax rightBack;
  private DifferentialDrive diff;
  private commandXboxControllerDB m_joyStick; 

  public driveTrainSubsystem(commandXboxControllerDB xboxController) {


    setDefaultCommand(joyStickSpeed());
    leftFront = new SparkMax(2, MotorType.kBrushless);
    rightBack = new SparkMax(6, MotorType.kBrushless);
    diff = new DifferentialDrive(leftFront,rightBack);
    m_joyStick = xboxController; 
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command driveCommand(double speed) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> { //runMotor(speed);
          /* one-time action goes here */
        });
  }

  public Command joyStickSpeed() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> { runMotor(m_joyStick.getLeftY(), m_joyStick.getRightX());
                
          /* one-time action goes here */
        });
  }


  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

private void runMotor (double Lspeed, double Rspeed) {
      //leftFront.set(Lspeed);
      //rightBack.set(Rspeed);
      diff.arcadeDrive(Lspeed, Rspeed);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
