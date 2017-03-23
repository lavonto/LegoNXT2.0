import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;

public class Moottori implements Runnable {

	private DifferentialPilot pilotti;
	//private Ajastin ajastin;

	Moottori(DifferentialPilot pilotti/*, Ajastin ajastin*/) {
		this.pilotti = pilotti;
		//this.ajastin = ajastin;
	}

	public void run() {

		//ajastin.aloitusaika();
		pilotti.setTravelSpeed(10);
		while (!Button.ESCAPE.isDown()) {
			pilotti.forward();
		}

		//ajastin.lopetusaika();
		//ajastin.kulunutaika();

		// pilotti.stop();

	}

}
