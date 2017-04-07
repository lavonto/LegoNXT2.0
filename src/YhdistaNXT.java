import java.io.DataInputStream;
import java.io.IOException;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.*;

/**
 * Ottaa tietokoneelta tulevat muuttujat vastaan.
 * 
 * @author Tuomas Harju
 * @version 1.0
 * @since 5.4.2017
 */
 
public class YhdistaNXT {

	private Ajaja ajaja;

	YhdistaNXT(Ajaja ajaja) {
		this.ajaja = ajaja;
	}
	 /**
	  * Avaa tietovirran ja lukee tietokoneen tietovirtaan laittamat muuttujien arvot. 
	  * Saadut arvot tulostetaan ruutuun ja Lopuksi yhteys suljetaan.
	  */
	public void Yhdista() {

		LCD.clear();
		LCD.drawString("Odotetaan...", 2, 4);
		USBConnection yhteys = USB.waitForConnection();
		LCD.clear();
		LCD.drawString("Yhdistetty!", 3, 4);
		DataInputStream luku = yhteys.openDataInputStream();
		//Datan lukeminen
		try {
			ajaja.setNopeus(luku.readInt());
			ajaja.setPuoli(luku.readUTF());

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Tulostetaan data ruutuun
		LCD.clear();

		LCD.drawString("Nopeus: ", 3, 1);
		LCD.drawInt(ajaja.getNopeus(), 8, 2);
		
		LCD.drawString("Ohituspuoli: ", 3, 3);
		LCD.drawString(ajaja.getPuoli(), 7, 4);
		
		LCD.drawString("Paina ENTER", 3, 6);
		LCD.drawString("Jatkaaksesi", 3, 7);
		
		Button.ENTER.waitForPressAndRelease();
		LCD.clear();
		// Yhteyden sulkeminen
		try {
			luku.close();
			yhteys.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
