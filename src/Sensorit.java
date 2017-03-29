import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Sensorit implements Runnable {

	private int viivaVari;
	private int viivaMin;
	private int viivaMax;
	private int jyrkkaMin;
	private int jyrkkaMax;

	private DifferentialPilot pilotti;
	private Ajastin ajastin;
	private UltrasonicSensor uSensori;
	private ColorSensor cSensori;
	private Ajaja ajaja;

	Sensorit(ColorSensor cSensori, UltrasonicSensor uSensori, Ajaja ajaja,
			Ajastin ajastin) {
		this.cSensori = cSensori;
		this.uSensori = uSensori;
		this.ajaja = ajaja;
		this.ajastin = ajastin;
	}

	public void asetaVarit() {
		// Tallennetaan viivan arvo muuttujaan
		System.out.println("Lue viiva");
		Button.waitForAnyPress();
		viivaVari = cSensori.getLightValue();
		Button.waitForAnyPress();

		viivaMin = viivaVari - 2;
		viivaMax = viivaVari + 2;
		jyrkkaMin = viivaVari - 10;
		jyrkkaMax = viivaVari + 10;
	}

	public void run() {
		// Laitetaan RGB Sensorin punainen valo päälle
		cSensori.setFloodlight(true);

		// Tallennetaan värit muuttujaan
		asetaVarit();
		
		// Asetetaan kumman puolen seuraaja
		ajaja.setPuoli(1);
		
		// Asetetaan vaihteenksi 1, jolloin VariSensorin if-lauseet on käytössä
		ajaja.setVaihde(1);
		ajastin.aloitusaika();

		// Puoli 1 == vasemman puolen seuraaja ja puoli 2 == oikean puolen
		// seuraaja
		while (!Button.ESCAPE.isDown()) {
			while (ajaja.getVaihde() == 1) {

				// Vasemman puolen viivan seuraajan kaartamiset
				if (cSensori.getLightValue() > viivaMax
						&& cSensori.getLightValue() <= jyrkkaMax
						&& ajaja.getPuoli() == 1) {
					ajaja.kaarraOikealle();
				}
				if (cSensori.getLightValue() < viivaMin
						&& cSensori.getLightValue() >= jyrkkaMin
						&& ajaja.getPuoli() == 1) {
					ajaja.kaarraVasemmalle();
				}
				if (cSensori.getLightValue() > jyrkkaMax
						&& ajaja.getPuoli() == 1) {
					ajaja.jyrkastiOikealle();
				}
				if (cSensori.getLightValue() < jyrkkaMin
						&& ajaja.getPuoli() == 1) {
					ajaja.jyrkastiVasemmalle();
				}
				

				// Oikean puolen viivan seuraajan kaartamiset
				if (cSensori.getLightValue() < viivaMin
						&& cSensori.getLightValue() >= jyrkkaMin
						&& ajaja.getPuoli() == 2) {
					ajaja.kaarraOikealle();
				}
				if (cSensori.getLightValue() > viivaMax
						&& cSensori.getLightValue() <= jyrkkaMax
						&& ajaja.getPuoli() == 2) {
					ajaja.kaarraVasemmalle();
				}
				if (cSensori.getLightValue() > jyrkkaMax
						&& ajaja.getPuoli() == 2) {
					ajaja.jyrkastiVasemmalle();
				}
				if (cSensori.getLightValue() < jyrkkaMin
						&& ajaja.getPuoli() == 2) {
					ajaja.jyrkastiOikealle();
				}

				// Jos valoarvo viivaMin ja viivaMax arvojen välissä, robotti
				// liikkuu suoraan eteenpäin
				if (cSensori.getLightValue() > viivaMin
						&& cSensori.getLightValue() < viivaMax) {
					ajaja.liiku();
				}
				
				if (uSensori.getDistance() < 20) {
					ajaja.setVaihde(2);

				}
			}
				if (ajaja.getVaihde() == 2) {
					ajaja.vaisto();
					ajaja.setVaihde(3);

				}
				if (ajaja.getVaihde() == 3) {
					while (cSensori.getLightValue() > viivaMax) {
						ajaja.liiku();
					}
					ajaja.setVaihde(1);
				}

				// Jos vaihde on 0, robotti pysähtyy
				if (ajaja.getVaihde() == 0) {
					ajaja.pysahdy();
					ajastin.lopetusaika();
					ajastin.kulunutaika();
				}
			
		}
	}

}
