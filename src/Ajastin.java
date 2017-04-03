import lejos.nxt.Button;

/**
 * <h1>Ajastin</h1>
 * <p>
 * Ajastinta k‰ytet‰‰n ajan laskemiseen.
 * </p>
 * <h2>Luokan muuttujat:</h2>
 * <p>
 * private long aloitus private long lopetus private double erotus private
 * double kulunutaika
 * <p>
 * <h2>Luokkan metodit:/
 * <h2>
 * <p>
 * aloitusaika() Sijoittaa sen hetkisen j‰rjestelm‰ajan millisekunteina
 * muuttujaan aloitus lopetusaika() Sijoittaa sen hetkisen j‰rjestelm‰ajan
 * millisekunteina muuttujaan lopetus kulunutaika() Sijoittaa muuttujien aloitus
 * ja lopetus erotuksen muuttujaan erotus Erotus jaetaan tuhannella ja
 * sijoitetaan muuttujaan kulunutaika
 * </p>
 * Ajastin laskee kuluneen ajan kahden pisteen v‰lilt‰ ja n‰ytt‰‰ tuloksen
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

	/**
	 * Hakee ajan millisekuntteina kutsumalla System.currentTimeMillis() ja
	 * sijoittaa sen muuttujaan long aloitus.
	 */

	// Aloitetaan ajanotto
	public void aloitusaika() {
		// System.currentTimeMillis() palauttaa j‰rjestelm‰ajan millisekunteina.
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
	 * tuhannella ja asettaa arvon muuttujaan double kulunutaika. N‰ytt‰‰ ajan
	 * robotin n‰ytˆll‰.
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
		//System.out.println(kulunutaika);
		//Button.waitForAnyPress();
		minuutit = (kulunutaika / 60);
        sekunnit = (kulunutaika) - (minuutit * 60);
        
        if (kulunutaika < 60) {
            return kulunutaika + " sek";
        } else {
            return minuutit + " min " + sekunnit + " sek";
        }
		
		
	}

}
