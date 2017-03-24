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

		uSensori = new UltrasonicSensor(SensorPort.S1);
		cSensori = new ColorSensor(SensorPort.S2);
		ajaja = new Ajaja();
		ajastin = new Ajastin();

		Runnable us = new AaniSensori(uSensori, ajaja);
		Runnable vs = new VariSensori(cSensori, ajaja);
		Thread aanisensori = new Thread(us);
		Thread varisensori = new Thread(vs);

		// Ohjelma käynnistyy kun jotain nappia painetaan.
		Button.waitForAnyPress();

		// ajastin.aloitusaika();
		//aanisensori.start();
		varisensori.start();
		
		
	}
}
