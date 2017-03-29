import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

/** 
 * <h1>VariSensori</h1>
 * VariSensori -luokkassa käytetään Lego NXT 2.0 -robotin RGB-värisensoria valoarvojen lukemiseen. 
 * Valoarvojen avulla robotti seuraa viivaa radalla. 
 * 
 * Luokassa on kaksi metodia:
 * asetaVarit()
 * 		Luetaan radalla olevan viivan valoarvo RGB-sensorilla ja tallennetaan se muuttujaan viivaVari. 
 *		Muuttujaa viivaVari käytetään viivaMax ja viivaMin muuttujien arvojen laskemiseen. Muuttuja viivaMax on seurattavan
 *		viivan maksimi valoarvo ja muuttuja viivaMin on seurattavan viivan minimi valoarvo. 
 * run()
 *		Asettaa RGB -sensorin valon päälle, jonka jälkeen kutsuu asetaVarit() -metodia. While -loopissa luetaan valoarvoa 
 *		sensorilla ja tutkitaan if -lauseilla onko valoarvo tummempi kuin viivaMin, vaaleampi kuin viivaMax vai onko arvo
 *		tummempi kuin viivaMin ja vaaleampi kuin viivaMax. Jos arvo on tummempi kuin viivaMin, kutsutaan ajaja -luokan 
 *		kaarraOikealle() -metodia ja robotti kaartaa hieman oikealle. Jos arvo on vaaleampi kuin viivaMax, kutsutaan 
 *		ajaja luokan kaarraVasemmalle() -metodia ja robotti kaartaa hieman vasemmalle. Jos arvo on tummempi kuin viivaMin 
 *		ja vaaleampi kuin viivaMax kutsutaan ajaja luokan liiku() -metodia ja robotti liikkuu suoraan eteenpäin. 
 * 
 * @author karoliina1506
 *
 */

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
		// Laitetaan RGB Sensorin punainen valo päälle
		cSensori.setFloodlight(true);
		
		// Tallennetaan värit muuttujaan
		asetaVarit();
		
		// Asetetaan kumman puolen seuraaja
		ajaja.setPuoli(2);
		// Asetetaan vaihteenksi 1, jolloin VariSensorin if-lauseet on käytössä
		ajaja.setVaihde(1);
		
		// Puoli 1 == vasemman puolen seuraaja ja puoli 2 == oikean puolen seuraaja
		while (ajaja.getVaihde() == 1) {	
			
			// Vasemman puolen viivan seuraajan kaartamiset
			if (cSensori.getLightValue() > viivaMax && ajaja.getPuoli() == 1) {
				ajaja.kaarraOikealle();
			} 
			if ((cSensori.getLightValue() < viivaMin && ajaja.getPuoli() == 1) || (cSensori.getLightValue() > viivaMax && ajaja.getPuoli() == 2)) {
				ajaja.kaarraVasemmalle();
			}
			
			// Oikean puolen viivan seuraajan kaartamiset
			if (cSensori.getLightValue() < viivaMin && ajaja.getPuoli() == 2) {
				ajaja.kaarraOikealle();
			}
			if (cSensori.getLightValue() > viivaMax && ajaja.getPuoli() == 2) {
				ajaja.kaarraVasemmalle();
			}
		
			// Jos valoarvo viivaMin ja viivaMax arvojen välissä, robotti liikkuu suoraan eteenpäin
			if (cSensori.getLightValue() > viivaMin && cSensori.getLightValue() < viivaMax){
				ajaja.liiku();				
			}
		}
		
		// Jos vaihde on 0, robotti pysähtyy
		if (ajaja.getVaihde() == 0){
			ajaja.pysahdy();
		}
	}

}
