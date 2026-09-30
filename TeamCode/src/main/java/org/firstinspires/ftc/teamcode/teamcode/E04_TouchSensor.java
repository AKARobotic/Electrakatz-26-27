package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor; // Remember, you don't have to do the work to communicate with the touch sensor, FTC did, you just use it.
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="E04: Touch Sensor", group="Linear OpMode")
// @Disabled
public class E04_TouchSensor extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    // The touch sensor. Name it "sensor_touch" in the robot configuration.
    private TouchSensor touchSensor;

    @Override
    public void runOpMode() {

        /* 
            This is the first time we're doing hardware. BEFORE RUNNING THIS, make sure the following is done.
            1. On the driver hub, make sure the "example" robot configuration profile is active. The hub will restart. That is normal.
                - Thewre should be a digital device called "REV Touch Sensor" and named exactly "sensor_touch".
                - Plug touch sensor into digital port 0/1. I2C is right next to it and fits the cord, don't do that.
            
        */
        touchSensor = hardwareMap.get(TouchSensor.class, "sensor_touch");

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Show PRESSED when the button is pushed, otherwise NOT PRESSED.
            if (touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "PRESSED");
            } else {
                telemetry.addData("Touch Sensor", "NOT PRESSED");
            }
            telemetry.update();
        }
    }
}
