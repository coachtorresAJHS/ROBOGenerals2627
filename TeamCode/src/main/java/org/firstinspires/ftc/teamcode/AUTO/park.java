package org.firstinspires.ftc.teamcode.AUTO;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.background.OTOS;
import org.firstinspires.ftc.teamcode.background.Robot_drive;

@Autonomous
public class park extends OpMode {
   //Motor m = new Motor();
    Robot_drive drive = new Robot_drive();
    OTOS o = new OTOS();
    int state;

    @Override
    public void init() {
       //m.init(hardwareMap);
       drive.init(hardwareMap);
       o.init(hardwareMap);

      state = 0;

    }

    @Override
    public void loop() {
        double CurrPos [] =  o.getPosition();
        double X_pos = CurrPos[0];
        switch (state){
            case 0:
                //drive.D_L_Time(0.5,1500);
                //drive.FWD_Time(-0.5,3200);
                drive.FWD_DIS( 1 ,54, X_pos);
                state = 1;
                telemetry.addData("XPos",X_pos);

                break;
            case 1:
                telemetry.addLine("robotpark");
        }


        //sleep(30000);
    }
    @Override
    public void stop() {
    }
}
