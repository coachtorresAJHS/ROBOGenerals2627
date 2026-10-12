package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
@Autonomous
public class park extends OpMode {
   //Motor m = new Motor();
    Robot_drive drive = new Robot_drive();
    int state;

    @Override
    public void init() {
       //m.init(hardwareMap);
       drive.init(hardwareMap);
      state = 0;
    }

    @Override
    public void loop() {
        switch (state){
            case 0:
                drive.D_L(0.5,1500);
                drive.FWD(0.5,3200);
                state = 1;
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
