package org.firstinspires.ftc.teamcode.Learn;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class  gamepadstatus extends OpMode {

    @Override
    public void init() {
        telemetry.addData("connect", "controler");

    }

    @Override
    public void loop() {
        boolean A = gamepad1.a;
        telemetry.addData("a button",A);
        double joystickL = gamepad1.left_stick_y;
        telemetry.addData("joystick",joystickL);
    }
}
