import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class AaniSensori implements Runnable {

	private UltrasonicSensor uSensori;
	private Ajaja ajaja;

	AaniSensori(UltrasonicSensor uSensori, Ajaja ajaja) {
		this.uSensori = uSensori;
		this.ajaja = ajaja;
	}

	// Käynnistyy säikeen alussa
	public void run() {
		while (!Button.ESCAPE.isDown()) {
			palautaEtaisyys();
		
			if (palautaEtaisyys() < 20) {
				//ajaja.vaisto();
			} else {
				ajaja.liiku();
			}		
		}
	}

	// Tulostaa etäisyyden lähimpään esteeseen robotin näytölle, sekä palauttaa
	// saman arvon
	public int palautaEtaisyys() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LCD.clear();
		System.out.println(uSensori.getDistance());
		return uSensori.getDistance();
	}

}
