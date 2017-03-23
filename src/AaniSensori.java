import lejos.nxt.UltrasonicSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class AaniSensori implements Runnable {

	private UltrasonicSensor uSensori;
	private Ajaja ajaja;

	AaniSensori(UltrasonicSensor uSensori, Ajaja ajaja) {
		this.uSensori = uSensori;
		this.ajaja = ajaja;
	}

	// käynnistyy säikeen alussa
	public void run() {
		while (!Button.ESCAPE.isDown()) {
			palautaEtaisyys();
		}
	}

	// tulostaa etäisyyden lähimpään esteeseen robotin näytölle, sekä palauttaa
	// saman arvon
	public synchronized int palautaEtaisyys() {

		LCD.clear();
		System.out.println(uSensori.getDistance());
		return uSensori.getDistance();
	}

}
