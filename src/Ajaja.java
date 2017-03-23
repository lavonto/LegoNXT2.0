import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.UltrasonicSensor;

public class Ajaja implements Runnable {

	// Ajaja ohjaa robottia.
	private DifferentialPilot pilotti;
	private UltrasonicSensor uSensori;
	AaniSensori as = new AaniSensori(uSensori);
	
	Ajaja(DifferentialPilot pilotti, UltrasonicSensor uSensori) {
		this.pilotti = pilotti;
		this.uSensori = uSensori;
	}
	
	public void run() {

		/*while(pilotti.isMoving())Thread.yield(); {
			if (as.palautaEtaisyys() < 20){
				vaisto();
			}
			
		}*/

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
	
	public synchronized void vaisto() {
		pysahdy();
		kaanny(45);
		pilotti.travel(10);
		kaanny(-90);
		pilotti.travel(10);
		kaanny(45);
	}

	public synchronized void kaanny(int kulma) {
		pilotti.rotate(kulma);
	}
	
}
