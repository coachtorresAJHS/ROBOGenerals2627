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


      state = "Move Forward";

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
                m.IT(-1);
                sleep(6000);
                state = "Pick up ball";
                break;
            case "turn around":
                drive.T_L(0.5);
                if (H_pos >= 180){
                    drive.stopplease();
                    state = "Drive Right";
                }

            case "Drive Right":
                drive.D_R(0.4);
                if (X_pos >= (54/1.5)){
                    drive.stopplease();
                    state = "Pick up ball";
                }

            case "Pick up ball":
                m.L(0);
                drive.FWD(0.3);
                m.IT(-1);
                S.S1(-1);
                S.S2(1);
                sleep(6000);
                state = "Park";
            case "Park":
               drive.FWD(-0.4);
               if (Y_pos >= (100/1.5)){
                   state = "END";
               }

            case "END":
                drive.stopplease();
                telemetry.addLine("robotpark");
                break;
            case "Test":
                telemetry.addData("y pos", Y_pos);
                telemetry.addData("Test:", "working");
                telemetry.addLine("test");

                drive.FWD(1);
                sleep(5000);
                /*drive.T_R(0.5);
                sleep(5000);
                drive.D_L(0.5);
                sleep(5000);
                drive.D_R(0.5);

                 */




        }


    }
}
