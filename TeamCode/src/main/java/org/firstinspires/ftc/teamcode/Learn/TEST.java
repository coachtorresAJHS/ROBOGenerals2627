package org.firstinspires.ftc.teamcode.Learn;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.background.Servooo;
import org.firstinspires.ftc.teamcode.background.Motor;

@TeleOp
public class TEST extends OpMode {

    Motor M = new Motor();
    Servooo S = new Servooo();

    @Override
    public void init() {
        M.init(hardwareMap);

    }

    @Override
    public void loop() {

        M.RF(1);
        M.RB(1);
        M.LF(1);
        M.LB(1);
      //  M.L(1);
        //M.IT(1);
        //S.S1(1);

    }
}
