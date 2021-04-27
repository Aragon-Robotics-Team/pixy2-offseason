// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class PixyTestLEDs extends CommandBase {
  private int r; 
  private int g;
  private int b;

  private double startTime;

  private static final int R_INC = 3;
  private static final int G_INC = 3;
  private static final int B_INC = 3;
  /** Creates a new PixyTestLEDs. */
  public PixyTestLEDs() {
    addRequirements(Robot.pixyCamera);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    r = 0;
    g = 9;
    b = 15;

    Robot.pixyCamera.setLED(r, g, b);

    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    r += R_INC;
    g += G_INC;
    b += B_INC;

    // This annoys joseph because its not HVS
    if (r > 255) {
      r = 0;
    }
    if (g > 255) {
      g = 0;
    }
    if (b > 255) {
      b = 0;
    }

    Robot.pixyCamera.setLED(r, g, b);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.pixyCamera.disableLED();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp() - startTime) > Constants.kLedUpTime;
  }
}
