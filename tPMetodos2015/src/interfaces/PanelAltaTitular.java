package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import clasesDeTablas.Titular;
import excepciones.ExcepcionContribuyente;
import excepciones.ExcepcionLicenciasInvalidas;
import excepciones.ExcepcionNull;
import excepciones.ExcepcionSQL;
import excepciones.ExcepcionValidador;
import logica.AltaTitular;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelAltaTitular extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNumeroDoc;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textRutaImagen;
	private JComboBox<String> comboTipoDoc;
	private JComboBox<String> comboGrupoSanguineo;
	private JComboBox<String> comboFactorRH;
	private JComboBox<String> comboBoxSexo;
	private JDateChooser dateChooserNacimiento;
	private AltaTitular altaTitular = new AltaTitular();
	private JLabel labelFoto;
	private JCheckBox checkBoxClaseA;
	private JCheckBox checkBoxClaseB;
	private JCheckBox checkBoxClaseC;
	private JCheckBox checkBoxClaseD;
	private JCheckBox checkBoxClaseE;
	private JCheckBox checkBoxClaseF;
	private JCheckBox checkBoxClaseG;
	private JCheckBox checkBoxDondante;
	private JLabel labelFecha;
	private JButton btnAceptar;
	/**
	 * Create the panel.
	 */
	public PanelAltaTitular() {
		setBackground(new Color(245, 255, 250));
		
		//ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/icono.jpg"));
        
        //setBackground(new Color(105, 105, 105));
        //setForeground(new Color(128, 128, 0));
        
        
        
        //icono = new JLabel(img);
        //icono.setBounds(677, 11, 142, 141);
        //add(icono);
		
		
			GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{44, 94, 129, 123, 65, 20, 83, 109, 108, 294, 0};
		gridBagLayout.rowHeights = new int[]{100, 16, 56, 25, 24, 24, 20, 20, 35, 14, 23, 23, 41, 25, 147, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JTextPane txtpnDarAltaTitular = new JTextPane();
		txtpnDarAltaTitular.setBackground(new Color(0, 0, 51));
		txtpnDarAltaTitular.setForeground(SystemColor.window);
		txtpnDarAltaTitular.setFont(new Font("Lato Heavy", Font.PLAIN, 30));
		txtpnDarAltaTitular.setText("\r\n\tALTA TITULAR");
		GridBagConstraints gbc_txtpnDarAltaTitular = new GridBagConstraints();
		gbc_txtpnDarAltaTitular.weightx = 1.0;
		gbc_txtpnDarAltaTitular.fill = GridBagConstraints.BOTH;
		gbc_txtpnDarAltaTitular.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnDarAltaTitular.gridwidth = 10;
		gbc_txtpnDarAltaTitular.gridx = 0;
		gbc_txtpnDarAltaTitular.gridy = 0;
		add(txtpnDarAltaTitular, gbc_txtpnDarAltaTitular);
	
		
		
		
		//Etiquetas
		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 3;
		add(lblApellido, gbc_lblApellido);
		

		//Dise�o etiquetas
		lblApellido.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		//Campo a completar con Apellido
		textApellido = new JTextField();
		textApellido.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_textApellido = new GridBagConstraints();
		gbc_textApellido.anchor = GridBagConstraints.SOUTH;
		gbc_textApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textApellido.gridwidth = 2;
		gbc_textApellido.gridx = 2;
		gbc_textApellido.gridy = 3;
		add(textApellido, gbc_textApellido);
		textApellido.setColumns(10);
		
		
		//Campo textApellido permite solo letras y tama�o:50
		textApellido.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textApellido.setText(textApellido.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
              
              e.toString().toUpperCase();
              
             
             if(!(Character.isLetter(c)) && !(c==' ')&& !(c=='\''))
            	 e.consume(); 

             if (textApellido.getText().length()== 50)
                 e.consume();
            }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 6;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		lblNombre.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
        //Campo a completar Nombre
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.anchor = GridBagConstraints.NORTH;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 7;
		gbc_textNombre.gridy = 3;
		add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		//Campo textNombre permite solo letras (espacio y ') y tama�o:50, y mayuscula
		textNombre.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textNombre.setText(textNombre.getText().toUpperCase());
        	
                
              char c=e.getKeyChar(); 
       
             
             if(!(Character.isLetter(c)) && !(c==' ')&& !(c=='\''))
            	 e.consume(); 

             if (textNombre.getText().length()== 50)
                 e.consume();
            }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				// TODO Auto-generated method stub
				
			}
		});
		textNombre.addFocusListener (new FocusListener()
	        {


	                @Override
	                public void focusGained(FocusEvent arg0) {
	                        // TODO Auto-generated method stub
	                	
	                }

	                @Override
	                public void focusLost(FocusEvent arg0) {
	                	 String cadena = textNombre.getText();
	                     textNombre.setText(cadena.toUpperCase());
	                }
	        
	                });
		//etiquetas
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");
		GridBagConstraints gbc_lblTipoDeDocumento = new GridBagConstraints();
		gbc_lblTipoDeDocumento.anchor = GridBagConstraints.WEST;
		gbc_lblTipoDeDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeDocumento.gridx = 1;
		gbc_lblTipoDeDocumento.gridy = 4;
		add(lblTipoDeDocumento, gbc_lblTipoDeDocumento);
		lblTipoDeDocumento.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		//Combo box con opciones de tipo de documento
		comboTipoDoc = new JComboBox<String>();
		comboTipoDoc.setModel(new DefaultComboBoxModel<String>(new String[] {"", "DNI", "LC", "LE"}));
		GridBagConstraints gbc_comboTipoDoc = new GridBagConstraints();
		gbc_comboTipoDoc.anchor = GridBagConstraints.SOUTH;
		gbc_comboTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoDoc.gridx = 2;
		gbc_comboTipoDoc.gridy = 4;
		add(comboTipoDoc, gbc_comboTipoDoc);
		
		JLabel lblNumeroDoc = new JLabel("N\u00FAmero de documento:");
		GridBagConstraints gbc_lblNumeroDoc = new GridBagConstraints();
		gbc_lblNumeroDoc.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDoc.gridx = 6;
		gbc_lblNumeroDoc.gridy = 4;
		add(lblNumeroDoc, gbc_lblNumeroDoc);
		lblNumeroDoc.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		//Campo a completar con numero de documento
		textNumeroDoc = new JTextField();
		GridBagConstraints gbc_textNumeroDoc = new GridBagConstraints();
		gbc_textNumeroDoc.gridwidth = 2;
		gbc_textNumeroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumeroDoc.anchor = GridBagConstraints.NORTH;
		gbc_textNumeroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroDoc.gridx = 7;
		gbc_textNumeroDoc.gridy = 4;
		add(textNumeroDoc, gbc_textNumeroDoc);
		textNumeroDoc.setColumns(10);
		
		//Campo NumeroDoc permite solo n�meros y maximo 8
		textNumeroDoc.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textNumeroDoc.setText(textNumeroDoc.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
     
             
              if(!(Character.isDigit(c)) )
            	  e.consume(); 
              if (textNumeroDoc.getText().length()== 8)
                 e.consume();
            }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Cuando se pierde el foco de textNumeroDoc: se comprueba si ya existe el numero y tipo de documento cargado
		textNumeroDoc.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				//Se verifica que el numero de doc cargado sea mayor a 7 y que se haya seleccionado tipo de documento
				if(textNumeroDoc.getText().length()>=7 && comboTipoDoc.getSelectedIndex()!=0){
					
					Titular titular = altaTitular.verificarExistenciaTitular(textNumeroDoc.getText(), comboTipoDoc.getSelectedItem().toString());
					if(titular!=null){
						titularExistente(titular);
					}
				}
				
				
				
			}

			
		});
		
		labelFecha = new JLabel("Fecha de Nacimiento:");
		labelFecha.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_labelFecha = new GridBagConstraints();
		gbc_labelFecha.insets = new Insets(0, 0, 5, 5);
		gbc_labelFecha.gridx = 1;
		gbc_labelFecha.gridy = 5;
		add(labelFecha, gbc_labelFecha);
		
		dateChooserNacimiento = new JDateChooser();
		/*Hacer que el dateChooser sea no editable mateniendo la letra visible*/
		dateChooserNacimiento.getDateEditor().setEnabled(false);
		((JTextComponent) dateChooserNacimiento.getDateEditor()).setDisabledTextColor(Color.darkGray);
		
		
		dateChooserNacimiento.getCalendarButton().setBackground(new Color(204, 0, 51));
		GridBagConstraints gbc_dateChooserNacimiento = new GridBagConstraints();
		gbc_dateChooserNacimiento.anchor = GridBagConstraints.SOUTH;
		gbc_dateChooserNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooserNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserNacimiento.gridx = 2;
		gbc_dateChooserNacimiento.gridy = 5;
		add(dateChooserNacimiento, gbc_dateChooserNacimiento);
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.WEST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 6;
		gbc_lblSexo.gridy = 5;
		add(lblSexo, gbc_lblSexo);
		lblSexo.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Femenino", "Masculino"}));
		GridBagConstraints gbc_comboBoxSexo = new GridBagConstraints();
		gbc_comboBoxSexo.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSexo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSexo.gridx = 7;
		gbc_comboBoxSexo.gridy = 5;
		add(comboBoxSexo, gbc_comboBoxSexo);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.WEST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 1;
		gbc_lblDireccin.gridy = 6;
		add(lblDireccin, gbc_lblDireccin);
		lblDireccin.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		
		//Campo textDireccion permite solo letras, numeros (espacio y ') y tama�o:50, y mayuscula
		textDireccion = new JTextField();
		GridBagConstraints gbc_textDireccion = new GridBagConstraints();
		gbc_textDireccion.anchor = GridBagConstraints.NORTH;
		gbc_textDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_textDireccion.gridwidth = 2;
		gbc_textDireccion.gridx = 2;
		gbc_textDireccion.gridy = 6;
		add(textDireccion, gbc_textDireccion);
		textDireccion.setColumns(10);
		textDireccion.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textDireccion.setText(textDireccion.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
       
             
             if(!(Character.isLetter(c)) && !(c==' ')&& !(c=='\'') && !(Character.isDigit(c)))
            	 e.consume(); 

             if (textDireccion.getText().length()== 50)
                 e.consume();
            }

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		textDireccion.addFocusListener (new FocusListener()
	        {


	                @Override
	                public void focusGained(FocusEvent arg0) {
	                        // TODO Auto-generated method stub
	                        
	                }

	                @Override
	                public void focusLost(FocusEvent arg0) {
	                        {
	                              String cadena = textDireccion.getText();
	                              textDireccion.setText(cadena.toUpperCase());
	                           }
	                        
	                }
	        
	                });
		//etiquetas
		JLabel lblNewLabel = new JLabel("Grupo sangu\u00EDneo:");
		lblNewLabel.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 7;
		add(lblNewLabel, gbc_lblNewLabel);
		 
		 
		 //Combo box con opciones de gurpo sanguino
		 comboGrupoSanguineo = new JComboBox<String>();
		 comboGrupoSanguineo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0", "A", "B", "AB"}));
		 GridBagConstraints gbc_comboGrupoSanguineo = new GridBagConstraints();
		 gbc_comboGrupoSanguineo.anchor = GridBagConstraints.NORTH;
		 gbc_comboGrupoSanguineo.fill = GridBagConstraints.HORIZONTAL;
		 gbc_comboGrupoSanguineo.insets = new Insets(0, 0, 5, 5);
		 gbc_comboGrupoSanguineo.gridx = 2;
		 gbc_comboGrupoSanguineo.gridy = 7;
		 add(comboGrupoSanguineo, gbc_comboGrupoSanguineo);
		
		 JLabel lblFactorRh = new JLabel("Factor RH:");
		 GridBagConstraints gbc_lblFactorRh = new GridBagConstraints();
		 gbc_lblFactorRh.insets = new Insets(0, 0, 5, 5);
		 gbc_lblFactorRh.gridx = 3;
		 gbc_lblFactorRh.gridy = 7;
		 add(lblFactorRh, gbc_lblFactorRh);
		 lblFactorRh.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		//Combo box con opciones de factor RH
		comboFactorRH = new JComboBox<String>();
		comboFactorRH.setModel(new DefaultComboBoxModel<String>(new String[] {"", "+", "-"}));
		GridBagConstraints gbc_comboFactorRH = new GridBagConstraints();
		gbc_comboFactorRH.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboFactorRH.anchor = GridBagConstraints.NORTH;
		gbc_comboFactorRH.insets = new Insets(0, 0, 5, 5);
		gbc_comboFactorRH.gridx = 4;
		gbc_comboFactorRH.gridy = 7;
		add(comboFactorRH, gbc_comboFactorRH);
		
				checkBoxDondante = new JCheckBox("Donante de \u00F3rganos");
				checkBoxDondante.setBackground(new Color(240, 255, 255));
				GridBagConstraints gbc_checkBoxDondante = new GridBagConstraints();
				gbc_checkBoxDondante.anchor = GridBagConstraints.WEST;
				gbc_checkBoxDondante.insets = new Insets(0, 0, 5, 5);
				gbc_checkBoxDondante.gridx = 6;
				gbc_checkBoxDondante.gridy = 7;
				add(checkBoxDondante, gbc_checkBoxDondante);
		JLabel lblClasesSolicitadas = new JLabel("Clases solicitadas:");
		GridBagConstraints gbc_lblClasesSolicitadas = new GridBagConstraints();
		gbc_lblClasesSolicitadas.anchor = GridBagConstraints.EAST;
		gbc_lblClasesSolicitadas.fill = GridBagConstraints.VERTICAL;
		gbc_lblClasesSolicitadas.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasesSolicitadas.gridx = 1;
		gbc_lblClasesSolicitadas.gridy = 9;
		add(lblClasesSolicitadas, gbc_lblClasesSolicitadas);
		lblClasesSolicitadas.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		checkBoxClaseA = new JCheckBox("Clase A");
		checkBoxClaseA.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseA = new GridBagConstraints();
		gbc_checkBoxClaseA.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBoxClaseA.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseA.gridx = 2;
		gbc_checkBoxClaseA.gridy = 10;
		add(checkBoxClaseA, gbc_checkBoxClaseA);
		
		
		
		checkBoxClaseC = new JCheckBox("Clase C");
		checkBoxClaseC.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseC = new GridBagConstraints();
		gbc_checkBoxClaseC.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBoxClaseC.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseC.gridx = 3;
		gbc_checkBoxClaseC.gridy = 10;
		add(checkBoxClaseC, gbc_checkBoxClaseC);
		
		//Si se selecciona C, se desactiva la opcion de seleccionar B
		checkBoxClaseC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxClaseC.isSelected()==true) {
					 checkBoxClaseB.setEnabled(false);
					 repaint();
				 }
				if (checkBoxClaseC.isSelected()==false) {
					 checkBoxClaseB.setEnabled(true);
					 repaint();
				 }
				
				
			}
		});
		
		//Si se selecciona E, se desactiva la opcion de seleccionar B,C y E
		checkBoxClaseE = new JCheckBox("Clase E");
		checkBoxClaseE.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseE = new GridBagConstraints();
		gbc_checkBoxClaseE.anchor = GridBagConstraints.NORTH;
		gbc_checkBoxClaseE.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxClaseE.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseE.gridx = 4;
		gbc_checkBoxClaseE.gridy = 10;
		add(checkBoxClaseE, gbc_checkBoxClaseE);
		checkBoxClaseE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxClaseE.isSelected()==true) {
					 checkBoxClaseB.setEnabled(false);
					 checkBoxClaseC.setEnabled(false);
					 repaint();
				 }
				if (checkBoxClaseE.isSelected()==false) {
					 checkBoxClaseB.setEnabled(true);
					 checkBoxClaseC.setEnabled(true);
					 repaint();
				 }
			}	
		});	
		
		checkBoxClaseG = new JCheckBox("Clase G\r\n");
		checkBoxClaseG.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseG = new GridBagConstraints();
		gbc_checkBoxClaseG.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBoxClaseG.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseG.gridx = 6;
		gbc_checkBoxClaseG.gridy = 10;
		add(checkBoxClaseG, gbc_checkBoxClaseG);
		
		
		checkBoxClaseB = new JCheckBox("Clase B");
		checkBoxClaseB.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseB = new GridBagConstraints();
		gbc_checkBoxClaseB.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBoxClaseB.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseB.gridx = 2;
		gbc_checkBoxClaseB.gridy = 11;
		add(checkBoxClaseB, gbc_checkBoxClaseB);
		
		//Si se selecciona D, se desactiva la opcion de seleccionar C y B
		checkBoxClaseD = new JCheckBox("Clase D\r\n");
		checkBoxClaseD.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseD = new GridBagConstraints();
		gbc_checkBoxClaseD.anchor = GridBagConstraints.NORTHWEST;
		gbc_checkBoxClaseD.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseD.gridx = 3;
		gbc_checkBoxClaseD.gridy = 11;
		add(checkBoxClaseD, gbc_checkBoxClaseD);
		checkBoxClaseD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxClaseD.isSelected()==true) {
					 checkBoxClaseB.setEnabled(false);
					 checkBoxClaseC.setEnabled(false);
					 repaint();
				 }
				if (checkBoxClaseC.isSelected()==false) {
					 checkBoxClaseB.setEnabled(true);
					 checkBoxClaseC.setEnabled(true);
					 repaint();
				 }
				
				
			}
		});
		
		checkBoxClaseF = new JCheckBox("Clase F");
		checkBoxClaseF.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_checkBoxClaseF = new GridBagConstraints();
		gbc_checkBoxClaseF.anchor = GridBagConstraints.NORTH;
		gbc_checkBoxClaseF.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxClaseF.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxClaseF.gridx = 4;
		gbc_checkBoxClaseF.gridy = 11;
		add(checkBoxClaseF, gbc_checkBoxClaseF);
		JLabel lblImagen = new JLabel("Foto:");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 12;
		add(lblImagen, gbc_lblImagen);
		lblImagen.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		
		textRutaImagen = new JTextField();
		GridBagConstraints gbc_textRutaImagen = new GridBagConstraints();
		gbc_textRutaImagen.gridwidth = 2;
		gbc_textRutaImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRutaImagen.insets = new Insets(0, 0, 5, 5);
		gbc_textRutaImagen.gridx = 2;
		gbc_textRutaImagen.gridy = 12;
		add(textRutaImagen, gbc_textRutaImagen);
		textRutaImagen.setColumns(10);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnSeleccionar.setBackground(new Color(240, 255, 255));
		btnSeleccionar.setForeground(new Color(153, 0, 0));
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionar.gridx = 3;
		gbc_btnSeleccionar.gridy = 13;
		add(btnSeleccionar, gbc_btnSeleccionar);
		
		
		//Si se selecciona el boton "Seleccionar" se ejecuta la funcion btnSeleccionarAction() y se envia el evento e(de seleccion)
		btnSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarAction(e);
				// TODO Auto-generated method stub
				
			}
		});
		
		/* Boton Aceptar*/
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(153, 0, 0));
		btnAceptar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnAceptar.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.anchor = GridBagConstraints.SOUTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 8;
		gbc_btnAceptar.gridy = 14;
		add(btnAceptar, gbc_btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAceptarAction(e);
				// TODO Auto-generated method stub
				
			}

			
		});
		
		
		/*Grupo Sanguino y Factor RH*/

		
		/* Apellido, Nombre  y Direccion*/
		
		/*Clases : A,B,C,D,E,F,G 
		 * C ->B
		 * D -> C
		 * E -> C
		 */

		/*Fecha de nacimiento*/
		
		
		/*Sexo*/
		
		
		
	
		
		
		/*Foto*/
	
	}
	private void btnSeleccionarAction(ActionEvent e) {
		//permite solo imagenes jpeg
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de archivos JPEG (*.JPG, *.JPEG)", "jpg","jpeg");
		
		JFileChooser seleccionadorFoto = new JFileChooser();
		seleccionadorFoto.addChoosableFileFilter(filtro);
		
		/*Agregar si queremos delimitar donde se abre el filesystem
		File ruta = new File("");
		foto.setCurrentDirectory(ruta);
		*/
		// abrir ventana de seleccion de foto
		int ventana = seleccionadorFoto.showOpenDialog(null); 
		//pregunta si selecciono una foto
		
		if(ventana == JFileChooser.APPROVE_OPTION){
			//agrega la ruta de la foto en textRutaImagen
			File file= seleccionadorFoto.getSelectedFile();
			textRutaImagen.setText(String.valueOf(file));
			try {@SuppressWarnings("deprecation")
			ImageIcon foto= new ImageIcon(seleccionadorFoto.getSelectedFile().toURL());
			
			
			labelFoto= new JLabel(foto);
			labelFoto.setForeground(new Color(153, 0, 0));
			labelFoto.setBounds(377, 490, 147, 147);
			add(labelFoto);
			repaint();
			
			}
			catch(MalformedURLException me){
				System.out.println("error imagen");
			}
		}
	}
	

	private List<String> obtenerClasesTildadas() {
		List<String> listaClases = new ArrayList<>();
		if(checkBoxClaseA.isSelected() && checkBoxClaseA.isEnabled())
			listaClases.add("A");
		if(checkBoxClaseB.isSelected()&& checkBoxClaseB.isEnabled())
			listaClases.add("B");
		if(checkBoxClaseC.isSelected()&& checkBoxClaseC.isEnabled())
			listaClases.add("C");
		if(checkBoxClaseD.isSelected()&& checkBoxClaseD.isEnabled())
			listaClases.add("D");
		if(checkBoxClaseE.isSelected()&& checkBoxClaseE.isEnabled())
			listaClases.add("E");
		if(checkBoxClaseF.isSelected()&& checkBoxClaseF.isEnabled())
			listaClases.add("F");
		if(checkBoxClaseG.isSelected()&& checkBoxClaseG.isEnabled())
			listaClases.add("G");
		return listaClases;
	}
	private void titularExistente(Titular titular) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,	titular.getApellido()+"\t"+titular.getNombre(), "Titular existente", JOptionPane.INFORMATION_MESSAGE);
		textNombre.setText(titular.getNombre());
		textApellido.setText(titular.getApellido());
		textDireccion.setText(titular.getDomicilio());
		dateChooserNacimiento.setCalendar(titular.getFechaNacimiento());
		comboBoxSexo.setSelectedItem(titular.getSexo());
		comboFactorRH.setSelectedItem(titular.getFactorRh());
		comboGrupoSanguineo.setSelectedItem(titular.getGrupoSanguineo());
		if(titular.getDonante()){
			checkBoxDondante.setSelected(true);
		}
		
	}
	
	private void btnAceptarAction(ActionEvent e) {
		
		try{
			
		//Verificar Nulidad de numero y tipo de documento
		if(textNumeroDoc.getText().isEmpty() && comboTipoDoc.getSelectedIndex()==0)
			throw new ExcepcionNull("El DNI o el tipo de DNI es nulo");
			//Si no son nulos, verificar que los digitos del documento sean >= 7
			else if(textNumeroDoc.getText().length()<7){
				//si es menor a 7, se genera una excepcion
				throw new ExcepcionValidador("Documento: cantidad de digitos de digitos incorrectos");
			}
		
		
		//Verificar nulidad
		if (textApellido.getText().isEmpty() || textDireccion.getText().isEmpty()|| textNombre.getText().isEmpty()|| textRutaImagen.getText().isEmpty() 
				||comboBoxSexo.getSelectedIndex()==0 || comboFactorRH.getSelectedIndex()==0 || comboGrupoSanguineo.getSelectedIndex()==0 ||
				comboFactorRH.getSelectedIndex()==0 ){
			throw new ExcepcionNull("Existen campos nulos de datos");
			
		}
		Calendar fechaNac = dateChooserNacimiento.getCalendar();
        Calendar fecha = Calendar.getInstance();
        if(fechaNac.after(fecha))
                throw new ExcepcionValidador("Fecha de nacimiento incorrecta");
		else{
			List<String> clasesSolicitadas =obtenerClasesTildadas();
			altaTitular.altaTitular(textNumeroDoc.getText(), (String) comboTipoDoc.getSelectedItem(),
					textNombre.getText(), textApellido.getText(), textDireccion.getText(), 
					(boolean) checkBoxDondante.isSelected(), (String) comboFactorRH.getSelectedItem(), (String) comboGrupoSanguineo.getSelectedItem(), 
					fechaNac,(String) comboBoxSexo.getSelectedItem(), (String) textRutaImagen.getText(), clasesSolicitadas);
		}
	}
		catch(ExcepcionNull e1){ JOptionPane.showMessageDialog(this,"No se han cargado todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
		catch (ExcepcionValidador    e2){
			 JOptionPane.showMessageDialog(this,e2.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ExcepcionContribuyente   e3){
			 JOptionPane.showMessageDialog(this,e3.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ExcepcionLicenciasInvalidas e4){
			 JOptionPane.showMessageDialog(this,e4.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ExcepcionSQL e5){
			 JOptionPane.showMessageDialog(this,e5.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		}
}
