package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import clasesDeTablas.Titular;
import excepciones.ExcepcionNull;
import excepciones.ExcepcionValidador;
import logica.AltaTitular;

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
	/**
	 * Create the panel.
	 */
	public PanelAltaTitular() {
		setLayout(null);
		
		//ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/icono.jpg"));
        
        //setBackground(new Color(105, 105, 105));
        //setForeground(new Color(128, 128, 0));
        
        
        
        //icono = new JLabel(img);
        //icono.setBounds(677, 11, 142, 141);
        //add(icono);
		
		/*Numero y tipo de documento*/
		//etiquetas
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");
		lblTipoDeDocumento.setBounds(37, 73, 105, 14);
		add(lblTipoDeDocumento);
		
		JLabel lblNumeroDoc = new JLabel("N\u00FAmero de documento:");
		lblNumeroDoc.setBounds(369, 73, 117, 14);
		add(lblNumeroDoc);
		
		//Combo box con opciones de tipo de documento
		comboTipoDoc = new JComboBox<String>();
		comboTipoDoc.setModel(new DefaultComboBoxModel<String>(new String[] {"", "DNI", "LC", "LE"}));
		comboTipoDoc.setBounds(139, 70, 165, 20);
		add(comboTipoDoc);
		
		//Campo a completar con numero de documento
		textNumeroDoc = new JTextField();
		textNumeroDoc.setBounds(496, 70, 190, 20);
		add(textNumeroDoc);
		textNumeroDoc.setColumns(10);
		
		//Campo NumeroDoc permite solo números y maximo 8
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
					AltaTitular titularAValidar = new AltaTitular();
					Titular titular = titularAValidar.verificarExistenciaTitular(textNumeroDoc.getText(), comboTipoDoc.getSelectedItem().toString());
					if(titular!=null){
						titularExistente(titular);
					}
				}
				
				
				
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
		
		//Campo a completar con Apellido
		textApellido = new JTextField();
		textApellido.setBounds(88, 34, 214, 20);
		add(textApellido);
		textApellido.setColumns(10);
		
		
		//Campo textApellido permite solo letras y tamaño:50
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
		
        //Campo a completar Nombre
		textNombre = new JTextField();
		textNombre.setBounds(496, 34, 190, 20);
		add(textNombre);
		textNombre.setColumns(10);
		//Campo textNombre permite solo letras (espacio y ') y tamaño:50, y mayuscula
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
			
		
		//Campo textDireccion permite solo letras, numeros (espacio y ') y tamaño:50, y mayuscula
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
		 //etiquetas
		 JLabel lblNewLabel = new JLabel("Grupo sangu\u00EDneo:");
		 lblNewLabel.setBounds(37, 172, 100, 14);
		 add(lblNewLabel);
			
		 JLabel lblFactorRh = new JLabel("Factor RH:");
		 lblFactorRh.setBounds(201, 169, 57, 14);
		 add(lblFactorRh);
			
			
		//Combo box con opciones de gurpo sanguino
		comboGrupoSanguineo = new JComboBox<String>();
		comboGrupoSanguineo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0", "A", "B", "AB"}));
		comboGrupoSanguineo.setBounds(134, 169, 57, 20);
		add(comboGrupoSanguineo);
		
		//Combo box con opciones de factor RH
		comboFactorRH = new JComboBox<String>();
		comboFactorRH.setModel(new DefaultComboBoxModel<String>(new String[] {"", "+", "-"}));
		comboFactorRH.setBounds(256, 169, 46, 20);
		add(comboFactorRH);

		
		
		
		/*Clases : A,B,C,D,E,F,G 
		 * C ->B
		 * D -> C
		 * E -> C
		 */
		JLabel lblClasesSolicitadas = new JLabel("Clases solicitadas:");
		lblClasesSolicitadas.setBounds(37, 197, 133, 14);
		add(lblClasesSolicitadas);
		
		JCheckBox checkBoxClaseA = new JCheckBox("Clase A");
		checkBoxClaseA.setBounds(37, 229, 97, 23);
		add(checkBoxClaseA);
		
		
		JCheckBox checkBoxClaseB = new JCheckBox("Clase B");
		checkBoxClaseB.setBounds(37, 255, 97, 23);
		add(checkBoxClaseB);
		
		
		
		JCheckBox checkBoxClaseC = new JCheckBox("Clase C");
		checkBoxClaseC.setBounds(226, 229, 114, 23);
		add(checkBoxClaseC);
		
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
		
		//Si se selecciona D, se desactiva la opcion de seleccionar C y B
		JCheckBox checkBoxClaseD = new JCheckBox("Clase D\r\n");
		checkBoxClaseD.setBounds(190, 363, 114, 23);
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
		
		//Si se selecciona E, se desactiva la opcion de seleccionar B,C y E
		JCheckBox checkBoxClaseE = new JCheckBox("Clase E");
		checkBoxClaseE.setBounds(399, 229, 83, 23);
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
		chckbxClaseF.setBounds(403, 255, 83, 23);
		add(chckbxClaseF);
		
		JCheckBox chckbxClaseG = new JCheckBox("Clase G\r\n");
		chckbxClaseG.setBounds(583, 229, 66, 23);
		add(chckbxClaseG);

		/*Fecha de nacimiento*/
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(37, 113, 105, 14);
		add(lblFechaDeNacimiento);
		
		dateChooserNacimiento = new JDateChooser();
		dateChooserNacimiento.setBounds(149, 107, 155, 20);
		add(dateChooserNacimiento);
		
		
		/*Sexo*/
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(451, 113, 35, 14);
		add(lblSexo);
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Femenino", "Masculino"}));
		comboBoxSexo.setBounds(496, 107, 190, 20);
		add(comboBoxSexo);

		JCheckBox checkBoxDondante = new JCheckBox("Donante de \u00F3rganos");
		checkBoxDondante.setBounds(37, 295, 155, 23);
		add(checkBoxDondante);
		
		
		
		/* Boton Aceptar*/
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(592, 346, 89, 23);
		add(btnAceptar);
		
		//Si se selecciona el boton aceptar se ejecuta la funcion btnAceptarAction() y se envia el evento e(de seleccion)
		btnAceptar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAceptarAction(e);
				// TODO Auto-generated method stub
				
			}

			
		});
		
		
		/*Foto*/
		JLabel lblImagen = new JLabel("Foto:");
		lblImagen.setBounds(37, 325, 46, 14);
		add(lblImagen);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(217, 321, 89, 23);
		add(btnSeleccionar);
		//Si se selecciona el boton "Seleccionar" se ejecuta la funcion btnSeleccionarAction() y se envia el evento e(de seleccion)
		btnSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarAction(e);
				// TODO Auto-generated method stub
				
			}
		});
		
		textRutaImagen = new JTextField();
		textRutaImagen.setBounds(73, 319, 133, 20);
		add(textRutaImagen);
		textRutaImagen.setColumns(10);
		
	
	
	}
	private void btnSeleccionarAction(ActionEvent e){
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
	
		try{
			
		//Verificar Nulidad de numero y tipo de documento
		if(textNumeroDoc.getText().isEmpty() && comboTipoDoc.getSelectedIndex()==0)
			throw new ExcepcionNull();
			//Si no son nulos, verificar que los digitos del documento sean >= 7
			else if(textNumeroDoc.getText().length()<7){
				//si es menor a 7, se genera una excepcion
				throw new ExcepcionValidador("Documento: cantidad de digitos de digitos incorrectos");
			}
		
		
		//Verificar nulidad
		if (textApellido.getText().isEmpty() || textDireccion.getText().isEmpty()|| textNombre.getText().isEmpty()|| textRutaImagen.getText().isEmpty() 
				||comboBoxSexo.getSelectedIndex()==0 || comboFactorRH.getSelectedIndex()==0 || comboGrupoSanguineo.getSelectedIndex()==0 ||
				comboFactorRH.getSelectedIndex()==0 ){
			throw new ExcepcionNull();
			
		}
		Calendar fechaNac = dateChooserNacimiento.getCalendar();
        Calendar fecha = Calendar.getInstance();
        if(fechaNac.after(fecha))
                throw new ExcepcionValidador("Fecha de nacimiento incorrecta");
		else{
			
		}
	}
		catch(ExcepcionNull e1){ JOptionPane.showMessageDialog(this,"No se han cargado todos los datos", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
		catch (ExcepcionValidador e2){
			 JOptionPane.showMessageDialog(this,e2.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		}
	

	private void titularExistente(Titular titular) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,	titular.getApellido()+'\t'+titular.getNombre(), "Titular existente", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
