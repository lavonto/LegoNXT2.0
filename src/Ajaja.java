import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.UltrasonicSensor;

public class Ajaja implements Runnable {

	// Ajaja ohjaa robottia.
	private DifferentialPilot pilotti;
	private UltrasonicSensor uSensori;
	
	Ajaja(DifferentialPilot pilotti, UltrasonicSensor uSensori) {
		this.pilotti = pilotti;
		this.uSensori = uSensori;
	}
	
	public void run() {

		while(pilotti.isMoving())Thread.yield(); {

		}

	}
	
	public void kaarraOikealle() {
		pilotti.steer(-50);
	}
	
	public void kaarraVasemmalle() {
		pilotti.steer(50);
	}
	
	public void pysaytys() {
		pilotti.stop();
	}
}
