import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Ajaja {

	DifferentialPilot pilotti;
	
	Ajaja(DifferentialPilot pilotti) {
		this.pilotti = pilotti;
	}
	
	public void kaarraOikealle() {
		Motor.B.setSpeed(90);
		Motor.A.setSpeed(180);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void kaarraVasemmalle() {
		Motor.B.setSpeed(180);
		Motor.A.setSpeed(90);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pysahdy() {
		Motor.A.stop(true);
		Motor.B.stop(true);
	}

	public void liiku() {

		Motor.A.setSpeed(180);
		Motor.B.setSpeed(180);
		Motor.A.forward();
		Motor.B.forward();
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
