import lejos.nxt.LCD;
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
	protected int vaihe;
	protected int puoli;
	private int nopeus = 250;
	private boolean vaistetty; 
	private boolean ajossa;
	private DifferentialPilot pilotti;

	/**
	 * @param pilotti
	 * Ajaja saa Ajoluoka -luokassa luodun pilotti olion.
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
		LCD.drawString("Oikealle", 1, 2);
		Motor.B.setSpeed(nopeus / 2);
		Motor.A.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
		LCD.clear();
	}

	/**
	 * Hidastaa vasemmanpuoleista moottoria. Asettaa moottori ajotilaan, mik‰
	 * saa robotin kaartamaan vasemmalle.
	 */

	// Robotti kaartaa loivasti vasemmalle
	public void kaarraVasemmalle() {
		LCD.drawString("Vasemmalle", 1, 2);
		Motor.B.setSpeed(nopeus);
		Motor.A.setSpeed(nopeus / 2);
		Motor.A.forward();
		Motor.B.forward();
		LCD.clear();
	}

	/**
	 * Hidastaa oikeanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti oikealle.
	 */

	// Robotti kaartaa jyrk‰sti oikealle
	public void jyrkastiOikealle() {
		LCD.drawString("Jyrkka oikea", 1, 2);
		Motor.A.setSpeed(nopeus + nopeus/2);
		Motor.B.setSpeed(nopeus / 3);
		Motor.A.forward();
		Motor.B.forward();
		LCD.clear();
	}

	/**
	 * Hidastaa vasemmanpuoleista moottoria huomattavasti. Asettaa moottori
	 * ajotilaan, mik‰ k‰‰nt‰‰ robottia tiukasti vasemmalle.
	 */

	// Robotti kaartaa jyrk‰sti vasemmalle
	public void jyrkastiVasemmalle() {
		LCD.drawString("Jyrkka vasen", 1, 2);
		Motor.B.setSpeed(nopeus + nopeus/2);
		Motor.A.setSpeed(nopeus / 3);
		Motor.A.forward();
		Motor.B.forward();
		LCD.clear();
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
		LCD.drawString("Suoraan", 1, 2);
		Motor.A.setSpeed(nopeus);
		Motor.B.setSpeed(nopeus);
		Motor.A.forward();
		Motor.B.forward();
		LCD.clear();
	}

	/**
	 * Ohjaa robotin esteen ohi esteen vasemmalta puolelta.
	 */

	// Robotti v‰ist‰‰ estett‰ vasemmalta
	public void vaistoVasemmalle() {
		pysahdy();
		LCD.drawString("Vasen vaisto", 1, 2);
		pilotti.rotate(45);
		pilotti.travel(12);
		pilotti.rotate(-85);
		setVaistetty(true);
		LCD.clear();
	}

	/**
	 * Ohjaa robotin esteen ohi esteen oikealta puolelta.
	 */

	// Robotti v‰ist‰‰ estett‰ oikealta
	public void vaistoOikealle() {
		pysahdy();
		LCD.drawString("Oikea vaisto", 1, 2);
		pilotti.rotate(-45);
		pilotti.travel(12);
		pilotti.rotate(85);
		setVaistetty(true);
		LCD.clear();
	}

}
