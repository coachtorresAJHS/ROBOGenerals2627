package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.background.Robot_drive;

@TeleOp
public class Ortho_Sam extends OpMode {
    //Robot_drive trollie = new Robot_drive();
    @Override
    public void init() {
        //trollie.init(hardwareMap);

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

        if (gamepad1.left_stick_y != 0) {
            //trollie.FWD(-gamepad1.left_stick_y);
            telemetry.addLine("FORWARD");
        }
        if (gamepad1.right_stick_x != 0) {
            //trollie.T_R(gamepad1.right_stick_x);
            telemetry.addLine("TURN");
        }
        if(gamepad1.left_stick_y != 0){
            //trollie.BWD_Time(-gamepad1.left_stick_y);
        }

        
        }

       /* telemetry.addData("Speed:", gamepad1.left_stick_y);

        trollie.D_L(gamepad1.left_trigger);
        trollie.D_R(gamepad1.right_trigger);

        */




    }
                            /* / CONTROLS \\
    Float FWD_button = gamepad1.left_stick_y;
    Float Turn_button = gamepad1.left_stick_x;
    Float DriftLeft_button = gamepad1.left_trigger;
    Float DriftRight_button = gamepad1.left_trigger;

                            //CONTROL\*\
                             */



