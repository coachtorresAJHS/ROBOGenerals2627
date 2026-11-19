package org.firstinspires.ftc.teamcode.AUTO;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;

import static android.os.SystemClock.sleep;

@Autonomous

public class LeftCorner_Drift_Shoot_park extends OpMode {
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
                sleep(20000);
                state = "2";

                break;


            case "2":
                shoot();

                state = "3";

                break;

            case "3":
                drive.D_R(0.5);
                sleep(2000);
                state = "stop";
                break;

        }

    }
    private void shoot(){
        m.L(0.68);
        sleep(200);
        m.T(1);
        m.IT(1);
    }

}