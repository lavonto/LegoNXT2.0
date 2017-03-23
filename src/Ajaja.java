import lejos.robotics.navigation.DifferentialPilot;

public class Ajaja {

	private DifferentialPilot pilotti;

	Ajaja(DifferentialPilot pilotti) {
		this.pilotti = pilotti;
	}

	public void kaarraOikealle() {
		pilotti.steer(-50);
	}

	public void kaarraVasemmalle() {
		pilotti.steer(50);
	}

	public void pysahdy() {
		pilotti.stop();
	}

	public void liiku() {
		pilotti.forward();
	}

	public void vaisto() {
		pysahdy();
		kaanny(45);
		pilotti.travel(10);
		kaanny(-90);
		pilotti.travel(10);
		kaanny(45);
	}

	public void kaanny(int kulma) {
		pilotti.rotate(kulma);
	}

}
