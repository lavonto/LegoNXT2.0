import lejos.nxt.Button;
public class Ajastin{

	 long aloitus;
	 long lopetus;
	 long erotus;
	 double kulunutaika;
	
	public void aloitusaika() {
		aloitus = System.currentTimeMillis();
	}
	
	public void lopetusaika() {
		lopetus = System.currentTimeMillis();
	}
	
	public void kulunutaika() {
		erotus = lopetus-aloitus;
		kulunutaika = erotus/1000;
		System.out.println(kulunutaika);
		Button.waitForAnyPress();
	}
	
	

	

}
