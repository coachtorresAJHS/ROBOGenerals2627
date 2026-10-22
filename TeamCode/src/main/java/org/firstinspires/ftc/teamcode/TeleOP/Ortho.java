package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;

@TeleOp
public class Ortho extends OpMode {
    Robot_drive trollie = new Robot_drive();
    Motor M = new Motor();
    OTOS O = new OTOS();
    @Override
    public void init() {
        trollie.init(hardwareMap);
        M.init(hardwareMap);
        O.init(hardwareMap);


    }

    @Override
    public void loop() {
        double CurPos [] = O.getPosition();
        double X_Pos = CurPos[0];
        telemetry.addData("XPos:",X_Pos);

        trollie.drive(gamepad1.left_stick_y,gamepad1.right_stick_x, gamepad1.left_stick_x);
        M.L(gamepad2.right_trigger);
        M.IT(-gamepad2.left_trigger);
        telemetry.addData("rightTriger", gamepad2.right_trigger);
    }
    



    }

