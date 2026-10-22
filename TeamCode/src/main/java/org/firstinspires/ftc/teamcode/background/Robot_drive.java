package org.firstinspires.ftc.teamcode.background;

import static android.os.SystemClock.sleep;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//@TeleOp
public class Robot_drive {
    Motor m = new Motor();
   // OTOS OTOS = new OTOS();



    public void init(HardwareMap hwMap) {

        m.init(hwMap);
        //OTOS.init(hwMap);

    }


    /*@Override
    public void loop() {

       // D_L(0.5,2000);
        //FWD(1,5000);

    }
    public void INIT (HardwareMap hwMap){
        m.init(hardwareMap);

    }*/
    public void FWD(double power) {
        m.RF(power);
        m.RB(power);
        m.LB(power);
        m.LF(power);
    }
    public void T_L(double power){
        m.LF(0-power);
        m.LB(0-power);
        m.RB(power);
        m.RF(power);

    }
    public void T_R( double power){
        m.LF(power);
        m.LB(power);
        m.RB(0-power);
        m.RF(0-power);
    }
    public void D_L (double power){
        m.LF(0-power);
        m.LB(power);
        m.RB(0-power);
        m.RF(power);
    }
    public void D_R(double power){
        m.LF(power);
        m.LB(0-power);
        m.RB(power);
        m.RF(0-power);
    }


    public void stopplease(){
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
        }
    public void FWD_Time(double power, long time){ // the "forward" function take variables power and
        FWD(power);
        sleep(time);
        stopplease();
    }
    public void BWD_Time(double power, long time){ // the "forward" function take variables power and
        FWD(0-power);
        sleep(time);
        stopplease();
    }
    public void T_L_Time( double power, long time){//turn left for "time' miliseconds
        T_L(power);
        sleep(time);
        stopplease();
    }
    public void T_R_Time( double power, long time){// turn right for "time" miliseconds
        T_R(power);
        sleep(time);
        stopplease();

    }
    public void D_L_Time( double power, long time){// Drift right for "time" miliseconds
        D_L(power);
        sleep(time);
        stopplease();


    }
    public void D_R_Time( double power, long time){// Drift left for "time" miliseconds
        D_R(power);
        sleep(time);
       stopplease();


    }
    //public double x = OTOS.x;
    public void FWD_DIS(double power,double x_dist, double X_pos) {

        while (X_pos <= x_dist) {
            m.LF(power);
            m.RB(power);
            m.LB(power);
            m.RF(power);
        }
    }
       /* m.LF(0);
        m.RB(0);
        m.LB(0);
        m.RF(0);*/
       public void drive(double forward, double right, double rotate) {
           // This calculates the power needed for each wheel based on the amount of forward,
           // strafe right, and rotate
           double frontLeftPower = forward + right + rotate;
           double frontRightPower = forward - right - rotate;
           double backRightPower = forward + right - rotate;
           double backLeftPower = forward - right + rotate;

           double maxPower = -1.0;
           double maxSpeed = 1.0;  // make this slower for outreaches

           // This is needed to make sure we don't pass > 1.0 to any wheel
           // It allows us to keep all of the motors in proportion to what they should
           // be and not get clipped
           maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
           maxPower = Math.max(maxPower, Math.abs(frontRightPower));
           maxPower = Math.max(maxPower, Math.abs(backRightPower));
           maxPower = Math.max(maxPower, Math.abs(backLeftPower));

           // We multiply by maxSpeed so that it can be set lower for outreaches
           // When a young child is driving the robot, we may not want to allow full
           // speed.
           m.LF(maxSpeed * (frontLeftPower / maxPower));
           m.RF(maxSpeed * (frontRightPower / maxPower));
           m.LB(maxSpeed * (backLeftPower / maxPower));
           m.RB(maxSpeed * (backRightPower / maxPower));
       }
    }


