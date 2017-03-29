import lejos.nxt.Button;

/**
 * <h1>Ajastin</h1>
 * <p>
 * Ajastinta k‰ytet‰‰n ajan laskemiseen.
 * Luokka sis‰lt‰‰ kolme metodia:
 * 	aloitusaika()
 * 		Sijoittaa kutsuttaessa sen hetkisen j‰rjestelm‰ajan millisekunteina muuttujaan long aloitus
 *  lopetusaika()
 *  	Sijoittaa kutsuttaessa sen hetkisen j‰rjestelm‰ajan millisekunteina muuttujaan long lopetus
 *  kulunutaika()
 *  	Sijoittaa muuttujien aloitus ja lopetus erotuksen muuttujaan double erotus
 *  	Lopuksi jaetaan erotus tuhannella ja sijoitetaan se muuttujaan double kulunutaika
 *  </p>
 *  
 * @author 
 * @version 1.0
 * @since 29.3.2017
 */
public class Ajastin {

	private long aloitus;
	private long lopetus;
	private double erotus;
	private double kulunutaika;

	public void aloitusaika() {
		// System.currentTimeMillis() palauttaa j‰rjestelm‰ajan millisekunteina.
		aloitus = System.currentTimeMillis();
	}

	public void lopetusaika() {
		lopetus = System.currentTimeMillis();
	}

	public void kulunutaika() {
		erotus = lopetus - aloitus;
		// Erotus on millisekuntteina
		kulunutaika = erotus / 1000;
		System.out.println(kulunutaika);
		Button.waitForAnyPress();
	}

}
