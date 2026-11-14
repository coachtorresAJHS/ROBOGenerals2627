package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Idia_Shroud extends OpMode {

    private DcMotor lefty;
    private DcMotor righteousness;

    private DcMotor sky;

    @Override
    public void init() {
        lefty = hardwareMap.get(DcMotor.class, "lefty"); // This tells the robot that lefty is a DC moter
        righteousness = hardwareMap.get(DcMotor.class,"righteousness");
        sky = hardwareMap.get(DcMotor.class,"sky");
        lefty.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addLine("mechanical_device_innitiated");

    }

    @Override
    public void loop() {

        lefty.setPower(gamepad1.left_stick_y);
        righteousness.setPower(gamepad1.right_stick_y);
        if (gamepad1.right_trigger == 0) {
            sky.setPower(-gamepad1.left_trigger);
        }
        if (gamepad1.left_trigger == 0) {
            sky.setPower(gamepad1.right_trigger);
        }

    }
}
