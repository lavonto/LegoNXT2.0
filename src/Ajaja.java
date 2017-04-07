import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Ajaja luokka sis‰lt‰‰ robotin ajonhallintaan vaikuttavia metodeja.
 * 
 * @author Toni Lavonen
 * @version 1.0
 * @since 22.3.2017
 */

public class Ajaja {

	// Alustukset
	private int vaihe;
	private String puoli;
	private int nopeus;
	private boolean vaistetty;
	private boolean ajossa;
	private DifferentialPilot pilotti;

	/**
	 * @param pilotti
	 *            Ajaja saa Ajoluoka -luokassa luodun pilotti olion.
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

	public void setPuoli(String puoli) {
		this.puoli = puoli;
	}

	public String getPuoli() {
		return puoli;
	}

	public void setNopeus(int nopeus) {
		this.nopeus = nopeus;
	}

	public int getNopeus() {
		return nopeus;
	}

	public void setVaistetty(boolean vaistetty) {
		this.vaistetty = vaistetty;
	}

	public boolean getVaistetty() {
		return vaistetty;
	}

	public void setAjossa(boolean ajossa) {
		this.ajossa = ajossa;
	}

	public boolean getAjossa() {
		return ajossa;
	}

	/**
	 * Hidastaa oikeanpuoleista moottoria. Asettaa moottori ajotilaan, mik‰ saa
	 * robotin kaartamaan oikealle.
	 */

	// Robotti kaartaa loivasti oikealle
	public void kaarraOikealle() {
		Motor.A.setSpeed(nopeus);
		Motor.B.setSpeed(nopeus / 2);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * Hidastaa vasemmanpuoleista moottoria. Asettaa moottori ajotilaan, mik‰
	 * saa robotin kaartamaan vasemmalle.
	 */

	// Robotti kaartaa loivasti vasemmalle
	public void kaarraVasemmalle() {
		Motor.A.setSpeed(nopeus / 2);
		Motor.B.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * Hidastaa oikeanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti oikealle.
	 */

	// Robotti kaartaa jyrk‰sti oikealle
	public void jyrkastiOikealle() {
		Motor.A.setSpeed(nopeus + nopeus / 2);
		Motor.B.setSpeed(nopeus / 3);
		Motor.A.forward();
		Motor.B.forward();
	}

	/**
	 * Hidastaa vasemmanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti vasemmalle.
	 */

	// Robotti kaartaa jyrk‰sti vasemmalle
	public void jyrkastiVasemmalle() {
		Motor.A.setSpeed(nopeus / 3);
		Motor.B.setSpeed(nopeus + nopeus / 2);
		Motor.A.forward();
		Motor.B.forward();
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
		pilotti.travel(12);
		pilotti.rotate(-85);
		setVaistetty(true);
	}

	/**
	 * Ohjaa robotin esteen ohi esteen oikealta puolelta.
	 */

	// Robotti v‰ist‰‰ estett‰ oikealta
	public void vaistoOikealle() {
		pysahdy();
		pilotti.rotate(-45);
		pilotti.travel(12);
		pilotti.rotate(85);
		setVaistetty(true);
	}
}
