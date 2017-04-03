import java.io.File;
import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Sound;

/**
 * 
 * Ajoluokka -luokassa alustetaan ja luodaan oliot luokille DifferentialPilot, Ajastin, UltrasonicSensor,
 * ColorSensor ja Ajaja. Luokassa luodaan s‰ie Sensorit luokasta ja k‰ynnistet‰‰n se. Ohjelman k‰ynnistyess‰ toistetaan
 * ‰‰nitiedosto k‰ytt‰m‰ll‰ Sound -luokan playSample -metodia.
 * 
 * @author Roope Kuikka
 * @version 1.0
 *
 */

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
		Sound.playSample(new File("otus.wav"));
		
		// S‰ie starttaa
		sensori.start();
	}
}
