package org.firstinspires.ftc.teamcode.background;

import static android.os.SystemClock.sleep;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//@TeleOp
public class Robot_drive {
    Motor m = new Motor();
    OTOS OTOS = new OTOS();



    public void init(HardwareMap hwMap) {

        m.init(hwMap);
        OTOS.init(hwMap);

    }


    /*@Override
    public void loop() {

       // D_L(0.5,2000);
        //FWD(1,5000);

    }
    public void INIT (HardwareMap hwMap){
        m.init(hardwareMap);

    }*/

    public void FWD(double power, long time){ // the "forward" function take variables power and
        m.LF(power);                              // time and and drives forward at speed for that time
        m.LB(power);
        m.RB(power);
        m.RF(power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
    }
    public void BWD(double power, long time){ // the "forward" function take variables power and
        m.LF(0-power);                              // time and and drives forward at speed for that time
        m.LB(0-power);
        m.RB(0-power);
        m.RF(0-power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
    }
    public void T_L( double power, long time){//turn left for "time' miliseconds
        m.LF(0-power);
        m.LB(0-power);
        m.RB(power);
        m.RF(power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
    }
    public void T_R( double power, long time){// turn right for "time" miliseconds
        m.LF(power);
        m.LB(power);
        m.RB(0-power);
        m.RF(0-power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
    }
    public void D_L( double power, long time){// Drift right for "time" miliseconds
        m.LF(0-power);
        m.LB(power);
        m.RB(0-power);
        m.RF(power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);
    }
    public void D_R( double power, long time){// Drift left for "time" miliseconds
        m.LF(power);
        m.LB(0-power);
        m.RB(power);
        m.RF(0-power);
        sleep(time);
        m.LF(0);
        m.LB(0);
        m.RB(0);
        m.RF(0);


    }
    public double x = OTOS.x;
    public void FWD_DIS(double power,double x_dist, Telemetry words){




        while (OTOS.x <= x_dist   ){
            m.LF(power);
            m.RB(power);
            m.LB(power);
            m.RF(power);


        }
        m.LF(0);
        m.RB(0);
        m.LB(0);
        m.RF(0);
    }
}
