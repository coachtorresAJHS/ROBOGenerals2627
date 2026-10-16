package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.background.Robot_drive;

@TeleOp
public class Ortho extends OpMode {
    Robot_drive trollie = new Robot_drive();
    @Override
    public void init() {
        trollie.init(hardwareMap);

    }

    @Override
    public void loop() {
    /* STELLA AND JADE CODE
        if (gamepad1.left_bumper) {
            trollie.FWD(.5);
            telemetry.addLine("Going forward");

        }
        if (gamepad1.right_bumper) {
            trollie.FWD(-0.5);
            telemetry.addLine("Going backward");
        }
        else{
            trollie.stopplease();
            telemetry.addLine("please stop");
        }*/

        trollie.FWD(FWD_button);

    }
                            // CONTROLS \\
    Float FWD_button = gamepad1.left_stick_y;
    Float Turn_button = gamepad1.left_stick_x;
    Float DriftLeft_button = gamepad1.left_trigger;
    Float DriftRight_button = gamepad1.left_trigger;

    }

