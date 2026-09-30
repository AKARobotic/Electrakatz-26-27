# Robot code lessons

These files teach the basics of writing robot programs. Start at the top and go in order.

## E01: Basic OpMode

File: `E01_BasicOpsMode.java`

This is an empty robot program. It does not move the robot. It shows the pieces every program needs.

- `@TeleOp` puts the program on the driver hub so a driver can pick it.
- `@Disabled` hides it. Delete that line when you want to run it.
- `runOpMode` is the main part. It runs when the driver picks this program.
- `telemetry` writes **Initialized** on the driver hub screen.
- `waitForStart` waits until the driver presses START.
- The `while` loop keeps running until the driver presses STOP. Later lessons put robot code inside this loop.

## E02: Gamepad

File: `E02_GamepadTelemetry.java`

This program watches the X button on gamepad 1. The driver hub says **X IS PRESSED** or **X IS NOT PRESSED**.

You do not have to memorize every button. While you type, a list pops up. That list is called IntelliSense. It shows the commands you can use.

Type `gamepad` inside the loop. The list shows `gamepad1` (the driver) and `gamepad2` (the helper). Press Enter to insert the one you want.

![Typing gamepad shows gamepad1 and gamepad2](../../../../../res/raw/e02_intellisense_1.png)

Type a dot after `gamepad1`. A new list shows sticks and buttons, such as `left_stick_y` and `a`. Use the arrow keys to move through the list, then press Enter.

![Typing gamepad1. shows sticks and buttons](../../../../../res/raw/e02_intellisense_2.png)

Use this any time you want to see what a gamepad can do.

## E03: Gamepad stick

File: `E03_GamepadTelemetry_2.java`

This program reads the left stick on gamepad 1 and shows the numbers on the driver hub.

- **Stick X** is left and right.
- **Stick Y** is forward and back.
- The numbers go from **-1** to **1**. Let go of the stick and both numbers go back to **0**.

Move the stick and watch the numbers change.

## E04: Touch sensor

File: `E04_TouchSensor.java`

This program reads a touch sensor and shows **PRESSED** or **NOT PRESSED** on the driver hub.

Before you run it, set the robot configuration to the **example** profile on the driver hub. The hub will restart. That is normal.

That profile should have:

- A digital device called **REV Touch Sensor**, named exactly **sensor_touch**.
- Plug the touch sensor into digital port **0/1**. The I2C port is right next to it and the cord fits, but do not plug it in there.

Push the sensor button. The screen changes from **NOT PRESSED** to **PRESSED**.

## E05: Drive motor

File: `E05_DriveMotor.java`

This program runs the goBILDA motor from the **example** profile. In that profile, the motor is configured on port **0** and port **1**.

Each motor needs two cables:

- The power cable.
- The encoder cable. Its plug looks just like the digital cable for the touch sensor. It is not the same port. Plug it into the encoder port next to that motor.

The left stick on gamepad 1 sets the power, and the driver hub shows **Motor Power**.

- Let go of the stick. The number is **0**, so the motor is off.
- A **positive** number runs the motor forward.
- A **negative** number runs it backward.

Three settings change how the motor acts:

- **Mode** is `RUN_WITHOUT_ENCODER`. The stick sets the power directly.
  - An encoder is a counter on the motor. It counts how far the motor shaft has turned.
  - Use an encoder when you want the robot to move a set distance or hold a steady speed. Skip it for stick driving. You want the stick to set the power right away, and using the encoder to control speed can keep the motor from reaching full power.
- **Direction** is `FORWARD`. Positive power turns the motor forward. `REVERSE` flips it, so positive power turns the motor backward.
- **Stop behavior** is `BRAKE`. At power 0, the motor stops right away. `FLOAT` lets it coast and slow down on its own.

## MarcTest: Two motors, exact speed

File: `MarcTest.java`

This program runs two motors, **motor_1** and **motor_2**, and keeps them both spinning at an exact speed. `motor_1` spins forward and `motor_2` spins backward, so the two motors turn opposite ways.

This lesson uses a different motor type: `DcMotorEx` instead of `DcMotor`. `DcMotorEx` can do everything `DcMotor` does, plus a few extra things, including `setVelocity()`. Use the type that has the function you need.

- `setPower()` (from E05) sets how hard the motor pushes, from **-1** to **1**. It does not check how fast the motor actually spins. A heavier robot or a ramp can slow it down even at the same power.
- `setVelocity()` sets an exact speed, in encoder ticks per second. The encoder checks the real speed many times a second, and the motor adjusts its own power to match the target. Push the same robot up a ramp and it speeds up the power on its own to hold the same speed.

Use `setPower()` when you just want the stick to control how hard the motor pushes, like driving. Use `setVelocity()` when the speed itself matters, like a launcher that needs the exact same speed on every shot.

- Both motors start at a target speed of **1000** ticks per second.
- Press **X** and the target goes up by **100**.
- Press **Y** and the target goes down by **100**.
- The driver hub shows the target speed and the real speed of each motor, so you can watch the motors catch up to the target.

## E06: Variable types

File: `E06_VariableTypes.java`

A variable is a named box that holds a value. Every box has a type, and the type decides what can go inside. This program shows four types on the driver hub. Either gamepad works.

- `boolean` holds **true** or **false**. Use it for yes or no questions. Hold X and `xHeld` becomes true.
- `double` holds numbers with decimals. Use it for things like the stick, which reads from **-1** to **1**.
- `int` holds whole numbers only. Use it for counting. `xPresses` goes up by one each time you press X.
- `String` holds text in quotes. Use it for messages. `xStatus` says **X is down** or **X is up**.

Pick the type by asking what the value looks like. Yes or no? `boolean`. A count? `int`. Needs a decimal? `double`. Words? `String`.

Why the type matters:

- Push the stick part way. `stickY` shows a decimal, but `stickAsInt` stays **0**. An `int` chops off the decimal, so a half-pushed stick would look like no push at all.
- `7 / 2` with `int` math gives **3**, not 3.5. `7.0 / 2` with `double` math gives **3.5**. Picking the wrong type gives a wrong answer, and the program does not warn you.
- `xPresses` is made before the loop so it remembers its value. A variable made inside the loop starts over every time the loop runs.

## E07: Debugger

File: `E07_Debugger.java`

Every programmer writes mistakes. This lesson has three, and each one is caught a different way. It uses Android Studio, and no hardware is needed.

**Exercise 1: Android Studio catches it while you type.**

- Take the `//` off the two lines in Exercise 1. Red squiggles show up.
- Hover over a squiggle and read the message. One line puts text in an `int`. The other has a typo.
- This kind of mistake is called a compile error. The program cannot build until you fix it.

**Exercise 2: It builds, but stops when the program starts.**

- Take the `//` off the line in Exercise 2 and run the program. It stops at start, like the touch sensor did before.
- The error names the device it could not find. The name in the code has a typo.

**Exercise 3: The computer does not notice. You use the debugger.**

- The program should show **50** percent, but it shows something else. There is no red squiggle and no crash.
- Click in the gray strip next to the line number to set a **breakpoint**. It is a red dot that pauses the program.
- Run with the **Debug** button (the bug icon). The program pauses at the dot.
- Use **Step Over** to run one line at a time. Watch `speed`, `maxSpeed`, and `percent` in the **Variables** window.
- Once `percent` becomes **0**, look at the line you just ran and think back to E06. Ints drop the decimal, and `1500 / 3000` is **0** before it gets multiplied.
- The fix is to multiply first: `speed * 100 / maxSpeed`. Changing the variables to `double` works too.

Put the `//` back on Exercises 1 and 2 when you finish. Exercise 1 stops the whole project from building, and Exercise 2 stops this program at start.

## E08: Combine classes

Files: `E08_CombineClasses.java`, `TouchButton.java`, `MotorRunner.java`

This program uses the **motor_1** and **sensor_touch** from the **example** profile. Tap the touch sensor to turn the motor on. Tap it again to turn it off.

The code is split into three classes, and each one has a single job:

- `TouchButton` reads the touch sensor. Nothing else.
- `MotorRunner` runs the motor. Nothing else.
- `E08_CombineClasses` is the main class. It uses the other two and decides what happens.

Why split it up?

- When something breaks, you know where to look. The button acts wrong? Open `TouchButton`. The motor spins the wrong way? Open `MotorRunner`.
- `new` makes one of a class. `button.init(hardwareMap)` gets it ready.
- Only the main class has a `hardwareMap`, so it hands it to the others.
- `TouchButton` and `MotorRunner` have no `@TeleOp`, so they do not show up on the driver hub. Only the main class does.

Try it: flip `motor.setDirection` to `REVERSE` in `MotorRunner`. Only that one file changes.

