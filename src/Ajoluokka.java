import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Ajoluokka {

	public static void main(String[] args) {

		// Alustukset
		final DifferentialPilot pilotti;
		final Ajastin ajastin;
		final UltrasonicSensor uSensori;
		final ColorSensor cSensori;
		final Ajaja ajaja;

		// Luodaan oliot
		pilotti = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
		uSensori = new UltrasonicSensor(SensorPort.S1);
		cSensori = new ColorSensor(SensorPort.S2);
		ajaja = new Ajaja(pilotti);
		ajastin = new Ajastin();

		// Tehd‰‰n s‰ie Sensorit -luokasta
		Runnable s = new Sensorit(cSensori, uSensori, ajaja, ajastin);
		Thread sensori = new Thread(s);

		// Ohjelma k‰ynnistyy kun jotain nappia painetaan
		Button.waitForAnyPress();

		// S‰ie starttaa
		sensori.start();
	}
}
