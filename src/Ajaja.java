import lejos.robotics.navigation.DifferentialPilot;

public class Ajaja implements Runnable {

	// Ajaja ohjaa robottia.
	private DifferentialPilot pilotti;
	
	Ajaja(DifferentialPilot pilotti) {
		this.pilotti = pilotti;
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
