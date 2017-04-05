import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.USB;

import java.io.*;

import lejos.nxt.*;
import lejos.nxt.comm.*;



public class Yhdista_NXT  {
	double lahetettuNopeus;
	int lahetettuOhituspuoli;
	public void Yhdista(){
		
	      String odotus = "Odotetaan...";
	        String yhdistetty = "Yhdistetty";
	        LCD.clear();
	        LCD.drawString(odotus,0,0);
	      LCD.refresh();
	      USBConnection btc = USB.waitForConnection();       
	      LCD.clear();
	      LCD.drawString(yhdistetty,0,0);
	      LCD.refresh(); 
	      DataInputStream dis = btc.openDataInputStream();
	      DataOutputStream dos = btc.openDataOutputStream();
	      //Tulostetaan data ruutuun
	      LCD.clear();
	      
	         try {
	        	 lahetettuNopeus = dis.readDouble();
	            	lahetettuOhituspuoli = dis.readInt();
	            System.out.println("Noepus: " + lahetettuNopeus);
	            System.out.println("Ohituspuoli: " + lahetettuOhituspuoli);

	         }
	         catch (IOException e){
	            e.printStackTrace();
	         }
	      
	      //
	      //Yhteyden sulkeminen
	      //		
	         Button.waitForAnyPress();
	      try {
	         dis.close();
	         dos.close();
	         btc.close();
	      } 
	      catch (IOException e) {
	         e.printStackTrace();
	      }
	}
   public static void main(String[] args) throws InterruptedException {

   }


}
