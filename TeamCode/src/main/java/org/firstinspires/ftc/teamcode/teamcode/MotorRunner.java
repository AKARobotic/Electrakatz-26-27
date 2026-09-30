package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This class has one job: run the motor.
public class MotorRunner {

    private DcMotor motor;

    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "motor_1");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setPower(double power) {
        motor.setPower(power);
    }

    public double getPower() {
        return motor.getPower();
    }
}
