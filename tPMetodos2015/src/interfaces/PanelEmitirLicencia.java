package interfaces;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

import logica.EmitirLicencia;
import clasesDeTablas.Titular;
import excepciones.ExcepcionTabla;
import javax.swing.JScrollPane;

public class PanelEmitirLicencia extends JPanel {
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textNroDocumento;
	private JComboBox comboTipoDoc;
	private JTable tablaTitulares;
	private DefaultTableModel modeloTablaTitulares;
	private JButton btnAceptar;
	/**
	 * Create the panel.
	 */
	public PanelEmitirLicencia(JFrame pantallaPrincipal) {
		setBackground(new Color(245, 255, 250));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 146, 204, 17, 236, 140, 157};
		gridBagLayout.rowHeights = new int[]{119, 13, 0, 0, 0, 0, 51, 0, 97, 140, 0, 86, 0};
		gridBagLayout.columnWeights = new double[]{4.9E-324, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
/*Titulo*/
		
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/Icono-mano-llave.png")); 
		Image imagen= img.getImage();
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(70,70,Image.SCALE_SMOOTH)); 
		
			
			JPanel panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(0, 0, 51));
			panelTitulo.setLayout(null);
			GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
			gbc_panelTitulo.gridwidth = 7;
			gbc_panelTitulo.insets = new Insets(0, 0, 5, 0);
			gbc_panelTitulo.fill = GridBagConstraints.BOTH;
			gbc_panelTitulo.gridx = 0;
			gbc_panelTitulo.gridy = 0;
			add(panelTitulo, gbc_panelTitulo);
			
			JTextPane txtpnTITULO = new JTextPane();
			txtpnTITULO.setBounds(137, 32, 337, 48);
			panelTitulo.add(txtpnTITULO);
			txtpnTITULO.setEditable(false);
			txtpnTITULO.setBackground(new Color(0, 0, 51));
			txtpnTITULO.setForeground(new Color(0, 102, 204));
			txtpnTITULO.setFont(new Font("Lato Heavy", Font.PLAIN, 30));
			txtpnTITULO.setText("EMITIR LICENCIA");
			JLabel lblImagen = new JLabel(iconoEscalado);
			lblImagen.setBounds(10, 11, 108, 84);
			panelTitulo.add(lblImagen);
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 3;
		add(lblApellido, gbc_lblApellido);
		
		textApellido = new JTextField();
		GridBagConstraints gbc_textApellido = new GridBagConstraints();
		gbc_textApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido.gridx = 2;
		gbc_textApellido.gridy = 3;
		add(textApellido, gbc_textApellido);
		textApellido.setColumns(10);
textApellido.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textApellido.setText(textApellido.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
              //e.toString().toUpperCase();
             
             if(!(Character.isLetter(c)) && !(c==' ')&& !(c=='\''))
            	 e.consume(); 

             if (textApellido.getText().length()== 50)
                 e.consume();
            
             armarLista();
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

textApellido.addFocusListener (new FocusListener()
{


        @Override
        public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
        	
        }

        @Override
        public void focusLost(FocusEvent arg0) {
        	 String cadena = textApellido.getText();
             textApellido.setText(cadena.toUpperCase());
        }

        });
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 4;
		add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
textNombre.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textNombre.setText(textNombre.getText().toUpperCase());
        	
                
              char c=e.getKeyChar(); 
       
             
             if(!(Character.isLetter(c)) && !(c==' ')&& !(c=='\''))
            	 e.consume(); 

             if (textNombre.getText().length()== 50)
                 e.consume();
             
             armarLista();
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
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento:");
		lblTipoDeDocumento.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTipoDeDocumento = new GridBagConstraints();
		gbc_lblTipoDeDocumento.anchor = GridBagConstraints.WEST;
		gbc_lblTipoDeDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeDocumento.gridx = 1;
		gbc_lblTipoDeDocumento.gridy = 5;
		add(lblTipoDeDocumento, gbc_lblTipoDeDocumento);
		
		comboTipoDoc = new JComboBox();
		comboTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"", "DNI", "LC", "LE"}));
		GridBagConstraints gbc_comboTipoDoc = new GridBagConstraints();
		gbc_comboTipoDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoDoc.gridx = 2;
		gbc_comboTipoDoc.gridy = 5;
		add(comboTipoDoc, gbc_comboTipoDoc);
		comboTipoDoc.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				   armarLista();
			   }
		});
		
		
		JLabel lblNmeroDeDocumento = new JLabel("N\u00FAmero de Documento:");
		lblNmeroDeDocumento.setFont(new Font("Lato Medium", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNmeroDeDocumento = new GridBagConstraints();
		gbc_lblNmeroDeDocumento.anchor = GridBagConstraints.EAST;
		gbc_lblNmeroDeDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeDocumento.gridx = 4;
		gbc_lblNmeroDeDocumento.gridy = 5;
		add(lblNmeroDeDocumento, gbc_lblNmeroDeDocumento);
		
		
		
        modeloTablaTitulares =(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                       "Titular", "Apellido", "Nombres", "Tipo de documento", "Número de documento"
                }
        ) {
                /**
                 * 
                 */
                private static final long serialVersionUID = 1L;
                boolean[] columnEditables = new boolean[] {
                        false, false, false, false,false
                };
                public boolean isCellEditable(int row, int column) {
                        return columnEditables[column];
                }
        });
        
        textNroDocumento = new JTextField();
        GridBagConstraints gbc_textNroDocumento = new GridBagConstraints();
        gbc_textNroDocumento.insets = new Insets(0, 0, 5, 5);
        gbc_textNroDocumento.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNroDocumento.gridx = 5;
        gbc_textNroDocumento.gridy = 5;
        add(textNroDocumento, gbc_textNroDocumento);
        textNroDocumento.setColumns(10);
        textNroDocumento.addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent e)
             
            {textNroDocumento.setText(textNroDocumento.getText().toUpperCase());
            
              char c=e.getKeyChar(); 
     
             
              if(!(Character.isDigit(c)) )
            	  e.consume(); 
              if (textNroDocumento.getText().length()== 8)
                 e.consume();
              
              armarLista();
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
        
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridwidth = 4;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 8;
        add(scrollPane, gbc_scrollPane);
        
        tablaTitulares = new JTable();
        scrollPane.setViewportView(tablaTitulares);
        tablaTitulares.setModel(modeloTablaTitulares);

        
        tablaTitulares.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaTitulares.getColumnModel().getColumn(0).setMinWidth(0);
        tablaTitulares.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		
		ImageIcon home= new ImageIcon(this.getClass().getResource("/imagenes/home.png"));
		Image imagenHome= home.getImage();
		ImageIcon homeEscalada = new ImageIcon (imagenHome.getScaledInstance(30,30,Image.SCALE_SMOOTH)); 
		 
		  btnAceptar = new JButton("Aceptar");
		  btnAceptar.setForeground(new Color(0, 0, 51));
		  btnAceptar.setFont(new Font("Lato Black", Font.PLAIN, 13));
		  btnAceptar.setBackground(new Color(240, 255, 255));
		  GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		  gbc_btnAceptar.anchor = GridBagConstraints.SOUTH;
		  gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		  gbc_btnAceptar.gridx = 5;
		  gbc_btnAceptar.gridy = 10;
		  add(btnAceptar, gbc_btnAceptar);
		  btnAceptar.addActionListener(new ActionListener() {
		  	
		  	@Override
		  	public void actionPerformed(ActionEvent e) {

					try {
						btnAceptarAction(pantallaPrincipal);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		  	}

		  	
		  });
		 JButton btnHome = new JButton();
		 btnHome.setBackground(new Color(245, 255, 250));
			btnHome.setOpaque(true);
			btnHome.setBorder(null);
		 btnHome.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnHomeAction(pantallaPrincipal);
		 	}

		 	
		 });
		 btnHome.setForeground(new Color(245, 255, 250));
		 btnHome.setBackground(new Color(245, 255, 250));
		 GridBagConstraints gbc_btnHome = new GridBagConstraints();
		 gbc_btnHome.insets = new Insets(0, 0, 5, 0);
		 gbc_btnHome.anchor = GridBagConstraints.SOUTHWEST;
		 gbc_btnHome.gridx = 6;
		 gbc_btnHome.gridy = 10;
		 add(btnHome, gbc_btnHome);
		 btnHome.setIcon(homeEscalada);
		
		 
		
	}
	
	private void armarLista(){
		EmitirLicencia emitirLicencia= new EmitirLicencia();
		for (int i = tablaTitulares.getRowCount() -1; i >= 0; i--){ 
			modeloTablaTitulares.removeRow(i); 
			} 
		
		List<Titular> listaTit = emitirLicencia.buscarTitular(textNombre.getText(), textApellido.getText(), textNroDocumento.getText(),(String) comboTipoDoc.getSelectedItem());
		System.out.println(listaTit.size());
		for (Titular titular : listaTit) {
			
			modeloTablaTitulares.addRow(new Object[]{titular,titular.getApellido(),titular.getNombre(),titular.getId().getTipoDoc(),titular.getId().getNroDoc()});
		}
	
		
	}
	
	
	
	

	private void btnAceptarAction(JFrame pantallaPrincipal) throws MalformedURLException {
		// TODO Auto-generated method stub
		try{
		if(tablaTitulares.getSelectedRowCount()!=1 )
			 throw new ExcepcionTabla("Seleccionar fila");
		Titular titularSeleccionado= (Titular) tablaTitulares.getValueAt(tablaTitulares.getSelectedRow(),0);
		
            
		setVisible(false);
		pantallaPrincipal.setContentPane(new PanelTitularSeleccionado(pantallaPrincipal, titularSeleccionado));
		
		}
		
		
		catch(ExcepcionTabla e1){
			 JOptionPane.showMessageDialog(this,e1.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private void btnHomeAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		setVisible(false);
		pantallaPrincipal.setContentPane(new PanelMenu(pantallaPrincipal));
	}

}