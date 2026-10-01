package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class shawn_test extends OpMode {
    @Override
    public void init() {
        int teamnumber = 3479;
        double motorspeed = 0.43;
        boolean clawclosed = true;

        telemetry.addData("team number",teamnumber);
    }

    @Override
    public void loop() {

    }
}
