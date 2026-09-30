package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

// Puts this program on the driver station so a driver can pick it and drive the robot.
@TeleOp(name="E01: Basic Linear OpMode", group="Linear OpMode")

// Hides this program so it does not show up on the driver station yet.
@Disabled
public class E01_BasicOpsMode extends LinearOpMode {

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
            // You put your code here to control the robot
        }
    }
}
