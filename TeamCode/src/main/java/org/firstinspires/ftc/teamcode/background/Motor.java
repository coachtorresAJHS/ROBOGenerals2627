package org.firstinspires.ftc.teamcode.background;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

public class Motor {

    private DcMotor RightFront;
    private DcMotor LeftFront;
    private DcMotor RightBack;
    private DcMotor LeftBack;
   // private DcMotor launcher;
   // private DcMotor InTake;


    public void init (HardwareMap hwMap){

        RightFront = hwMap.get(DcMotor.class, "RightFront");
        LeftFront = hwMap.get(DcMotor.class,"LeftFront");
        RightBack = hwMap.get(DcMotor.class,"RightBack");
        LeftBack = hwMap.get(DcMotor.class,"LeftBack");
        //launcher = hwMap.get(DcMotor.class,"launcher");
        //InTake = hwMap.get(DcMotor.class,"InTake");

        // We set the left motors in reverse which is needed for drive trains where the left
        // motors are opposite to the right ones.
        LeftBack.setDirection(DcMotor.Direction.REVERSE);
        LeftFront.setDirection(DcMotor.Direction.REVERSE);

        // This uses RUN_USING_ENCODER to be more accurate.   If you don't have the encoder
        // wires, you should remove these
        LeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LeftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        LeftBack.setZeroPowerBehavior(BRAKE);
        LeftFront.setZeroPowerBehavior(BRAKE);
        RightBack.setZeroPowerBehavior(BRAKE);
        RightFront.setZeroPowerBehavior(BRAKE);






    }
    public void RF (double power) {
        RightFront.setPower(-power);
    }
    public void RB (double power){
        RightBack.setPower(-power);

    }
    public void LF (double power){
        LeftFront.setPower(-power);
    }
    public void LB (double power){
        LeftBack.setPower(-power);
    }
    public void L (double power){
        //launcher.setPower(power);

    }
    public void IT (double power){
        //InTake.setPower(power);
    }

    }

