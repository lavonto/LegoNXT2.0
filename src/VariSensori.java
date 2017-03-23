import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;


public class VariSensori {

	private int mustaVari;
	private int valkoinenVari;
	private int viivaVari;

	// Luodaan ColorSensor olio
	ColorSensor sensori = new ColorSensor(SensorPort.S4);

	public VariSensori() {
		// Laitetaan RGB Sensorin punainen valo p‰‰lle rakentajassa
		sensori.setFloodlight(true);
	}

	public void asetaVarit() {

		// Tallennetaan mustan arvo muuttujaan
		System.out.println("Lue musta");
		Button.waitForAnyPress();
		mustaVari = sensori.getLightValue();
		Button.waitForAnyPress();

		// Tallennetaan valkoisen arvo muuttujaan
		System.out.println("Lue valkoinen");
		Button.waitForAnyPress();
		valkoinenVari = sensori.getLightValue();
		Button.waitForAnyPress();

		// Tallennetaan viivan arvo muuttujaan
		System.out.println("Lue viiva");
		Button.waitForAnyPress();
		viivaVari = sensori.getLightValue();
		Button.waitForAnyPress();

		// Tulostetaan n‰ytˆlle arvot
		System.out.println("Musta on " + mustaVari + ", valkoinen on "
				+ valkoinenVari + " ja viiva on " + viivaVari);
		Button.waitForAnyPress();
	}

	public void run() {
		while (!Button.ESCAPE.isDown()) {
 
			// T‰‰ ei oo siis toimiva systeemi, mietint‰ viel‰ kesken!
			 if (sensori.getLightValue() < mustaVari){ 
				 // K‰‰nny oikealle }
			 }else if (sensori.getLightValue() > valkoinenVari){ 
				 // K‰‰nny vasemmalle
			 }else { 
				 // Mene suoraan t‰ysi‰ jihuu }
			 }
			 

		}
	}
}
