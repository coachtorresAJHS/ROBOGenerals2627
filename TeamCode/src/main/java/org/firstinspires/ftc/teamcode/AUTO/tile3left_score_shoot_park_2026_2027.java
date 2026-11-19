package org.firstinspires.ftc.teamcode.AUTO;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.Motor;
import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;
import org.firstinspires.ftc.teamcode.background.Servooo;
import static android.os.SystemClock.sleep;


@Autonomous
public class tile3left_score_shoot_park_2026_2027 extends OpMode
{
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

                // shoot all 4 ball  and turn on transfer
               shoot();
               sleep(3000); // change this on  friday make sure that this is enough  to luanch all 4 balls
                state = "2";
                break;

            case "2":
                // go forward for 12 in
                drive.FWD(0.3);
                if (Y_pos >= 12) {
                    drive.stopplease();
                    state = "3";
                }
                break;

            case "3":
                // face forward 180
                drive.T_L(0.3);
                if (H_pos >= 170) {
                    drive.stopplease();
                    m.T(0);
                    m.L(0);
                    sleep(200);
                    state = "4";
                }
                break;
            case "4":
                //drift right for 38 in
                drive.D_R(0.4);
                if (X_pos >= 31) {
                    drive.stopplease();
                    state = "5";
                }
                break;
            case "5":
                //  lower the gate
                S.S3(1);
                S.S4(0);
                state = "6";
                break;
            case "6":
                // intake power -1 and transfer
                m.T(0.5);
                m.IT(-1);
                state = "7";
                break;
            case "7":
                //  forward  12 in
                drive.FWD(0.3);
                sleep(1500);
                drive.stopplease();
                m.IT(0);
                m.T(0);
                double MyOriginalpos[] = o.getPosition();
                start_x = MyOriginalpos[0];
                state = "8";
                break;
            case "8":
                // then drift for left  for  6 in
                drive.D_L(0.3);
                telemetry.addData("start_x", start_x);
                telemetry.addData("movingpos", o.getPosition()[0]);
                telemetry.addData("bool", o.getPosition()[0] <= start_x - 6);
                telemetry.update();
                if (o.getPosition()[0] <= start_x - 6) {
                    drive.stopplease();
                    start_y = o.getPosition()[1];
                    state = "9b";
                }
                break;
            case "9":
                //  go back for 124 in
                drive.FWD(-0.5);
                if (o.getPosition()[1] >= start_y + 95 - 24) {
                    drive.stopplease();
                    state = "10";
                }
                break;
            case "10":
                //  -45 angle
                drive.T_L(0.3);
                if (H_pos <= 360 - 140) {
                    drive.stopplease();
                    state = "11";
                }
                break;
            case "11":
                // 11 shoot all four balls
                break;
            case "9b":
                drive.T_L(0.15);
                if (H_pos >= -50 & H_pos <= 0) {
                    drive.stopplease();
                    state = "10b";
                }
                break;
            case "10b":
                shoot();
                sleep(3000); // change this on  friday make sure that this is enough  to luanch all 4 balls
                m.L(0);
                m.IT(0);
                m.T(0);
                state = "11b";
                break;
            case "11b":
                drive.T_L(0.15);
                if (H_pos >= 0) {
                    drive.stopplease();
                    state = "12b";
                }
                break;
            case "12b":
                drive.FWD(0.7);
                if (Y_pos >= 100){ // how far to park front side of box  coach torres
                    drive.stopplease();
                    state = "13b";
                }
                break;

            // 11 shoot all four balls
            // 12  drift right for 12 in
        }
    }

    private void shoot(){
        m.L(0.68); // change this on friday or find the perfect speed
        sleep(200);
        m.T(1);
        m.IT(1);
    }
}