import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * <h1>AaniSensori</h1> AaniSensori -luokka tutkii ultra‰‰nisensoria k‰ytt‰en,
 * ett‰ onko l‰hell‰ jokin este, joka robotin tulee v‰ist‰‰.
 * 
 * run() -metodissa tutkitaan et‰isyytt‰ esteeseen ja jos este on asetettua
 * arvoa l‰hemp‰n‰, suorittaa robotti ajaja -luokan vaisto() -metodin
 * 
 * @author roope1301
 * @version 1.0
 * @since 29-03-2017
 */

public class AaniSensori implements Runnable {

	private UltrasonicSensor uSensori;
	private Ajaja ajaja;

	AaniSensori(UltrasonicSensor uSensori, Ajaja ajaja) {
		this.uSensori = uSensori;
		this.ajaja = ajaja;
	}

	// K‰ynnistyy s‰ikeen alussa
	public void run() {
		while (!Button.ESCAPE.isDown()) {

			while (ajaja.getVaihde() == 1) {
				if (uSensori.getDistance() < 20) {
					ajaja.setVaihde(2);
				}
			}

			if (ajaja.getVaihde() == 2) {
				ajaja.vaisto();
				ajaja.setVaihde(3);
			}
		}
	}

	// Tulostaa et‰isyyden l‰himp‰‰n esteeseen robotin n‰ytˆlle, sek‰ palauttaa
	// saman arvon
	// public int palautaEtaisyys() {
	// try {
	// Thread.sleep(200);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// LCD.clear();
	// System.out.println(uSensori.getDistance());
	// return uSensori.getDistance();
}
