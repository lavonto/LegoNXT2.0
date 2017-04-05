import java.io.DataInputStream;
import java.io.IOException;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.USB;
import lejos.nxt.comm.*;

public class YhdistaNXT {

	private Ajaja ajaja;

	YhdistaNXT(Ajaja ajaja) {
		this.ajaja = ajaja;
	}

	public void Yhdista() {

		LCD.clear();
		LCD.drawString("Odotetaan...", 2, 4);
		USBConnection yhteys = USB.waitForConnection();
		LCD.clear();
		LCD.drawString("Yhdistetty!", 3, 4);

		DataInputStream luku = yhteys.openDataInputStream();

		try {
			ajaja.setNopeus(luku.readInt());
			ajaja.setPuoli(luku.readInt());

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Tulostetaan data ruutuun
		LCD.clear();

		LCD.drawString("Nopeus: ", 3, 3);
		LCD.drawInt(ajaja.getNopeus(), 8, 3);
		
		LCD.drawString("Ohituspuoli: ", 3, 4);
		LCD.drawInt(ajaja.getPuoli(), 7, 4);
		
		LCD.drawString("Paina ENTER", 3, 6);
		LCD.drawString("Jatkaaksesi", 3, 6);
		
		Button.ENTER.waitForPressAndRelease();

		// Yhteyden sulkeminen
		try {
			luku.close();
			yhteys.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
