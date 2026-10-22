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
    String state;

    @Override
    public void init() {
       //m.init(hardwareMap);
       drive.init(hardwareMap);
       o.init(hardwareMap);
       telemetry.addLine("hello");

      state = "Move Forward";

    }

    @Override
    public void loop() {
        double CurrPos [] =  o.getPosition();
        double X_pos = CurrPos[0];
        telemetry.addData("XPos",X_pos);
        switch (state){
            case "Move Forward":
                if (X_pos >= 54){
                    state = "END";
                }
                if (X_pos >= 30){
                    drive.FWD(.5);
                }
                else {
                    drive.FWD(1);
                }
                break;
            case "END":
                drive.stopplease();
                telemetry.addLine("robotpark");
        }

    }
}
