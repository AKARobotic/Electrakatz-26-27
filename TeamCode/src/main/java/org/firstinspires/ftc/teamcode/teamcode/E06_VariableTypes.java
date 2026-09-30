package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E06: Variable Types", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
@Disabled
public class E06_VariableTypes extends LinearOpMode {

    // This is the timer for both of the ops modes.
    private ElapsedTime runtime = new ElapsedTime();

    // This method runs when the driver picks this program. It is the main part of the code.
    @Override
    public void runOpMode() {
        // int: a whole number, no decimals. Good for counting things.
        // This one lives OUTSIDE the loop so it remembers its value. A variable made inside the loop starts over every time.
        int xPresses = 0;

        // What's wrong with this one?
        int intDivide = 7 / 2;

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // boolean: only true or false. Good for yes/no questions, like "is X held down?"
            // Either gamepad can do it.
            boolean xHeld = gamepad1.x || gamepad2.x;

            // double: the stick gives decimals from -1 to 1, so it needs a double.
            double stickY = Range.clip(gamepad1.left_stick_y + gamepad2.left_stick_y, -1, 1);

            // Forcing the stick into an int chops off the decimal. Only -1, 0, and 1 are left.
            // Push the stick part way and this stays 0.
            int stickAsInt = (int) stickY;

            // Count one press each time X goes down on either gamepad.
            if (gamepad1.xWasPressed() || gamepad2.xWasPressed()) {
                xPresses = xPresses + 1;
            }

            // String: text, in quotes. Good for messages.
            String xStatus;
            if (xHeld) {
                xStatus = "X is down";
            } else {
                xStatus = "X is up";
            }

            telemetry.addData("boolean xHeld", xHeld);
            telemetry.addData("double stickY", stickY);
            telemetry.addData("int stickAsInt", stickAsInt);
            telemetry.addData("int xPresses", xPresses);
            telemetry.addData("String xStatus", xStatus);
            telemetry.addData("int 7 / 2", intDivide);
            telemetry.update();
        }
    }
}
