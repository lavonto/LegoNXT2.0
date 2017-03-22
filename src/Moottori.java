import lejos.nxt.Button;
import lejos.robotics.navigation.DifferentialPilot;

public class Moottori implements Runnable {

	private DifferentialPilot pilotti;
	private Ajastin ajastin;

	Moottori(DifferentialPilot pilotti, Ajastin ajastin) {
		this.pilotti = pilotti;
		this.ajastin = ajastin;
	}
	
	public void run() {
		
		ajastin.aloitusaika();

		pilotti.setTravelSpeed(10);
		pilotti.travel(50);
		pilotti.stop();
		
		ajastin.lopetusaika();
		ajastin.kulunutaika();
		
	}

}
