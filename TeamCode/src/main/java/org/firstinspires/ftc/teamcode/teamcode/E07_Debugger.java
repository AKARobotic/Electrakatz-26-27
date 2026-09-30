package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor; // Only used by Exercise 2.
import com.qualcomm.robotcore.util.ElapsedTime;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E07: Debugger", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
// @Disabled
public class E07_Debugger extends LinearOpMode {

    // This is the timer for both of the ops modes.
    private ElapsedTime runtime = new ElapsedTime();

    // Only used by Exercise 2.
    private TouchSensor touchSensor;

    // This method runs when the driver picks this program. It is the main part of the code.
    @Override
    public void runOpMode() {

        /*
            EXERCISE 1: A mistake Android Studio catches while you type.
            Take the // off the line below. A red squiggle shows up. Hover over it and read the message.
            Fix the line, then look at the red marks in the right edge bar. Put the // back when you are done.
        */
        //int motorPort = "one";
        //telemetery.addData("Status", "Initialized");

        /*
            EXERCISE 2: A mistake that only shows up when the program starts.
            Take the // off the line below and run the program. The code builds, but the program stops at start.
            Read the error. It tells you the name it could not find. Fix the name, then put the // back.
            You have seen this one before, when the name did not match the configuration.
        */
        //touchSensor = hardwareMap.get(TouchSensor.class, "sensor_tuoch");

        /*
            EXERCISE 3: A mistake the computer does not notice. This one is live, no // to remove.
            The motor is running at 1500 out of a max of 3000. That is 50 percent, but the driver hub shows something else.
            Click in the gray strip left of the "int percent" line to set a breakpoint (a red dot).
            Run with the Debug button (the bug icon). The program pauses at the dot.
            Use Step Over to run one line at a time. Watch speed, maxSpeed, and percent in the Variables window.
        */
        int speed = 1500;
        int maxSpeed = 3000;
        int percent = speed / maxSpeed * 100;

        // Stages data to the driver status screen. You can add many of these statements to send data at the same time.
        telemetry.addData("Status", "Initialized");

        // Changes what's on the driver status screen to what you staged.
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Speed", speed);
            telemetry.addData("Max Speed", maxSpeed);
            telemetry.addData("Percent of max (should be 50)", percent);
            telemetry.update();
        }
    }
}
