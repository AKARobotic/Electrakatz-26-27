package org.firstinspires.ftc.teamcode.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

// This class has one job: read the touch sensor.
public class TouchButton {

    private TouchSensor sensor;
    private boolean wasDown = false;

    // The main class hands us the hardwareMap, because this class is not an OpMode and has no hardwareMap of its own.
    public void init(HardwareMap hardwareMap) {
        sensor = hardwareMap.get(TouchSensor.class, "sensor_touch");
    }

    // True for one loop each time the button goes down. Call this once per loop.
    public boolean wasPressed() {
        boolean isDown = sensor.isPressed();
        boolean clicked = isDown && !wasDown;
        wasDown = isDown;
        return clicked;
    }
}
