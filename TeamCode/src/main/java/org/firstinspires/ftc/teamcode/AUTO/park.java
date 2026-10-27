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
       telemetry.addLine("hello");
       S.init(hardwareMap);

      state = "Test";

    }

    @Override
    public void loop() {

        double CurrPos [] =  o.getPosition();
        double X_pos = CurrPos[0];
        double Y_pos = -CurrPos[1];
        telemetry.addData("step",state);
        telemetry.addData("XPos",X_pos);
        telemetry.addData("YPos",Y_pos);
        switch (state){
            case "shoot":
                m.L(0.68);
                sleep(1500);
                m.IT(-1);
                sleep(6000);
                state = "Pick up ball";
                break;
            case "Pick up ball":
                m.L(0);
                drive.FWD_Time(0.3,800);
                drive.D_L_Time(.5,1600);
                drive.T_R_Time(0.5,3000);
                drive.FWD(0.3);
                m.IT(-1);
                S.S1(-1);
                S.S2(1);
                sleep(6000);
                state = "Park";
            case "Park":
                drive.T_L_Time(0.3,1200);
                drive.FWD_Time(-0.5,3500);
                drive.T_L_Time(-0.3,900);
                state = "END";

            case "Move Forward":
                /*if (Y_pos >= 54){
                    state = "END";
                }
                if (X_pos >= 30){
                    drive.FWD(.3);
                }
                else {
                    drive.FWD(.2);
                }

                 */
                drive.FWD_Time(.5, 2000);
                state = "END";
                break;
            case "END":
                drive.stopplease();
                telemetry.addLine("robotpark");
                break;
            case "Test":


                drive.T_L(.5);
                //drive.FWD(1);
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
