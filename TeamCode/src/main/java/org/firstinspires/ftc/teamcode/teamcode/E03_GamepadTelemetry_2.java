package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E03: Gamepad Stick", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
// @Disabled
public class E03_GamepadTelemetry_2 extends LinearOpMode {

    // This is the timer for both of the ops modes.
    private ElapsedTime runtime = new ElapsedTime();

    // This method runs when the driver picks this program. It is the main part of the code.
    @Override
    public void runOpMode() {
        // Stages data to the driver status screen. You can add many of these statements to send data at the same time.
        telemetry.addData("Status", "Initialized");

        // Changes what's on the driver status screen to what you staged.
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Left stick: X is left/right, Y is forward/back. Numbers go from -1 to 1.
            // Add both gamepads together so EITHER one can move the numbers.
            double stickX = Range.clip(gamepad1.left_stick_x + gamepad2.left_stick_x, -1, 1);
            double stickY = Range.clip(gamepad1.left_stick_y + gamepad2.left_stick_y, -1, 1);

            telemetry.addData("Stick X", stickX);
            telemetry.addData("Stick Y", stickY);
            telemetry.update();
        }
    }
}
