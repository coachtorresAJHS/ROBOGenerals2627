package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.Robot_drive;

@TeleOp
public class Ortho extends OpMode {
    Robot_drive trollie = new Robot_drive();
    Motor M = new Motor();
    @Override
    public void init() {
        trollie.init(hardwareMap);

    }

    @Override
    public void loop() {
        trollie.drive(gamepad1.left_stick_y,gamepad1.right_stick_x, gamepad1.left_stick_x);
       /* M.L(gamepad1.right_trigger);
        M.IT(gamepad1.left_trigger);
        
        */


    }


    }

