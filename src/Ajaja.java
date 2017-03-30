import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Ajaja {

	// Alustukset
	protected int vaihe;
	protected int puoli;
	private int nopeus = 250;
	private DifferentialPilot pilotti;

	Ajaja(DifferentialPilot pilotti) {
		this.pilotti = pilotti;
	}

	public void setVaihe(int vaihde) {
		this.vaihe = vaihde;
	}

	public int getVaihe() {
		return vaihe;
	}

	public void setPuoli(int puoli) {
		this.puoli = puoli;
	}

	public int getPuoli() {
		return puoli;
	}

	public void setNopeus(int nopeus) {
		this.nopeus = nopeus;
	}

	public int getNopeus() {
		return nopeus;
	}

	// Robotti kaartaa loivasti oikealle
	public void kaarraOikealle() {
		Motor.B.setSpeed(nopeus / 2);
		Motor.A.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Robotti kaartaa loivasti vasemmalle
	public void kaarraVasemmalle() {
		Motor.B.setSpeed(nopeus);
		Motor.A.setSpeed(nopeus / 2);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Robotti kaartaa jyrk‰sti oikealle
	public void jyrkastiOikealle() {
		Motor.B.setSpeed(nopeus / 8);
		Motor.A.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Robotti kaartaa jyrk‰sti vasemmalle
	public void jyrkastiVasemmalle() {
		Motor.B.setSpeed(nopeus);
		Motor.A.setSpeed(nopeus / 8);
		Motor.A.forward();
		Motor.B.forward();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Robotti pys‰htyy
	public void pysahdy() {
		Motor.A.stop(true);
		Motor.B.stop(true);
	}

	// Robotti liikkuu suoraan eteenp‰in
	public void liiku() {
		Motor.A.setSpeed(nopeus);
		Motor.B.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
	}

	// Robotti v‰ist‰‰ estett‰
	public void vaisto() {
		pysahdy();
		kaanny(45);
		pilotti.travel(20);
		kaanny(-120);
	}

	// Robotti k‰‰ntyy tiettyyn kulmaan
	public void kaanny(int kulma) {
		pilotti.rotate(kulma);
	}
}
