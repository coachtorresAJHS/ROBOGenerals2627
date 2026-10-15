package org.firstinspires.ftc.teamcode.background;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Servooo {
    private Servo Servo1;
    private Servo Servo2;
    private Servo Servo3;
    private Servo Servo4;
    private CRServo Servo5;
    private CRServo Servo6;
    private CRServo Servo7;
    private CRServo Servo8;

    public void init(HardwareMap hwMap){
        Servo1 = hwMap.get(Servo.class, "Servo1");
        Servo2 = hwMap.get(Servo.class, "Servo2");
        Servo3 = hwMap.get(Servo.class, "Servo3");
        Servo4 = hwMap.get(Servo.class, "Servo4");
        Servo5 = hwMap.get(CRServo.class, "Servo5");
        Servo6 = hwMap.get(CRServo.class, "Servo6");
        Servo7 = hwMap.get(CRServo.class, "Servo7");
        Servo8 = hwMap.get(CRServo.class, "Servo8");
    }
    public void S1 (double pos){
        Servo1.setPosition(pos);
    }
    public void S2 (double pos){
        Servo2.setPosition(pos);
    }
    public void S3 (double pos){
        Servo3.setPosition(pos);
    }
    public void S4 (double pos){
        Servo4.setPosition(pos);
    }
    public void S5 (double power){
        Servo5.setPower(power);
    }
    public void S6 (double power){
        Servo6.setPower(power);
    }
    public void S7 (double power) {
        Servo7.setPower(power);
    }
    public void S8 (double power){
        Servo8.setPower(power);
    }


}

