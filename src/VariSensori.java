import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

/** 
 * <h1>VariSensori</h1>
 * VariSensori -luokkassa k‰ytet‰‰n Lego NXT 2.0 -robotin RGB-v‰risensoria valoarvojen lukemiseen. 
 * Valoarvojen avulla robotti seuraa viivaa radalla. 
 * 
 * Luokassa on kaksi metodia:
 * asetaVarit()
 * 		Luetaan radalla olevan viivan valoarvo RGB-sensorilla ja tallennetaan se muuttujaan viivaVari. 
 *		Muuttujaa viivaVari k‰ytet‰‰n viivaMax ja viivaMin muuttujien arvojen laskemiseen. Muuttuja viivaMax on seurattavan
 *		viivan maksimi valoarvo ja muuttuja viivaMin on seurattavan viivan minimi valoarvo. 
 * run()
 *		Asettaa RGB -sensorin valon p‰‰lle, jonka j‰lkeen kutsuu asetaVarit() -metodia. While -loopissa luetaan valoarvoa 
 *		sensorilla ja tutkitaan if -lauseilla onko valoarvo tummempi kuin viivaMin, vaaleampi kuin viivaMax vai onko arvo
 *		tummempi kuin viivaMin ja vaaleampi kuin viivaMax. Jos arvo on tummempi kuin viivaMin, kutsutaan ajaja -luokan 
 *		kaarraOikealle() -metodia ja robotti kaartaa hieman oikealle. Jos arvo on vaaleampi kuin viivaMax, kutsutaan 
 *		ajaja luokan kaarraVasemmalle() -metodia ja robotti kaartaa hieman vasemmalle. Jos arvo on tummempi kuin viivaMin 
 *		ja vaaleampi kuin viivaMax kutsutaan ajaja luokan liiku() -metodia ja robotti liikkuu suoraan eteenp‰in. 
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
		// Laitetaan RGB Sensorin punainen valo p‰‰lle
		cSensori.setFloodlight(true);
		
		// Tallennetaan v‰rit muuttujaan
		asetaVarit();
		ajaja.setVaihde(1);

		while (ajaja.getVaihde() == 1) {		
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
		
		if (ajaja.getVaihde() == 0){
			ajaja.pysahdy();
		}
	}

}
