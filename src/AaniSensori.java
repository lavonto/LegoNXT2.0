import lejos.nxt.UltrasonicSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class AaniSensori implements Runnable {

	UltrasonicSensor sensori = new UltrasonicSensor(SensorPort.S1);

	//käynnistyy säikeen alussa
	public void run() {
		while (!Button.ESCAPE.isDown()) {
			palautaEtaisyys();
		}
	}

	//tulostaa etäisyyden lähimpään esteeseen robotin näytölle, sekä palauttaa saman arvon
	public synchronized int palautaEtaisyys() {

		LCD.clear();
		System.out.println(sensori.getDistance());
		return sensori.getDistance();
	}

}
