import java.io.File;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;

/**
 * 
 * Matrix -luokka tulostaa robotin näytölle stringejä asetetun ajan välein
 * 
 * @author Roope Kuikka
 * @version 1.0
 * @since 5.4.2017
 */
public class Matrix {

	// Taulukko, jossa on stringeinä intron rivit
	private String[] rivit = {
			"                ",
			"                ",
			"                ",
			"                ",
			"                ",
			"                ",
			"RWm.  w.k.. .m .",
			"h/..  Q.S..Z.t .",
			"sOt.  D.q..-.' .",
			"x%E.Y n.h..A.A .",
			"gs/.= 8.m..+.) .",
			"</4.f c.t..6.f .",
			"EH,.Y V.¤..v..W.",
			"w5..c /.Q..1..r.",
			"rI..Y p.7..l .7.",
			"VL.   E.e..^ .I.",
			"                ",
			"   Paina ENTER  ",
			"                ",
			"   Versio 1.0   ",
			"                ",
			"|  |(_| | | |>< ",
			"|\\/| _ _|_ _.   ",
			"                ",
	};
	
	/**
	 *  Tulostaa stringit robotin näytölle drawString -metodilla
	 */
	
	// Tulostetaan kuvio robotin näytölle
	public void ajaIntro(){
		
		Sound.playSample(new File("vaisto.wav"));
		
		for (int i = 0; i < rivit.length-6; i++) {
			LCD.clear();
			LCD.drawString(rivit[i+6], 0, 1);
			LCD.drawString(rivit[i+5], 0, 2);
			LCD.drawString(rivit[i+4], 0, 3);
			LCD.drawString(rivit[i+3], 0, 4);
			LCD.drawString(rivit[i+2], 0, 5);
			LCD.drawString(rivit[i+1], 0, 6);
			LCD.drawString(rivit[i], 0, 7);
			odota(200);
		}
		Button.ENTER.waitForPressAndRelease();
		LCD.clear();
	}
	
	/**
	 * Saa robotin odottamaan halutun ajan ennen uusien stringien tulostamista
	 * @param millisek Metodi saa parametrinä ajan
	 */
	
	// Odotetaan 
	public void odota(int millisek){
		try {
			Thread.sleep(millisek);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
