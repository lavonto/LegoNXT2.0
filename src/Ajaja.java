import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Ajaja luokka sis‰lt‰‰ robotin ajonhallintaan vaikuttavia metodeja.
 * 
 * @author Toni Lavonen
 * @version 1.0
 * @since
 */

public class Ajaja {

	// Alustukset
	protected int vaihe;
	protected int puoli;
	private int nopeus = 250;
	private DifferentialPilot pilotti;

	/**
	 * @param pilotti
	 *            Ajaja saa Ajoluoka -luokassa luotu pilotti olion.
	 */

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

	/**
	 * Hidastaa oikeanpuoleista moottoria. Asettaa moottori ajotilaan, mik‰ saa
	 * robotin kaartamaan oikealle.
	 */

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

	/**
	 * Hidastaa vasemmanpuoleista moottoria. Asettaa moottori ajotilaan, mik‰
	 * saa robotin kaartamaan vasemmalle.
	 */

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

	/**
	 * Hidastaa oikeanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti oikealle.
	 */

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

	/**
	 * Hidastaa vasemmanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti vasemmalle.
	 */

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

	/**
	 * Pys‰ytt‰‰ molemmat moottorit v‰littˆm‰sti.
	 */

	// Robotti pys‰htyy
	public void pysahdy() {
		Motor.A.stop(true);
		Motor.B.stop(true);
	}

	/**
	 * Asettaa moottorien nopeudet samanarvoisiksi. Asettaa moottorit ajotilaan.
	 */

	// Robotti liikkuu suoraan eteenp‰in
	public void liiku() {
		Motor.A.setSpeed(nopeus);
		Motor.B.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * Ohjaa robotin esteen ohi esteen vasemmalta puolelta.
	 */

	// Robotti v‰ist‰‰ estett‰ vasemmalta
	public void vaistoVasemmalle() {
		pysahdy();
		pilotti.rotate(45);
		pilotti.travel(20);
		pilotti.rotate(-120);
		pilotti.rotate(45);
		pilotti.travel(15);
		pilotti.rotate(-120);
	}

	/**
	 * Ohjaa robotin esteen ohi esteen oikealta puolelta.
	 */

	public void vaistoOikealle() {
		pysahdy();
		pilotti.rotate(-45);
		pilotti.travel(15);
		pilotti.rotate(120);
	}

}
