// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import java.util.HashMap;

import io.github.pseudoresonance.pixy2api.Pixy2;

// Displays Pixy2 Error codes nicely
// https://docs.pixycam.com/wiki/doku.php?id=wiki:v2:full_api
public class ErrorLogger {
  private static HashMap<Byte, String> errorCodes;

  public ErrorLogger() {
      errorCodes = new HashMap<Byte, String>();

      // Byte to error code name map
      errorCodes.put((byte) -1, "PIXY_RESULT_ERROR");
      errorCodes.put((byte) -2, "PIXY_RESULT_BUSY");
      errorCodes.put((byte) -3, "PIXY_RESULT_CHECKSUM_ERROR");
      errorCodes.put((byte) -4, "PIXY_RESULT_TIMEOUT");
      errorCodes.put((byte) -5, "PIXY_RESULT_BUTTON_OVERRIDE");
      errorCodes.put((byte) -6, "PIXY_RESULT_PROG_CHANGING");
  }

  public void logErrorIfExists(byte errorCode) {
    if (errorCode != Pixy2.PIXY_RESULT_OK) {
      System.out.printf("[PIXY ERROR] CODE: %s\n", errorCodes.get(errorCode));
    }
  }
}
