package org.firstinspires.ftc.teamcode.background;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Motor {

    private DcMotor RightFront;

    private DcMotor LeftFront;
    private DcMotor RightBack;
    private DcMotor LeftBack;
    //private DcMotor launcher;
    private DcMotor InTake;

    private OpMode opMode;

    public Motor(OpMode opMode){
        this.opMode=opMode;
    }

    public void init(HardwareMap hwMap) {

        RightFront = hwMap.get(DcMotor.class, "RightFront");
        LeftFront = hwMap.get(DcMotor.class, "LeftFront");
        RightBack = hwMap.get(DcMotor.class, "RightBack");
        LeftBack = hwMap.get(DcMotor.class, "LeftBack");
        //launcher = hwMap.get(DcMotor.class,"Launcher");
        InTake = hwMap.get(DcMotor.class, "InTake");

        // We set the left motors in reverse which is needed for drive trains where the left
        // motors are opposite to the right ones.
        LeftFront.setDirection(DcMotor.Direction.FORWARD);
        RightFront.setDirection(DcMotor.Direction.REVERSE);
        RightBack.setDirection(DcMotor.Direction.REVERSE);


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

    public void RF(double power) {
        RightFront.setPower(power);
    }

    public void RB(double power) {
        RightBack.setPower(power);

    }

    public void LF(double power) {
        LeftFront.setPower(power);
    }

    public void LB(double power) {
        LeftBack.setPower(power);
    }

    public void L(double power) {
        //launcher.setPower(power);

    }

    public void IT(double power) {
        InTake.setPower(power);
    }


    public void ENC(double distanceInInches) {
        double circumference = Math.PI * 4;
        int targetTicks = (int) ((distanceInInches / circumference) * 537.7);
        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftFront.setTargetPosition(targetTicks);
        LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftFront.setPower(0.5);
        while (LeftFront.isBusy()){
            opMode.telemetry.addData("current position",LeftFront.getCurrentPosition());
            opMode.telemetry.addData("Target position",LeftFront.getTargetPosition());
        }




    }

    public boolean IsBusy (){
        return LeftFront.isBusy();
    }
}
// enc encoder
//4 inches