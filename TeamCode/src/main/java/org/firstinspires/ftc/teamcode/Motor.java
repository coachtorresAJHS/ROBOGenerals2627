package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motor {

    private DcMotor RightFront;
    private DcMotor LeftFront;
    private DcMotor RightBack;
    private DcMotor LeftBack;
    private DcMotor launcher;
    private DcMotor InTake;


    public void init(HardwareMap hwMap){

        RightFront = hwMap.get(DcMotor.class, "RightFront");
        LeftFront = hwMap.get(DcMotor.class,"LeftFront");
        RightBack = hwMap.get(DcMotor.class,"RightBack");
        LeftBack = hwMap.get(DcMotor.class,"LeftBack");
        launcher = hwMap.get(DcMotor.class,"launcher");
        InTake = hwMap.get(DcMotor.class,"InTake");


    }
    public void RF (double power) {
        RightFront.setPower(power);
    }
    public void RB (double power){
        RightBack.setPower(power);

    }
    public void LF (double power){
        LeftFront.setPower(power);
    }
    public void LB (double power){
        LeftBack.setPower(power);
    }
    public void L (double power){
        launcher.setPower(power);

    }
    public void IT (double power){
        InTake.setPower(power);
    }

    }

