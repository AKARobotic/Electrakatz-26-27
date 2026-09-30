package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx; // DcMotorEx adds setVelocity(), which DcMotor does not have.
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="MarcTest", group="Linear OpMode")
// @Disabled
public class MarcTest extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    // Two motors. Use DcMotorEx (instead of DcMotor) because it can use setVelocity().
    private DcMotorEx motor1;
    private DcMotorEx motor2;

    // The speed both motors try to hold, in encoder ticks per second.
    // X adds 100, but not past 3000. Y subtracts 100, but not below 0.
    private double targetVelocity = 1000;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.get(DcMotorEx.class, "motor_1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor_2");

        // motor1 spins forward, motor2 spins backward, so the two motors turn opposite ways.
        motor1.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.REVERSE);

        // RUN_USING_ENCODER turns the encoder on. setVelocity() needs the encoder to know how fast the motor is really spinning.
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // X on EITHER gamepad speeds both motors up. Y on EITHER gamepad slows both motors down.
            // 3000 is the fastest this motor can go. 0 is stopped.
            if ((gamepad1.xWasPressed() || gamepad2.xWasPressed()) && targetVelocity < 3000) {
                targetVelocity += 100;
            }
            if ((gamepad1.yWasPressed() || gamepad2.yWasPressed()) && targetVelocity > 0) {
                targetVelocity -= 100;
            }

            // setVelocity() tells the motor to hold this exact speed, using the encoder to check itself.
            // This is different from setPower(), which just guesses and does not check.
            motor1.setVelocity(targetVelocity);
            motor2.setVelocity(targetVelocity);

            telemetry.addLine("Push X to add 100 ticks/s, Y to remove 100 ticks/s");

            if (targetVelocity >= 3000) {
                telemetry.addData("Target Velocity", targetVelocity + " (MAX)");
            } else {
                telemetry.addData("Target Velocity", targetVelocity);
            }
            telemetry.addData("Motor1 Velocity", motor1.getVelocity());
            telemetry.addData("Motor2 Velocity", motor2.getVelocity());
            telemetry.update();
        }
    }
}
