import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Ajoluokka {

	public static void main(String[] args) {

		final DifferentialPilot pilotti;
		final Ajastin ajastin;
		final UltrasonicSensor uSensori;
		final ColorSensor cSensori;
		final Ajaja ajaja;

		pilotti = new DifferentialPilot(2.2f, 7.5f, Motor.C, Motor.A);
		uSensori = new UltrasonicSensor(SensorPort.S1);
		ajastin = new Ajastin();
		cSensori = new ColorSensor(SensorPort.S4);
		ajaja = new Ajaja(pilotti);

		// Ohjelma käynnistyy kun jotain nappia painetaan.
		Button.waitForAnyPress();

		Runnable us = new AaniSensori(uSensori, ajaja);
		Runnable as = new VariSensori(cSensori, ajaja);

		// Thread aanisensori = new Thread(us);
		// aanisensori.start();

	}
}
