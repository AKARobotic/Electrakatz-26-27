package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E08: Combine Classes", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
// @Disabled
public class E08_CombineClasses extends LinearOpMode {

    // This is the main class. It does not touch hardware. It uses the other classes and decides what happens.
    @Override
    public void runOpMode() {
        // "new" makes one of each class, then init gets it ready.
        TouchButton button = new TouchButton();
        MotorRunner motor = new MotorRunner();
        button.init(hardwareMap);
        motor.init(hardwareMap);

        boolean motorOn = false;

        // Wait for the game to start (driver presses START)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Each press of the touch sensor flips the motor between on and off.
            if (button.wasPressed()) {
                motorOn = !motorOn;
            }

            if (motorOn) {
                motor.setPower(0.5);
            } else {
                motor.setPower(0);
            }

            telemetry.addData("Motor On", motorOn);
            telemetry.addData("Motor Power", motor.getPower());
            telemetry.update();
        }
    }
}
