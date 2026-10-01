package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp
public class Puppet_SC extends OpMode {
    private CRServo left_intake_servo = null;

    @Override
    public void init() {
        left_intake_servo = hardwareMap.get(CRServo.class, "left_intake_servo");
        left_intake_servo.setPower(0);

    }

    @Override
    public void loop() {
        telemetry.addData("WOnderland","galaxy");
        //left_intake_servo

       /* left_intake_servo.setPower(0);
        sleep(5000);
        left_intake_servo.setPower(1);
        telemetry.addData("status", "stop");
        sleep(5000);*/

        if (gamepad1.a == true){
            left_intake_servo.setPower(1);

        }
        if (gamepad1.a == false){
            left_intake_servo.setPower(0);
        }



    }
}
