package org.firstinspires.ftc.teamcode.AUTO;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;

@Autonomous
public class test_telemetry extends OpMode {
    Motor m = new Motor();
    Robot_drive drive = new Robot_drive();
    OTOS o = new OTOS();
    Servooo S = new Servooo();
    String state;
    @Override
    public void init() {
        m.init(hardwareMap);
        drive.init(hardwareMap);
        o.init(hardwareMap);
        S.init(hardwareMap);

        //Pick starting step\\
        state = "shoot";
        //Pick starting step\\

        telemetry.addLine("good to go");
        telemetry.addData("state",state);



    }

    @Override
    public void loop() {

        // Getting position values from sensor and putting values into array "CurrPos"
        double CurrPos [] =  o.getPosition();
        double X_pos = CurrPos[0];
        double Y_pos = -CurrPos[1];
        double H_pos = CurrPos[2];

        telemetry.addData("XPos",X_pos);
        telemetry.addData("YPos",Y_pos);
        telemetry.addData("Angle",H_pos );

        telemetry.addLine("going");
        telemetry.addData("state",state);

        switch (state){
            case "shoot":
                sleep(5000);
                telemetry.addLine("shooting");
                state = "turn 180";
        break;

            case "turn 180":
                sleep(5000);
                telemetry.addLine("turing");
                state = "drift";
        break;

            case "drift":
                sleep(5000);
                telemetry.addLine("drift");
        break;

        }

    }
}
