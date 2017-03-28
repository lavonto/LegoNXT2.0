import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;


public class VariSensori implements Runnable {

	private int viivaVari;
	private int viivaMin;
	private int viivaMax;
	private ColorSensor cSensori;
	private Ajaja ajaja;

	public VariSensori(ColorSensor cSensori, Ajaja ajaja) {
		this.cSensori = cSensori;
		this.ajaja = ajaja;
	}

	public void asetaVarit() {

		// Tallennetaan viivan arvo muuttujaan
		System.out.println("Lue viiva");
		Button.waitForAnyPress();
		viivaVari = cSensori.getLightValue();
		Button.waitForAnyPress();
		
		viivaMin = viivaVari - 2;
		viivaMax = viivaVari + 2;
		
	}

	public void run() {
		// Laitetaan RGB Sensorin punainen valo p‰‰lle
		cSensori.setFloodlight(true);
		
		// Tallennetaan v‰rit muuttujaan
		asetaVarit();

		while (!Button.ESCAPE.isDown()) {
			
			if (cSensori.getLightValue() < viivaMin) {
				ajaja.kaarraOikealle();
			} 
			if (cSensori.getLightValue() > viivaMax) {
				ajaja.kaarraVasemmalle();
			}
			if (cSensori.getLightValue() > viivaMin && cSensori.getLightValue() < viivaMax){
				ajaja.liiku();
			}
		}
	}

}
