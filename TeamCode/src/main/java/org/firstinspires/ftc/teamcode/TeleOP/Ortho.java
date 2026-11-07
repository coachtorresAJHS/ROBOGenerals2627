package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;

@TeleOp
public class Ortho extends OpMode {
    Robot_drive trollie = new Robot_drive();
    Motor M = new Motor();
    OTOS O = new OTOS();
    Servooo S = new Servooo();
    @Override
    public void init() {
        trollie.init(hardwareMap);
        M.init(hardwareMap);
        O.init(hardwareMap);
        S.init(hardwareMap);


    }

    @Override
    public void loop() {
        double CurPos [] = O.getPosition();
        double X_Pos = CurPos[0];
        telemetry.addData("XPos:",X_Pos);

        trollie.drive(-gamepad1.left_stick_y,gamepad1.right_stick_x, gamepad1.left_stick_x);
        //M.L(gamepad2.right_trigger);
        M.IT(-gamepad2.left_trigger);
        if (gamepad2.a){
            M.L(0.60);
        }
        if (gamepad2.b){
            M.L(1);
        }
        if (gamepad2.x){
            M.L(0.70);
        }
        if (gamepad2.y){
            M.L(0.65);
        }
        if (gamepad2.dpad_up){
            M.L(0.55);}
        if (gamepad2.dpad_down){
            M.L(0.50);}
        if (gamepad2.dpad_left){
            M.L(0.45);}
        if (gamepad2.dpad_right) {
            M.L(0.40);
        }
        if (gamepad2.right_bumper)
            M.L(0);
        telemetry.addData("rightTriger", gamepad2.right_trigger);
        M.T(-gamepad2.right_trigger);
       // S.S3(0.88);// 1 is all the way to the floor  half is .88 up is 0.7
        // S.S4(0.12); // 0 is all the way to the floor up is .3  half is .12
        if (gamepad1.y) {
           S.S3(0.7);
           S.S4(0.3);
        }
        if (gamepad1.a) {
            S.S3(1);
            S.S4(0);
        }
        if (gamepad1.x) {
            S.S3(.88);
            S.S4(.12);
        }





    }






    }

