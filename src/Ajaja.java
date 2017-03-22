import lejos.robotics.navigation.DifferentialPilot;

public class Ajaja implements Runnable {

	private DifferentialPilot pilotti;
	
	Ajaja(DifferentialPilot pilotti) {
		this.pilotti = pilotti;
	}
	
	public void run() {


		while(pilotti.isMoving())Thread.yield(); {

			pilotti.steer(-50, 180, true);
		}

	}
}
