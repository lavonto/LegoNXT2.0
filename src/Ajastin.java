import lejos.nxt.Button;

/**
 * <h1>Ajastin</h1>
 * <p>
 * Ajastinta käytetään ajan laskemiseen.
 * 
 * Luokan muuttujat:
 * 	private long aloitus 		
 *  private long lopetus
 *  private double erotus
 *  private double kulunutaika
 *  
 * Luokkan metodit:
 * 	aloitusaika()
 * 		Sijoittaa sen hetkisen järjestelmäajan millisekunteina muuttujaan aloitus
 *  lopetusaika()
 *  	Sijoittaa sen hetkisen järjestelmäajan millisekunteina muuttujaan lopetus
 *  kulunutaika()
 *  	Sijoittaa muuttujien aloitus ja lopetus erotuksen muuttujaan erotus
 *  	Erotus jaetaan tuhannella ja sijoitetaan muuttujaan kulunutaika
 *  </p>
 *  
 * @author Toni Lavonen 
 * @version 1.0
 * @since 29.3.2017
 */
public class Ajastin {

	private long aloitus;
	private long lopetus;
	private double erotus;
	private double kulunutaika;

	public void aloitusaika() {
		// System.currentTimeMillis() palauttaa järjestelmäajan millisekunteina.
		aloitus = System.currentTimeMillis();
	}

	public void lopetusaika() {
		lopetus = System.currentTimeMillis();
	}

	public void kulunutaika() {
		erotus = lopetus - aloitus;
		// Erotus on millisekuntteina. Muutetaan erotus sekunneiksi jakamalla arvo tuhannella.
		kulunutaika = erotus / 1000;
		System.out.println(kulunutaika);
		Button.waitForAnyPress();
	}

}
