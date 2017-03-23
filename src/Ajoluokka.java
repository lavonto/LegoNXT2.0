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
		
		pilotti = new DifferentialPilot(2.2f, 1.0f, Motor.C, Motor.A);
		uSensori = new UltrasonicSensor(SensorPort.S1);
		ajastin = new Ajastin();
		cSensori = new ColorSensor(SensorPort.S4);

		// Ohjelma käynnistyy kun jotain nappia painetaan.
		Button.waitForAnyPress();
		ajastin.aloitusaika();
		
		Runnable m = new Moottori(pilotti/*, ajastin*/);
		Ajaja a = new Ajaja(pilotti, uSensori);
		AaniSensori s = new AaniSensori(uSensori);
		
		Thread  moottori = new Thread(m);
		Thread ajaja = new Thread(a);

		moottori.start();
		ajaja.start();
		
		ajastin.lopetusaika();
		ajastin.kulunutaika();

			
		


	}
}
