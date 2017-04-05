import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTConnector;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Yhdista_NXT extends JFrame  {
	
	private DataInputStream dis;
	private DataOutputStream dos;
	private NXTConnector connection;
	
	//nopeus/2*360
	double nopeus = 250;
	int ohitusPuoli = 1;
	
	   
	   public Yhdista_NXT() {
	        initComponents();
	    }
	   public void ohitusPuoliArvo(){
		    if (Checkbox_vasemmalta.isSelected()){
		        ohitusPuoli = 1;
		    }else{
		    ohitusPuoli = 2;
		    }
		}
	   public void Yhdista(){    	    				
			connection = new NXTConnector();
			
			boolean connected = connection.connectTo("usb://");
			if (!connected) {
				System.err.println("Yhdist‰minen ep‰onnistui");
				System.exit(1);
			}

		      dos = new DataOutputStream(connection.getOutputStream());
		      dis = new DataInputStream(connection.getInputStream());
		      

	   }
	   //
	   //datan l‰hetys, vastaanotto ja sulkeminen
	   //
	   public void SuljeJaLaheta(){
		   
		   System.out.println("l‰hetet‰‰n");	
		   /*
		      for(int i = 0; i < 20; i++){
		    	  
		         try {
		            dos.writeInt(i);
		            dos.flush();
		         } 
		         catch (IOException e) {
		            e.printStackTrace();
		         }
		      }
	   */	
		     
		    	  
			         try {
			            dos.writeDouble(nopeus);
			            dos.writeInt(ohitusPuoli);
			            dos.flush();
			         } 
			         catch (IOException e) {
			            e.printStackTrace();
			         }
			      

		   System.out.println("Suljetaan");
		      try {
		         dis.close();
		         dos.close();
		         connection.close();
		      }
		      catch (IOException e) {
		         e.printStackTrace();
		      }
			         
		      System.exit(1);		   
	   }
	   //
	   //Generoitu
	   //
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        Button_yhdista = new javax.swing.JButton();
	        Button_valmis = new javax.swing.JButton();
	        jPanel1 = new javax.swing.JPanel();
	        Checkbox_vasemmalta = new javax.swing.JCheckBox();
	        Checkbox_oikealta = new javax.swing.JCheckBox();
	        jPanel2 = new javax.swing.JPanel();
	        Label_nopeus = new javax.swing.JLabel();
	        Slider_nopeus = new javax.swing.JTextField();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        Button_yhdista.setText("Yhdist‰");
	        Button_yhdista.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                Button_yhdistaMouseClicked(evt);
	            }
	        });

	        Button_valmis.setText("L‰het‰ ja sulje");
	        Button_valmis.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                Button_valmisMouseClicked(evt);
	            }
	        });

	        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Esteen kierto"));

	        Checkbox_vasemmalta.setSelected(true);
	        Checkbox_vasemmalta.setText("Vasemmalta");
	        Checkbox_vasemmalta.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                Checkbox_vasemmaltaMouseClicked(evt);
	            }
	        });

	        Checkbox_oikealta.setText("Oikealta");
	        Checkbox_oikealta.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                Checkbox_oikealtaMouseClicked(evt);
	            }
	        });

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(Checkbox_vasemmalta)
	                    .addComponent(Checkbox_oikealta))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addComponent(Checkbox_vasemmalta)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(Checkbox_oikealta))
	        );

	        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nopeus"));

	        Label_nopeus.setText("astetta sekunnissa");

	        Slider_nopeus.setText("250");
	        Slider_nopeus.addKeyListener(new java.awt.event.KeyAdapter() {

	            public void keyReleased(java.awt.event.KeyEvent evt) {
	                Slider_nopeusKeyReleased(evt);
	            }

	        });

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(4, 4, 4)
	                .addComponent(Slider_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(Label_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                .addGap(6, 6, 6)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Slider_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Label_nopeus))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Button_yhdista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Button_valmis, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(9, 9, 9)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Button_yhdista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Button_valmis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>               
	   //
	   //Generoitu
	   //
	    private void Checkbox_vasemmaltaMouseClicked(java.awt.event.MouseEvent evt) {                                                 
	        Checkbox_oikealta.setSelected(false);

	        ohitusPuoliArvo();
	    }                                                

	    private void Checkbox_oikealtaMouseClicked(java.awt.event.MouseEvent evt) {                                               
	        Checkbox_vasemmalta.setSelected(false);

	                ohitusPuoliArvo();
	                
	    }                                              
/*
	    private void Slider_nopeusStateChanged(javax.swing.event.ChangeEvent evt) {                                           
	       nopeus = Math.round(Double.parseDouble(Slider_nopeus.getText()));
	        Label_nopeus.setText(Double.toString(nopeus/2)+" x rengaan pyˆr‰hdyst‰ sekunnissa");
	    } 
	    */

	    private void Button_valmisMouseClicked(java.awt.event.MouseEvent evt) {                                           
	        //L‰hetet‰‰n robottiin       
	        System.out.print("Nopeus: "+nopeus+"∞/s");
	        System.out.print("Ohituspuoli: "+ohitusPuoli);
	        System.out.print("Paina mit‰ tahansa nappia...");
	        SuljeJaLaheta();
	    }                                          

	    private void Button_yhdistaMouseClicked(java.awt.event.MouseEvent evt) {                                            
	        //Yhdistet‰‰n robottiin
	    	Yhdista();
	    }                                           

	    private void Slider_nopeusKeyReleased(java.awt.event.KeyEvent evt) {                                          
		       nopeus = Double.parseDouble(Slider_nopeus.getText());
		       System.out.println(nopeus);
	    }      
	    
	    /**
	     * @param args the command line arguments
	     */ 
	    public static void main(String args[]) {
	        //Button_yhdista.setEnabled(false);
	        
	        
	        
	        
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Yhdista_NXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Yhdista_NXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Yhdista_NXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Yhdista_NXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Yhdista_NXT().setVisible(true);
	            }
	        });
	    }
	    // Variables declaration - do not modify                     
	    private javax.swing.JButton Button_valmis;
	    private javax.swing.JButton Button_yhdista;
	    private javax.swing.JCheckBox Checkbox_oikealta;
	    private javax.swing.JCheckBox Checkbox_vasemmalta;
	    private javax.swing.JLabel Label_nopeus;
	    private javax.swing.JTextField Slider_nopeus;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    // End of variables declaration        
}
