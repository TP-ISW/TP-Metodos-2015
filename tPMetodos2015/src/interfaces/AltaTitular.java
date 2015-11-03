package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class AltaTitular extends JPanel {
	private JTextField textNumeroDoc;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textRutaImagen;
	private JComboBox comboTipoDoc;
	private JComboBox comboGrupoSanguineo;
	private JComboBox comboFactorRH;
	private JComboBox comboBoxSexo;
	private JDateChooser dateChooserNacimiento;
	/**
	 * Create the panel.
	 */
	public AltaTitular() {
		setLayout(null);
		
		//ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/icono.jpg"));
        
        //setBackground(new Color(105, 105, 105));
        //setForeground(new Color(128, 128, 0));
        
        
        
        //icono = new JLabel(img);
        //icono.setBounds(677, 11, 142, 141);
        //add(icono);
		
		/*Numero y tipo de documento*/
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");
		lblTipoDeDocumento.setBounds(37, 73, 105, 14);
		add(lblTipoDeDocumento);
		
		comboTipoDoc = new JComboBox();
		comboTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"", "DNI", "LC", "LE"}));
		comboTipoDoc.setBounds(139, 70, 165, 20);
		add(comboTipoDoc);
		
		JLabel lblNumeroDoc = new JLabel("N\u00FAmero de documento:");
		lblNumeroDoc.setBounds(369, 73, 117, 14);
		add(lblNumeroDoc);
		
		textNumeroDoc = new JTextField();
		textNumeroDoc.setBounds(496, 70, 190, 20);
		add(textNumeroDoc);
		textNumeroDoc.setColumns(10);
		//Permitir solo números
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
		
		
		/* Apellido, Nombre  y Direccion*/
		
		//Etiquetas
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(37, 37, 46, 14);
		add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(440, 37, 46, 14);
		add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(37, 141, 57, 14);
		add(lblDireccin);
		
		
		
		textApellido = new JTextField();
		textApellido.setBounds(88, 34, 214, 20);
		add(textApellido);
		textApellido.setColumns(10);
		//Permite solo letras y tamaño:50
		textApellido.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textApellido.setText(textApellido.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
       
             
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
        //Permite solo mayuscula
        textApellido.addFocusListener (new FocusListener()
        {


                @Override
                public void focusGained(FocusEvent arg0) {
                        // TODO Auto-generated method stub
                        
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                        {
                              String cadena = textApellido.getText();
                              textApellido.setText(cadena.toUpperCase());
                           }
                        
                }
        
                });
		
		textNombre = new JTextField();
		textNombre.setBounds(496, 34, 190, 20);
		add(textNombre);
		textNombre.setColumns(10);
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
	                        {
	                              String cadena = textNombre.getText();
	                              textNombre.setText(cadena.toUpperCase());
	                           }
	                        
	                }
	        
	                });
			
		
		
		textDireccion = new JTextField();
		textDireccion.setBounds(88, 138, 216, 20);
		add(textDireccion);
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
		
		/*Grupo Sanguino y Factor RH*/
		comboGrupoSanguineo = new JComboBox();
		comboGrupoSanguineo.setModel(new DefaultComboBoxModel(new String[] {"", "0", "A", "B", "AB"}));
		comboGrupoSanguineo.setBounds(134, 169, 57, 20);
		add(comboGrupoSanguineo);
		
		comboFactorRH = new JComboBox();
		comboFactorRH.setModel(new DefaultComboBoxModel(new String[] {"", "+", "-"}));
		comboFactorRH.setBounds(256, 169, 46, 20);
		add(comboFactorRH);

		JLabel lblNewLabel = new JLabel("Grupo sangu\u00EDneo:");
		lblNewLabel.setBounds(37, 172, 100, 14);
		add(lblNewLabel);
		
		JLabel lblFactorRh = new JLabel("Factor RH:");
		lblFactorRh.setBounds(201, 169, 57, 14);
		add(lblFactorRh);
		
		
		/*Clases : A,B,C,D,E,F,G 
		 * C ->B
		 * D -> C
		 * E -> C
		 */
		JCheckBox checkBoxClaseA = new JCheckBox("Clase A");
		checkBoxClaseA.setBounds(37, 229, 97, 23);
		add(checkBoxClaseA);
		
		
		JCheckBox checkBoxClaseB = new JCheckBox("Clase B");
		checkBoxClaseB.setBounds(37, 255, 97, 23);
		add(checkBoxClaseB);
		
		
		
		JCheckBox checkBoxClaseC = new JCheckBox("Clase C");
		checkBoxClaseC.setBounds(139, 229, 80, 23);
		add(checkBoxClaseC);
		
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
		
		
		JCheckBox checkBoxClaseD = new JCheckBox("Clase D\r\n");
		checkBoxClaseD.setBounds(139, 255, 86, 23);
		add(checkBoxClaseD);
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
		
		JCheckBox checkBoxClaseE = new JCheckBox("Clase E");
		checkBoxClaseE.setBounds(230, 229, 61, 23);
		add(checkBoxClaseE);
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
		
		JCheckBox chckbxClaseF = new JCheckBox("Clase F");
		chckbxClaseF.setBounds(230, 255, 61, 23);
		add(chckbxClaseF);
		
		JCheckBox chckbxClaseG = new JCheckBox("Clase G\r\n");
		chckbxClaseG.setBounds(328, 229, 66, 23);
		add(chckbxClaseG);

		/**/
		dateChooserNacimiento = new JDateChooser();
		dateChooserNacimiento.setBounds(149, 107, 155, 20);
		add(dateChooserNacimiento);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(37, 113, 105, 14);
		add(lblFechaDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(451, 113, 35, 14);
		add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Femenino", "Masculino"}));
		comboBoxSexo.setBounds(496, 107, 190, 20);
		add(comboBoxSexo);

		JCheckBox checkBoxDondante = new JCheckBox("Donante de \u00F3rganos");
		checkBoxDondante.setBounds(37, 295, 155, 23);
		add(checkBoxDondante);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(592, 346, 89, 23);
		add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAceptarAction(e);
				// TODO Auto-generated method stub
				
			}

			
		});
		
		JLabel lblClasesSolicitadas = new JLabel("Clases solicitadas:");
		lblClasesSolicitadas.setBounds(37, 197, 133, 14);
		add(lblClasesSolicitadas);
		
		//Foto
		JLabel lblImagen = new JLabel("Foto:");
		lblImagen.setBounds(37, 325, 46, 14);
		add(lblImagen);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(217, 321, 89, 23);
		add(btnSeleccionar);
		btnSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarAccion(e);
				// TODO Auto-generated method stub
				
			}
		});
		
		textRutaImagen = new JTextField();
		textRutaImagen.setBounds(73, 319, 133, 20);
		add(textRutaImagen);
		textRutaImagen.setColumns(10);
		
	
	
	}
	private void btnSeleccionarAccion(ActionEvent e){
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
	
		}
	}
	private void btnAceptarAction(ActionEvent e) {
		boolean licencia_previa=false; //MOOOOOOOODIFICAR con la funcion de logica
		if(!textNumeroDoc.getText().isEmpty() && comboTipoDoc.getSelectedIndex()!=0){
			/*if(verificarExistenciaTitular(textNumeroDoc)){
				
			}*/
		}
		//else{
			//throw new ExceptionNull();JOptionPane.showMessageDialog(this,"No se han cargado todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
		//}
		if (textApellido.getText().isEmpty() || textDireccion.getText().isEmpty()|| textNombre.getText().isEmpty()|| textRutaImagen.getText().isEmpty() 
				||comboBoxSexo.getSelectedIndex()==0 || comboFactorRH.getSelectedIndex()==0 || comboGrupoSanguineo.getSelectedIndex()==0 ||
				comboFactorRH.getSelectedIndex()==0 ){
			//throw new ExceptionNull();
			
		}
		//fechaNac = dateChooserNacimiento.getCalendar();
        //Calendar fecha = Calendar.getInstance();
        //if(fechaNac.after(fecha))
        //        throw new Excepcion("Fecha de nacimiento incorrecta");
		//else{
			
		//}
	}
}
