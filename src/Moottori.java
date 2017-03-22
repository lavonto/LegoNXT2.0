import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;

public class Moottori implements Runnable {

	public void run() {
		// Alustetaan pilotti olio joka saa parametreina renkaan halkaisijan, leveyden ja moottorit)
		DifferentialPilot pilotti = new DifferentialPilot(2.2f, 1.0f, Motor.A, Motor.C);
		Button.waitForAnyPress();
		pilotti.setTravelSpeed(10);
		pilotti.travel(20);
		pilotti.travel(3);
		pilotti.stop();

	}

}
