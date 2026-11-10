package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.background.Motor;

public class Intake {
    private DcMotor intakeMotor;
    public void RunIntake(){
        intakeMotor.setPower(-1);
    }
}
