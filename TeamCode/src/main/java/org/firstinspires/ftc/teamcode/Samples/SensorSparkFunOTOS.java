/*
    SPDX-License-Identifier: MIT

    Copyright (c) 2024 SparkFun Electronics
*/
package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.background.Motor;

/*
 * This OpMode illustrates how to use the SparkFun Qwiic Optical Tracking Odometry Sensor (OTOS)
 *
 * The OpMode assumes that the sensor is configured with a name of "sensor_otos".
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 *
 * See the sensor's product page: https://www.sparkfun.com/products/24904
 */
@TeleOp(name = "Sensor: SparkFun OTOS", group = "Sensor")
public class SensorSparkFunOTOS extends LinearOpMode {
    // Create an instance of the sensor
    SparkFunOTOS myOtos;

    @Override
    public void runOpMode() throws InterruptedException {
        // Get a reference to the sensor
        myOtos = hardwareMap.get(SparkFunOTOS.class, "sensor_otos");

        // All the configuration for the OTOS is done in this helper method, check it out!
        configureOtos();

        // Wait for the start button to be pressed
        waitForStart();

        // Loop until the OpMode ends
        while (opModeIsActive()) {
            // Get the latest position, which includes the x and y coordinates, plus the
            // heading angle
            SparkFunOTOS.Pose2D pos = myOtos.getPosition();

            // Reset the tracking if the user requests it
            if (gamepad1.y) {
                myOtos.resetTracking();
            }

            // Re-calibrate the IMU if the user requests it
            if (gamepad1.x) {
                myOtos.calibrateImu();
            }

            // Inform user of available controls
            telemetry.addLine("Press Y (triangle) on Gamepad to reset tracking");
            telemetry.addLine("Press X (square) on Gamepad to calibrate the IMU");
            telemetry.addLine();

            // Log the position to the telemetry
            telemetry.addData("X coordinate", pos.x
            );
            telemetry.addData("Y coordinate", pos.y);
            telemetry.addData("Heading angle", pos.h);

            // Update the telemetry on the driver station
            telemetry.update();
        }
    }

    private void configureOtos() {
        telemetry.addLine("Configuring OTOS...");
        telemetry.update();

        // Set the desired units for linear and angular measurements. Can be either
        // meters or inches for linear, and radians or degrees for angular. If not
        // set, the default is inches and degrees. Note that this setting is not
        // persisted in the sensor, so you need to set at the start of all your
        // OpModes if using the non-default value.
        // myOtos.setLinearUnit(DistanceUnit.METER);
        myOtos.setLinearUnit(DistanceUnit.INCH);
        // myOtos.setAngularUnit(AnguleUnit.RADIANS);
        myOtos.setAngularUnit(AngleUnit.DEGREES);

        // Assuming you've mounted your sensor to a robot and it's not centered,
        // you can specify the offset for the sensor relative to the center of the
        // robot. The units default to inches and degrees, but if you want to use
        // different units, specify them before setting the offset! Note that as of
        // firmware version 1.0, these values will be lost after a power cycle, so
        // you will need to set them each time you power up the sensor. For example, if
        // the sensor is mounted 5 inches to the left (negative X) and 10 inches
        // forward (positive Y) of the center of the robot, and mounted 90 degrees
        // clockwise (negative rotation) from the robot's orientation, the offset
        // would be {-5, 10, -90}. These can be any value, even the angle can be
        // tweaked slightly to compensate for imperfect mounting (eg. 1.3 degrees).
        SparkFunOTOS.Pose2D offset = new SparkFunOTOS.Pose2D(0, 0, 0);
        myOtos.setOffset(offset);

        // Here we can set the linear and angular scalars, which can compensate for
        // scaling issues with the sensor measurements. Note that as of firmware
        // version 1.0, these values will be lost after a power cycle, so you will
        // need to set them each time you power up the sensor. They can be any value
        // from 0.872 to 1.127 in increments of 0.001 (0.1%). It is recommended to
        // first set both scalars to 1.0, then calibrate the angular scalar, then
        // the linear scalar. To calibrate the angular scalar, spin the robot by
        // multiple rotations (eg. 10) to get a precise error, then set the scalar
        // to the inverse of the error. Remember that the angle wraps from -180 to
        // 180 degrees, so for example, if after 10 rotations counterclockwise
        // (positive rotation), the sensor reports -15 degrees, the required scalar
        // would be 3600/3585 = 1.004. To calibrate the linear scalar, move the
        // robot a known distance and measure the error; do this multiple times at
        // multiple speeds to get an average, then set the linear scalar to the
        // inverse of the error. For example, if you move the robot 100 inches and
        // the sensor reports 103 inches, set the linear scalar to 100/103 = 0.971
        myOtos.setLinearScalar(1.0);
        myOtos.setAngularScalar(1.0);

        // The IMU on the OTOS includes a gyroscope and accelerometer, which could
        // have an offset. Note that as of firmware version 1.0, the calibration
        // will be lost after a power cycle; the OTOS performs a quick calibration
        // when it powers up, but it is recommended to perform a more thorough
        // calibration at the start of all your OpModes. Note that the sensor must
        // be completely stationary and flat during calibration! When calling
        // calibrateImu(), you can specify the number of samples to take and whether
        // to wait until the calibration is complete. If no parameters are provided,
        // it will take 255 samples and wait until done; each sample takes about
        // 2.4ms, so about 612ms total
        myOtos.calibrateImu();

        // Reset the tracking algorithm - this resets the position to the origin,
        // but can also be used to recover from some rare tracking errors
        myOtos.resetTracking();

        // After resetting the tracking, the OTOS will report that the robot is at
        // the origin. If your robot does not start at the origin, or you have
        // another source of location information (eg. vision odometry), you can set
        // the OTOS location to match and it will continue to track from there.
        SparkFunOTOS.Pose2D currentPosition = new SparkFunOTOS.Pose2D(0, 0, 0);
        myOtos.setPosition(currentPosition);

        // Get the hardware and firmware version
        SparkFunOTOS.Version hwVersion = new SparkFunOTOS.Version();
        SparkFunOTOS.Version fwVersion = new SparkFunOTOS.Version();
        myOtos.getVersionInfo(hwVersion, fwVersion);

        telemetry.addLine("OTOS configured! Press start to get position data!");
        telemetry.addLine();
        telemetry.addLine(String.format("OTOS Hardware Version: v%d.%d", hwVersion.major, hwVersion.minor));
        telemetry.addLine(String.format("OTOS Firmware Version: v%d.%d", fwVersion.major, fwVersion.minor));
        telemetry.update();
    }

    /*
     * This OpMode illustrates how to program your robot to drive field relative.  This means
     * that the robot drives the direction you push the joystick regardless of the current orientation
     * of the robot.
     *
     * This OpMode assumes that you have four mecanum wheels each on its own motor named:
     *   front_left_motor, front_right_motor, back_left_motor, back_right_motor
     *
     *   and that the left motors are flipped such that when they turn clockwise the wheel moves backwards
     *
     * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
     *
     */
    @TeleOp(name = "Robot: Field Relative Mecanum Drive", group = "Robot")

    public static class RobotTeleopMecanumFieldRelativeDrive extends OpMode {
        // This declares the four motors needed
        Motor M = new Motor();

        // This declares the IMU needed to get the current direction the robot is facing
        IMU imu;

        @Override
        public void init() {



            imu = hardwareMap.get(IMU.class, "imu");
            // This needs to be changed to match the orientation on your robot
            RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
                    RevHubOrientationOnRobot.LogoFacingDirection.UP;
            RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

            RevHubOrientationOnRobot orientationOnRobot = new
                    RevHubOrientationOnRobot(logoDirection, usbDirection);
            imu.initialize(new IMU.Parameters(orientationOnRobot));
            M.init(hardwareMap);
        }

        @Override
        public void loop() {
            telemetry.addLine("Press A to reset Yaw");
            telemetry.addLine("Hold left bumper to drive in robot relative");
            telemetry.addLine("The left joystick sets the robot direction");
            telemetry.addLine("Moving the right joystick left and right turns the robot");
           // telemetry.addData("Direction",imu.getRobotOrientation(AxesReference.valueOf()));

            // If you press the A button, then you reset the Yaw to be zero from the way
            // the robot is currently pointing
            if (gamepad1.a) {
                imu.resetYaw();
            }
            // If you press the left bumper, you get a drive from the point of view of the robot
            // (much like driving an RC vehicle)
            if (gamepad1.left_bumper) {
                drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            } else {
                driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
            }
        }

        // This routine drives the robot field relative
        private void driveFieldRelative(double forward, double right, double rotate) {
            // First, convert direction being asked to drive to polar coordinates
            double theta = Math.atan2(forward, right);
            double r = Math.hypot(right, forward);

            // Second, rotate angle by the angle the robot is pointing
            theta = AngleUnit.normalizeRadians(theta -
                    imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

            // Third, convert back to cartesian
            double newForward = r * Math.sin(theta);
            double newRight = r * Math.cos(theta);

            // Finally, call the drive method with robot relative forward and right amounts
            drive(newForward, newRight, rotate);
        }

        // Thanks to FTC16072 for sharing this code!!
        public void drive(double forward, double right, double rotate) {
            // This calculates the power needed for each wheel based on the amount of forward,
            // strafe right, and rotate
            double frontLeftPower = forward + right + rotate;
            double frontRightPower = forward - right - rotate;
            double backRightPower = forward + right - rotate;
            double backLeftPower = forward - right + rotate;

            double maxPower = 1.0;
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
            M.LF(maxSpeed * (frontLeftPower / maxPower));
            M.RF(maxSpeed * (frontRightPower / maxPower));
            M.LB(maxSpeed * (backLeftPower / maxPower));
            M.RB(maxSpeed * (backRightPower / maxPower));
        }
    }
}
