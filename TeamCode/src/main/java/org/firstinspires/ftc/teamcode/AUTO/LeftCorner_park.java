package org.firstinspires.ftc.teamcode.AUTO;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;

@Autonomous

public class LeftCorner_park extends OpMode {
    Motor m = new Motor();
    Robot_drive drive = new Robot_drive();
    OTOS o = new OTOS();
    Servooo S = new Servooo();
    double start_x = 0;
    double start_y = 0;
    String state;

    @Override
    public void init() {
        m.init(hardwareMap);
        drive.init(hardwareMap);
        o.init(hardwareMap);
        //telemetry.addLine("hello");
        S.init(hardwareMap);
        state = "1";
        S.S3(.7);
        S.S4(.3);
    }

    @Override
    public void loop() {

        double CurrPos[] = o.getPosition();
        double X_pos = CurrPos[0];
        double Y_pos = CurrPos[1];
        double H_pos = CurrPos[2];
        telemetry.addLine(state);
        telemetry.addData("XPos", X_pos);
        telemetry.addData("YPos", Y_pos);
        telemetry.addData("Angle", H_pos);

        switch (state) {
            case "1":
                drive.FWD(0.3);
                if (Y_pos >= 8) {
                    drive.stopplease();
                    state = "stop";
                }
                break;
        }

    }

}