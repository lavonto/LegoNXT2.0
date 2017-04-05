import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;


/**
 * Ajoluokka -luokassa alustetaan ja luodaan oliot luokille DifferentialPilot, Ajastin, UltrasonicSensor,
 * ColorSensor ja Ajaja. Luokassa luodaan s‰ie Sensorit luokasta ja k‰ynnistet‰‰n se. Ohjelman k‰ynnistyess‰ toistetaan
 * ‰‰nitiedosto k‰ytt‰m‰ll‰ Sound -luokan playSample -metodia.
 * 
 * @author Roope Kuikka
 * @version 1.0
 * @since 22.3.2017
 */

public class Ajoluokka {

	public static void main(String[] args) {
	
		// Alustukset
		final DifferentialPilot pilotti;
		final Ajastin ajastin;
		final UltrasonicSensor uSensori;
		final ColorSensor cSensori;
		final Ajaja ajaja;
		final Matrix matrix;
		final YhdistaNXT yhdistaminen;

		// Luodaan oliot
		pilotti = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.B);
		uSensori = new UltrasonicSensor(SensorPort.S1);
		cSensori = new ColorSensor(SensorPort.S2);
		ajaja = new Ajaja(pilotti);
		ajastin = new Ajastin();
		matrix = new Matrix();
		yhdistaminen = new YhdistaNXT(ajaja);

		// Tehd‰‰n s‰ie Sensorit -luokasta
		Runnable s = new Sensorit(cSensori, uSensori, ajaja, ajastin);
		Thread sensori = new Thread(s);

		// Ohjelma k‰ynnistyy
		
		// Animaatio
		matrix.ajaIntro();
		
		//Yhdistaminen
		yhdistaminen.Yhdista();
		
		// S‰ie starttaa
		sensori.start();
		
	}
}
