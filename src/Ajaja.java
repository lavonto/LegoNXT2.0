import lejos.nxt.Motor;

public class Ajaja {

	public void kaarraOikealle() {
		Motor.C.setSpeed(180);
		Motor.A.setSpeed(360);
		Motor.A.forward();
		Motor.C.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void kaarraVasemmalle() {
		Motor.C.setSpeed(360);
		Motor.A.setSpeed(180);
		Motor.A.forward();
		Motor.C.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pysahdy() {
		Motor.A.stop(true);
		Motor.C.stop(true);
	}

	public void liiku() {
		Motor.A.forward();
		Motor.C.forward();
	}

	/*public void vaisto() {
		pysahdy();
		kaanny(45);
		pilotti.travel(10);
		kaanny(-90);
		pilotti.travel(10);
		kaanny(45);
	}

	public void kaanny(int kulma) {
		pilotti.rotate(kulma);
	}*/

}
