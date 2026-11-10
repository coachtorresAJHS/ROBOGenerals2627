package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Launcher {
    private DcMotor launcherMotor;
    public void RunLauncher(double launcherSpeed){
        launcherMotor.setPower(launcherSpeed);
    }
}
