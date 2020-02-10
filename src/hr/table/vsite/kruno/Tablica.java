package hr.table.vsite.kruno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Aplikacija za korištenje tablice
 * <p>Ova aplikacija omoguæuje unos imena, prezimena, godine roðenja,spola, i mjesta roðenja za pojedinog èlana. Aplikacija
 * kod samog pokretanja veæ ima unaprijed "hardkodirane" podatke koje služe kao reprezentativan uzorak.</p>
 *<br>
 * <p>Aplikacija zahtjeva da se u sva polja unesu podaci inaèe neæe dopustiti unos djelomiènih
 * podataka. Takoðer, kod spremanja tablice potrebno je specificirati lokaciju mjesta
 * gdje korisnik želi pohraniti sve podatke iz tablice. </p>  
 * <br>
 * <p> Osim moguænosti unosa, korisnik može i brisati podatke (èlanove) podataka.</p>
 * 
 * @author Krunoslav
 *
 */

	public class Tablica {
		
		private static JTextField textMjesto;
		private static JTextField textDrzava;
		private static JTextField textSpremanje;

	    /**
	     * @param args sadrži argumente naredbenog retka kao niz String objekata
	     */
	    public static void main(String[] args){
	    	 
	        // create JFrame and JTable
	        JFrame frame = new JFrame();
	        frame.setResizable(false);
	        frame.getContentPane().setBackground(new Color(176, 196, 222));
	      
	        JTable table = new JTable(); 
	        
	        // Kreiranje stupaca i njihovih naziva
	        Object[] columns = {"ID","IME","DOB","SPOL","MJESTO"};
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);
	        
	        // set the model to the table
	        table.setModel(model);
	        
	        // Promjena JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(new Color(240, 248, 255));
	        table.setForeground(new Color(0, 0, 139));
	        Font font = new Font("",1,22);
	        table.setFont(new Font("Century Gothic", Font.BOLD, 11));
	        table.setRowHeight(25);
	        
	        // kreiranje JTextFields
	        JTextField textId = new JTextField();
	        textId.setBackground(new Color(230, 230, 250));
	      
	        JTextField textIme = new JTextField();
	        textIme.setBackground(new Color(230, 230, 250));
	        JTextField textPrezime = new JTextField();
	        textPrezime.setBackground(new Color(230, 230, 250));
	        
	        // kreiranje JButtons
	        JButton btnAdd = new JButton("Dodaj");
	        btnAdd.setBackground(new Color(0, 255, 127));
	        btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        btnAdd.setForeground(new Color(0, 0, 0));
	        JButton btnDelete = new JButton("Obriši");
	        btnDelete.setBackground(new Color(205, 92, 92));
	        btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        
	        textId.setBounds(67, 8, 100, 25);
	        textIme.setBounds(67, 44, 100, 25);
	        textPrezime.setBounds(67, 82, 100, 25);
	        
	        btnAdd.setBounds(20, 289, 100, 38);
	        btnDelete.setBounds(144, 289, 100, 38);
	        
	        // kreiranje JScrollPane
	        JScrollPane ploca = new JScrollPane(table);
	        ploca.setBounds(276, 8, 689, 285);
	        
	        frame.getContentPane().setLayout(null);
	        
	        frame.getContentPane().add(ploca);
	        
	        // add JTextFields to the jframe
	        frame.getContentPane().add(textId);
	        frame.getContentPane().add(textIme);
	        frame.getContentPane().add(textPrezime);
	    
	        // add JButtons to the jframe
	        frame.getContentPane().add(btnAdd);
	        frame.getContentPane().add(btnDelete);
	        
	        JLabel lblIme = new JLabel("Ime");
	        lblIme.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblIme.setBounds(10, 49, 46, 14);
	        frame.getContentPane().add(lblIme);
	        
	        JLabel lblPrezime = new JLabel("Prezime");
	        lblPrezime.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblPrezime.setBounds(10, 88, 60, 14);
	        frame.getContentPane().add(lblPrezime);
	        
	        JLabel lblDob = new JLabel("DOB");
	        lblDob.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblDob.setBounds(10, 125, 46, 14);
	        frame.getContentPane().add(lblDob);
	        
	        JLabel lblSpol = new JLabel("Spol");
	        lblSpol.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblSpol.setBounds(10, 164, 46, 14);
	        frame.getContentPane().add(lblSpol);
	        
	        JLabel lblGrad = new JLabel("Grad");
	        lblGrad.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblGrad.setBounds(10, 198, 46, 14);
	        frame.getContentPane().add(lblGrad);
	        
	        JLabel lblDrava = new JLabel("Dr\u017Eava");
	        lblDrava.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblDrava.setBounds(10, 234, 46, 14);
	        frame.getContentPane().add(lblDrava);
	        
	        JLabel lblId = new JLabel("ID");
	        lblId.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        lblId.setBounds(10, 13, 46, 14);
	        frame.getContentPane().add(lblId);
	        
	        JComboBox comboBoxSpol = new JComboBox();
	        comboBoxSpol.setModel(new DefaultComboBoxModel(new String[] {"", "Muškarac", "Žena"}));
	        comboBoxSpol.setSelectedIndex(0);
	        comboBoxSpol.setToolTipText("");
	        comboBoxSpol.setMaximumRowCount(3);
	        comboBoxSpol.setBounds(67, 160, 100, 22);
	        frame.getContentPane().add(comboBoxSpol);
	        
	        JTextField textMjesto = new JTextField();
	        textMjesto.setBackground(new Color(230, 230, 250));
	        textMjesto.setBounds(67, 193, 100, 25);
	        frame.getContentPane().add(textMjesto);
	        textMjesto.setColumns(10);
	        
	        JTextField textDrzava = new JTextField();
	        textDrzava.setBackground(new Color(230, 230, 250));
	        textDrzava.setBounds(67, 229, 100, 25);
	        frame.getContentPane().add(textDrzava);
	        textDrzava.setColumns(10);
	        
	        JTextField textDob = new JTextField();
	        textDob.setBackground(new Color(230, 230, 250));
	       
	        textDob.addMouseMotionListener(new MouseMotionAdapter() {
	        	@Override
	        	
	        	public void mouseMoved(MouseEvent e) {
	        		textDob.setToolTipText("dd.mm.yyyy");
	        	}
	        });
	        textDob.setBounds(66, 117, 101, 25);
	        frame.getContentPane().add(textDob);
	        textDob.setColumns(10);
	        
	        JLabel lblDdmmyyy = new JLabel("[dd.mm.yyyy]");
	        lblDdmmyyy.setForeground(new Color(128, 0, 0));
	        lblDdmmyyy.setFont(new Font("Century Gothic", Font.BOLD, 8));
	        lblDdmmyyy.setBounds(177, 127, 67, 14);
	        frame.getContentPane().add(lblDdmmyyy);
	        
	        JButton btnNewButton = new JButton("Rand id");
	        btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int n=Provjere.getRandomNumberInts();
	        		String str1 = Integer.toString(n);
	        		textId.setText(str1);
	        	}
	        });
	        btnNewButton.setBounds(177, 10, 88, 23);
	        frame.getContentPane().add(btnNewButton);
	        
	       //----sorting data:
	    	
	        table.setAutoCreateRowSorter(true);
	        
	        //---spremanje u file.txt
	        JButton btnSpremi = new JButton("Spremi u datoteku");
	        btnSpremi.setFont(new Font("Century Gothic", Font.BOLD, 12));
	        btnSpremi.setBackground(new Color(255, 182, 193));
	   
	        btnSpremi.addActionListener(new ActionListener() {
	        	 @Override
	        	 public void actionPerformed(ActionEvent e) {
	        		 
	        		 	try{
		                       //the file path
		                      File file = new File(textSpremanje.getText());
		                      //ako path ne postoji
		                      if(!file.exists()){
		                          file.createNewFile();
	                      }
	                      
	                      FileWriter fw = new FileWriter(file.getAbsoluteFile());
	                      BufferedWriter bw = new BufferedWriter(fw);
	                      
	                      //petlja for jtable redovi
	                      for(int i = 0; i < table.getRowCount(); i++){
	                          //petlja za stupac
	                          for(int j = 0; j < table.getColumnCount(); j++){
	                              bw.write(table.getModel().getValueAt(i, j)+" ");
	                          }
	                          bw.write("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
	                      }
	                      //zatvori buffer
	                      bw.close();
	                      //zatvori 
	                      fw.close();
	                      JOptionPane.showMessageDialog(null, "Podaci su uspješno pohranjeni");
	                      
	                      }catch(Exception ex){
	                    	  JOptionPane.showMessageDialog( null,"Oprez kod unosa odredišta spremanja podataka!","Oprez", JOptionPane.WARNING_MESSAGE);
	                    	  textSpremanje.setBackground(Color.orange);
	                          ex.printStackTrace();
	                      }
	                  }
	        	
	        });
	        btnSpremi.setBounds(303, 304, 147, 47);
	        frame.getContentPane().add(btnSpremi);
	        
	        JLabel lblPutanjaPohrane = new JLabel("Putanja pohrane ( npr. C:\\\\Users\\\\...\\\\datoteka_ime.txt )");
	        lblPutanjaPohrane.setFont(new Font("Century Gothic", Font.ITALIC, 11));
	        lblPutanjaPohrane.setBounds(507, 347, 348, 14);
	        frame.getContentPane().add(lblPutanjaPohrane);
	        
	        textSpremanje = new JTextField();
	        textSpremanje.setForeground(new Color(128, 0, 0));
	        textSpremanje.setFont(new Font("Consolas", Font.BOLD, 10));
	        textSpremanje.setBackground(new Color(255, 255, 204));
	        textSpremanje.setBounds(460, 311, 430, 25);
	        frame.getContentPane().add(textSpremanje);
	        textSpremanje.setColumns(10);
	    
	        
	      
	        Object[] row = new Object[5];
	        
	        //---------------------------------------------
	        //HARDKODIRANJE PODATAKA:
	      
	        
	        row[0]=142;
            row[1]= "Markovic, Marko";
            row[2] = "15.4.2001";
            row[3] = "Muškarac";
            row[4]= "Split, Hrvatska";
            model.addRow(row);
            row[0]=513;
            row[1]= "Stjepanoviæ, Stjepan";
            row[2] = "23.2.2001";
            row[3] = "Muškarac";
            row[4]= "Zagreb, Hrvatska";
            model.addRow(row);
            row[0]=913;
            row[1]= "Makedonski, Filip";
            row[2] = "30.1.1989";
            row[3] = "Muškarac";
            row[4]= "Zagreb, Hrvatska";
            model.addRow(row);
            row[0]=1613;
            row[1]= "Èoviæ, Manuela";
            row[2] = "1.1.1998";
            row[3] = "Žena";
            row[4]= "Glina, Hrvatska";
            model.addRow(row);
            row[0]=1399;
            row[1]= "Gabi, Gabrijela";
            row[2] = "29.1.2000";
            row[3] = "Žena";
            row[4]= "Dubrovnik, Hrvatska";
            model.addRow(row);
            row[0]=8989;
            row[1]= "Markovic, Tea";
            row[2] ="8.8.1992";
            row[3] = "Žena";
            row[4]= "Rijeka, Hrvatska";
            model.addRow(row);
            row[0]=1973;
            row[1]= "Vlad, Vladimir";
            row[2] ="17.11.1989";
            row[3] = "Muškarac";
            row[4]= "Zagreb, Hrvatska";
            model.addRow(row);
            row[0]=1443;
            row[1]= "Tomik, Tomislav";
            row[2] ="6.1.2000";
            row[3] = "Muškarac";
            row[4]= "Vukovar, Hrvatska";
            model.addRow(row);
            row[0]=1292;
            row[1]= "Marinica, Marina";
            row[2] ="13.1.1989";
            row[3] = "Žena";
            row[4]= "Jaska, Hrvatska";
            model.addRow(row);
            row[0]=188;
            row[1]= "Tonk, Tina";
            row[2] ="20.12.1949";
            row[3] = "Žena";
            row[4]= "Varaždin, Hrvatska";
            model.addRow(row);
            row[0]=147;
            row[1]= "Krešimir, Domagoj";
            row[2] ="11.1.1997";
            row[3] = "Muškarac";
            row[4]= "Zagreb, Hrvatska";
            model.addRow(row);
            row[0]=127;
            row[1]= "Teuta, Tena";
            row[2] ="19.1.1967";
            row[3] = "Žena";
            row[4]= "Zagreb, Hrvatska";
            model.addRow(row);
	        //-----------------------------------------------
            
	        // button BRISANJE REDA
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	         
	                // i = index selektiranog reda
	                int i = table.getSelectedRow();
	                if(i >= 0){
	                    // brisanje reda iz tablice
	                    model.removeRow(i);
	                    //èišæenje textboxa:
	                	textId.setText("");
		                textIme.setText("");
		                textPrezime.setText("");;
		                textDob.setText("");
		                comboBoxSpol.setSelectedItem("");
		                textMjesto.setText("");
		                textDrzava.setText("");
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
	               
	            }
	            
	          
	        });
	      
	        
	        //--------------------------------------------
	        // DOHVAÆANJE PODATAKA IZ TABLICE U TextFields
	        table.addMouseListener(new MouseAdapter(){
	        
	        public void mouseClicked(MouseEvent e){
	        	 
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            //------>
	            textId.setText(model.getValueAt(i, 0).toString());
	            textIme.setText(model.getValueAt(i, 1).toString().split(" ")[1]);
	            textPrezime.setText(model.getValueAt(i, 1).toString().split(", ")[0]);
	            
	            textDob.setText(model.getValueAt(i,2).toString());
	            comboBoxSpol.setSelectedItem(model.getValueAt(i, 3).toString());
	            textMjesto.setText(model.getValueAt(i, 4).toString().split(", ")[0]);
	            textDrzava.setText(model.getValueAt(i, 4).toString().split(" ")[1]);
	            
	            textDob.setBackground(Color.white);
	            textId.setBackground(Color.white);
	            textPrezime.setBackground(Color.white);
	            textIme.setBackground(Color.white);
	            textMjesto.setBackground(Color.white);
	            textDrzava.setBackground(Color.white);
	            textSpremanje.setBackground(Color.white);
	        }
	        
	        });
	        //-------
	        //Pritisak tike miša u okruženje
	        frame.getContentPane().addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		 	textId.setText("");
		                textIme.setText("");
		                textPrezime.setText("");;
		                textDob.setText("");
		                comboBoxSpol.setSelectedItem("");
		                textMjesto.setText("");
		                textDrzava.setText("");
		                  
		                
	        	}
	        });
	        
	        //----------------------
	        // button DODAJ red
	        
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                           // add row to the model
	                if(textIme.getText().isEmpty() || textPrezime.getText().isEmpty()|| comboBoxSpol.getSelectedItem().equals("")|| textDob.getText().isEmpty()
	                		|| textMjesto.getText().isEmpty()|| textDrzava.getText().isEmpty())
	                    {
	                	JOptionPane.showMessageDialog( null,"UPOZORENJE!\nSva polja moraju biti ispunjena","Pažnja!!", JOptionPane.WARNING_MESSAGE);
	                
	                    }
	               else if(Provjere.provjeraStringa(textId.getText())==false) {
		        			textId.setBackground(Color.orange);
		        			JOptionPane.showMessageDialog( null,"Morate unijeti cjelobrojnu vrijednost","Pažnja!!", JOptionPane.WARNING_MESSAGE);       		        		
		        	}
	                else if(Provjere.provjeraStringa(textIme.getText())==true) {
	                	textIme.setBackground(Color.orange);
	                	JOptionPane.showMessageDialog( null,"Morate paziti kako unosite ime.","Pažnja!!", JOptionPane.WARNING_MESSAGE);    		        		
	        	}
	                else if(Provjere.provjeraStringa(textPrezime.getText())==true) {
	                	textPrezime.setBackground(Color.orange);
	                	JOptionPane.showMessageDialog( null,"Morate paziti kako unosite prezime.","Pažnja!!", JOptionPane.WARNING_MESSAGE);      		        		
	        	}
	                else if(Provjere.checkDatePotpis(textDob.getText())==false) {
	                	textDob.setBackground(Color.orange);
	                	JOptionPane.showMessageDialog( null,"Pazi na format datuma \n\tDD.MM.YYYY","Pažnja!!", JOptionPane.WARNING_MESSAGE);
	                }
	                else if(Provjere.provjeraStringa(textMjesto.getText())==true) {
	                	textMjesto.setBackground(Color.orange);
	                	JOptionPane.showMessageDialog( null,"Morate paziti kako unosite naziv mjesta.","Pažnja!!", JOptionPane.WARNING_MESSAGE);       		        		
	        	}
	                else if(Provjere.provjeraStringa(textDrzava.getText())==true) {
	                	textDrzava.setBackground(Color.orange);
	                	JOptionPane.showMessageDialog( null,"Morate paziti kako unosite naziv države.","Pažnja!!", JOptionPane.WARNING_MESSAGE);          		        		
	        	}
	                
	                 else {
	                row[0]=textId.getText();
	                row[1]= textPrezime.getText()+", "+textIme.getText();
	                row[2] = textDob.getText();
	                row[3] = (String) comboBoxSpol.getSelectedItem();
	                row[4]= textMjesto.getText()+", "+textDrzava.getText();
	                model.addRow(row);
	                
	                textDob.setBackground(Color.white);
		            textId.setBackground(Color.white);
		            textPrezime.setBackground(Color.white);
		            textIme.setBackground(Color.white);
		            textMjesto.setBackground(Color.white);
		            textDrzava.setBackground(Color.white);
		            textSpremanje.setBackground(Color.white);

	                
	                //èišæenje textboxa:
	                textId.setText("");
	                textIme.setText("");
	                textPrezime.setText("");
	                textDob.setText("");
	                comboBoxSpol.setSelectedItem("");
	                textMjesto.setText("");
	                textDrzava.setText("");
	                textSpremanje.setText("");
	               
	                
	                }
	               
	            }
	      
	        });
	     
	        frame.setSize(981,401);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	    }
	}