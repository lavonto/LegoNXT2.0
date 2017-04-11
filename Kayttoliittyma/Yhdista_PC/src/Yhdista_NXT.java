import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTConnector;
import javax.swing.*;

/**
 * Lähettää robotille nopeuden ja esteenohituspuolen.
 * 
 * @author Tuomas Harju
 * @version 1.0
 * @since 5.4.2017
 */
public class Yhdista_NXT extends JFrame {
 private DataOutputStream dos;
 private NXTConnector connection;
 private int nopeus = 250;
 private String ohitusPuoli = "vasen";

 public Yhdista_NXT() {
  initComponents();
 }

 /**
  * Asettaa ohituspuolen
  */

 public void ohitusPuoliArvo() {
   if (Checkbox_vasemmalta.isSelected()) {
    ohitusPuoli = "vasen";
   } else {
    ohitusPuoli = "oikea";
   }
  }
  /**
   * Tarkistaa, sisältääkö tekstikenttään syötetty arvo ainoastaan numeroita.
   * @param merkkijono
   *			Tarkistettava merkkijono
   */
 public static boolean onNumero(String merkkijono) {
   return merkkijono.matches("[0-9]+");
  }
  /**
   *Luo yhteyden ja avaa tietovirran
   */
 public void Yhdista() {
	 connection = new NXTConnector();
   boolean connected = connection.connectTo("usb://");
   if (!connected) {
    JOptionPane.showMessageDialog(null, "Yhdistäminen epäonnistui");
   } else {
    JOptionPane.showMessageDialog(null, "Yhdistäminen onnistui");
    dos = new DataOutputStream(connection.getOutputStream());
   }
  }
  /**
   * Lähettää muuttujien arvot. Lopuksi sulkee yhteyden ja tietovirran.
   */
 public void SuljeJaLaheta() {
   try {
    dos.writeInt(nopeus);
    dos.writeUTF(ohitusPuoli);
    dos.flush();
   } catch (IOException e) {
    e.printStackTrace();
   }
   try {
    dos.close();
    connection.close();
   } catch (IOException e) {
    e.printStackTrace();
   } finally {
    System.exit(1);
   }
  }
  //
  //Generoitua koodia
  //
 @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                         
 private void initComponents() {

   buttonGroup = new javax.swing.ButtonGroup();
   Button_yhdista = new javax.swing.JButton();
   Button_valmis = new javax.swing.JButton();
   jPanel1 = new javax.swing.JPanel();
   Checkbox_vasemmalta = new javax.swing.JCheckBox();
   Checkbox_oikealta = new javax.swing.JCheckBox();
   jPanel2 = new javax.swing.JPanel();
   Label_nopeus = new javax.swing.JLabel();
   textField_nopeus = new javax.swing.JTextField();

   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

   Button_yhdista.setText("Yhdistä");
   Button_yhdista.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
     Button_yhdistaMouseClicked(evt);
    }
   });

   Button_valmis.setText("Lähetä ja sulje");
   Button_valmis.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
     Button_valmisMouseClicked(evt);
    }
   });

   jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Esteen kierto"));

   Checkbox_vasemmalta.setSelected(true);
   buttonGroup.add(Checkbox_vasemmalta);
   Checkbox_vasemmalta.setText("Vasemmalta");
   Checkbox_vasemmalta.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
     Checkbox_vasemmaltaMouseClicked(evt);
    }
   });

   buttonGroup.add(Checkbox_oikealta);
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

   textField_nopeus.setText("250");
   textField_nopeus.addKeyListener(new java.awt.event.KeyAdapter() {

    public void keyReleased(java.awt.event.KeyEvent evt) {
     textField_nopeusKeyReleased(evt);
    }

   });

   javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
   jPanel2.setLayout(jPanel2Layout);
   jPanel2Layout.setHorizontalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(jPanel2Layout.createSequentialGroup()
     .addGap(4, 4, 4)
     .addComponent(textField_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
     .addComponent(Label_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   );
   jPanel2Layout.setVerticalGroup(
    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
     .addGap(6, 6, 6)
     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(textField_nopeus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
  } // </editor-fold>               
  //
  //Eventit
  //
 private void Checkbox_vasemmaltaMouseClicked(java.awt.event.MouseEvent evt) {
  ohitusPuoliArvo();
 }
 private void Checkbox_oikealtaMouseClicked(java.awt.event.MouseEvent evt) {
  ohitusPuoliArvo();
 }
 private void Button_valmisMouseClicked(java.awt.event.MouseEvent evt) {
		if (onNumero(textField_nopeus.getText())) {
			nopeus = Integer.parseInt(textField_nopeus.getText());
  SuljeJaLaheta();
	} else {
		JOptionPane.showMessageDialog(null, "Nopeus on annettava numeroina");
	}
 }
 private void Button_yhdistaMouseClicked(java.awt.event.MouseEvent evt) {
  Yhdista();
 }
 private void textField_nopeusKeyReleased(java.awt.event.KeyEvent evt) {
   nopeus = Integer.parseInt(textField_nopeus.getText());
   System.out.println(nopeus);
  }
  /**
   * @param args the command line arguments
   */
 public static void main(String args[]) {
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
 private javax.swing.JTextField textField_nopeus;
 private javax.swing.ButtonGroup buttonGroup;
 private javax.swing.JPanel jPanel1;
 private javax.swing.JPanel jPanel2;
 // End of variables declaration        
}