package org.firstinspires.ftc.teamcode.AUTO;

import static android.os.SystemClock.sleep;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;

@Autonomous
public class park extends OpMode {
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
       //telemetry.addLine("hello");
       S.init(hardwareMap);


      state = "shoot";

    }

    @Override
    public void loop() {

        double CurrPos [] =  o.getPosition();
        double X_pos = CurrPos[0];
        double Y_pos = -CurrPos[1];
        double H_pos = CurrPos[2];
        telemetry.addLine(state);
        telemetry.addData("XPos",X_pos);
        telemetry.addData("YPos",Y_pos);
        telemetry.addData("Angle",H_pos );
        //sleep(1500);
        switch (state){
            case "shoot":
                m.L(0.68);
                sleep(1500);
                m.T(-1);
                sleep(6000);
                state = "180";
                break;


            case "Test":
                drive.T_L(0.3);
                if (H_pos >= 170) {
                    drive.stopplease();
                    state = "End";
                }
            break;


            case "Pick up ball":
                S.S3(1);
                S.S4(0);
                m.L(0);
                drive.FWD(0.3);
                m.IT(-1);
                sleep(6000);
                state = "Drift and angle and shoot";
            break;

            case "Drift and angle and shoot ":







            break;



            case "Park":
                drive.FWD(-0.4);
                if (Y_pos >= (100 / 1.5)) {
                    state = "END";
                }
            break;

            case "END":
                drive.stopplease();
                telemetry.addLine("robotpark");
                break;

            case "180":

                //telemetry.addData("Test:", "working");
                //telemetry.addLine("test");

                drive.T_L(0.3);
                if (H_pos >= 170) {
                    drive.stopplease();
                    state = "Drive Right";
                }
            break;

            case "Drive Right":
                drive.D_R(0.4);
                if (X_pos >= (54 / 1.5)) {
                    drive.stopplease();
                    state = "Pick up ball";
                }
            break;


                // 1 shoot all 4 ball go forward for 12 in
            // face forward 180
            // 3 drift right for 54 in
            // 4 lower the gate
            // 5 intake power -1
            // 6 forward  12 in
            // 7 go backward for 12 in
            // 8 then drift for left  for  6 in
            // 9  go back for 124 in
            // 10 -45 angle
            // 11 shoot all four balls
            // 12  drift right for 12 in








        }


    }
}
