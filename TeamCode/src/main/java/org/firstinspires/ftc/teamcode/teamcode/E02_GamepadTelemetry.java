package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E02: Gamepad Telemetry", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
// @Disabled
public class E02_GamepadTelemetry extends LinearOpMode {

    // This is the timer for both of the ops modes.
    private ElapsedTime runtime = new ElapsedTime();

    // This method runs when the driver picks this program. It is the main part of the code.
    @Override
    public void runOpMode() {

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            // gamepad1.x is the button's state RIGHT NOW: true while held, false while not.
            if(gamepad1.x || gamepad2.x) {
                telemetry.addData("X-Status", "X IS PRESSED");
            }else{
                telemetry.addData("X-Status", "X IS NOT PRESSED");
            }

            telemetry.update();
        }
    }
}
