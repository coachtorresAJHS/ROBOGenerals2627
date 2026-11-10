package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Transfer {
private DcMotor transferMotor;
public void RunTransfer(){
    transferMotor.setPower(-1);
}
}

