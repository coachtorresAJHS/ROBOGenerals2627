package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    private Launcher launcherMechanism;
    private Transfer transferMechanism;
    private Intake   intakeMechanism;

    private DcMotor leftFront,leftBack,rightFront,rightBack;
public void Init(HardwareMap hwMap){
    rightFront = hwMap.get(DcMotor.class, "RightFront");
    leftFront = hwMap.get(DcMotor.class,"LeftFront");
    rightBack = hwMap.get(DcMotor.class,"RightBack");
    leftBack = hwMap.get(DcMotor.class,"LeftBack");
}
}



