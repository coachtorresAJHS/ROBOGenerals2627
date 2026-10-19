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
    SparkFunOTOS myOtos;
    int state;

    @Override
    public void init() {
       //m.init(hardwareMap);
       drive.init(hardwareMap);
       o.init(hardwareMap,myOtos);

      state = 0;

    }

    @Override
    public void loop() {
        SparkFunOTOS.Pose2D pos = myOtos.getPosition();
        switch (state){
            case 0:
                //drive.D_L(0.5,1500);
                //drive.FWD(0.5,3200);
                drive.FWD_DIS(0.1,54);
                state = 1;
                //telemetry.addData("XPos",drive.x);

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
