package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
@Autonomous
public class park extends OpMode {
   //Motor m = new Motor();
    Robot_drive drive = new Robot_drive();

    @Override
    public void init() {
       //m.init(hardwareMap);
       drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        drive.D_L(0.5,2000);
        drive.FWD(1,5000);
    }
}
