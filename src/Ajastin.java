import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * Ajastin laskee kuluneen ajan kahden pisteen väliltä ja näyttää tuloksen
 * 
 * @author Toni Lavonen
 * @version 1.0
 * @since 29.3.2017
 */
public class Ajastin {

	// Alustukset
	private long aloitus;
	private long lopetus;
	private long erotus;
	private long minuutit;
	private long sekunnit;
	private long kulunutaika;

	// Robotti lähtee liikkeelle viiden sekunnin jälkeen
	// näyttäen jäljellä olevat sekunnit näytöllä
	public void liikkeelleLahto() {

		LCD.drawString("Aloittamiseen", 2, 2);
		for (int i = 5; i > 0; i--) {
			
			LCD.drawString("aikaa " + i + " sec", 3, 3);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LCD.clear();

	}

	/**
	 * Hakee ajan millisekuntteina kutsumalla System.currentTimeMillis() ja
	 * sijoittaa sen muuttujaan long aloitus.
	 */

	// Aloitetaan ajanotto
	public void aloitusaika() {
		// System.currentTimeMillis() palauttaa järjestelmäajan millisekunteina.
		aloitus = System.currentTimeMillis();
	}

	/**
	 * Hakee ajan millisekuntteina kutsumalla System.currentTimeMillis() ja
	 * sijoittaa sen muuttujaan long lopetus.
	 */

	// Lopetetaan ajanotto
	public void lopetusaika() {
		lopetus = System.currentTimeMillis();
	}

	/**
	 * Laskee muuttujien long lopetus ja long aloitus erotuksen ja sijoittaa
	 * arvon muuttujaan double erotus. Jakaa muuttujan double erotus arvon
	 * tuhannella ja asettaa arvon muuttujaan double kulunutaika. Näyttää ajan
	 * robotin näytöllä.
	 * 
	 * @return palauttaa muuttujen kulunutaika
	 */

	// Lasketaan kulunut aika
	public String kulunutaika() {
		erotus = lopetus - aloitus;
		// Erotus on millisekuntteina. Muutetaan erotus sekunneiksi jakamalla
		// arvo tuhannella.
		// Jaetaan arvo tuhannella.
		kulunutaika = erotus / 1000;
		// System.out.println(kulunutaika);
		// Button.waitForAnyPress();
		minuutit = (kulunutaika / 60);
		sekunnit = (kulunutaika) - (minuutit * 60);

		if (kulunutaika < 60) {
			return kulunutaika + " sek";
		} else {
			return minuutit + " min " + sekunnit + " sek";
		}

	}

}
