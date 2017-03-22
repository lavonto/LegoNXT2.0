
public class Ajoluokka {

	public static void main(String[] args) {

		Runnable ohjaus = new Moottori();
		Thread ohjain = new Thread(ohjaus);
		
		ohjain.start();
	}
}
