package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor; // Look, another library they made so you don't have to know how to talk voltages to a motor.
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="E05: Drive Motors", group="Linear OpMode")
// @Disabled
public class E05_DriveMotor extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    // The motor, there are DcMotors and several other types. Drive motors are DC motors.
    private DcMotor motor;

    @Override
    public void runOpMode() {
        // This is mapping which motor you are going to talk to.
        motor = hardwareMap.get(DcMotor.class, "motor_1");

        // Skip the encoder and set the motor power directly.
        // We will cover what encoders are later.
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // This is setting the direction of the motor. FORWARD means the motor will turn forward when the power is positive.
        // REVERSE means the motor will turn backward when the power is positive.
        motor.setDirection(DcMotor.Direction.FORWARD);

        // This is setting the behavior of the motor when no power is applied. 
        // BRAKE means the motor will resist motion (let go of the stick, instant stop)
        // FLOAT means the motor will freewheel (let go the stick, motor stops slowly eventually)
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            /*
                Stick untouched reads as 0, so the motor is off.
                Positive stick value drives forward. Negative drives backward.

                Here is where reality might bite, if the motor doesn't turn off when no one is touching the the stick, what does that mean?
            */

            // Add both gamepads together so EITHER stick can drive the motor.
            // Clamp keeps the total between -1 and 1 if both sticks are pushed at once.
            double stickY = Range.clip(gamepad1.left_stick_y + gamepad2.left_stick_y, -1, 1);
            motor.setPower(stickY);
            telemetry.addData("Motor Power", motor.getPower());
            telemetry.update();
        }
    }
}
