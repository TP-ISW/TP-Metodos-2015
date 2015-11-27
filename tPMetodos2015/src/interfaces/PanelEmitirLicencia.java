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
import java.awt.Insets;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JList;

import logica.EmitirLicencia;
import clasesDeTablas.Titular;
import excepciones.ExcepcionTabla;
import javax.swing.JScrollPane;

public class PanelEmitirLicencia extends JPanel {
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textNroDocumento;
	private JComboBox comboTipoDoc;
	//private DefaultListModel modeloListaTitulares;
	private JTable tablaTitulares;
	private DefaultTableModel modeloTablaTitulares;
	/**
	 * Create the panel.
	 */
	public PanelEmitirLicencia() {
		setBackground(new Color(245, 255, 250));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 146, 204, 17, 123, 157};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 51, 0, 97, 86, 0};
		gridBagLayout.columnWeights = new double[]{4.9E-324, 1.0, 1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
	
		JTextPane txtpnDarAltaTitular = new JTextPane();
		txtpnDarAltaTitular.setBackground(new Color(0, 0, 51));
		txtpnDarAltaTitular.setForeground(SystemColor.window);
		txtpnDarAltaTitular.setFont(new Font("Lato Heavy", Font.PLAIN, 30));
		txtpnDarAltaTitular.setText("\r\n\tEMITIR LICENCIA");
		GridBagConstraints gbc_txtpnDarAltaTitular = new GridBagConstraints();
		gbc_txtpnDarAltaTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnDarAltaTitular.gridwidth = 7;
		gbc_txtpnDarAltaTitular.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnDarAltaTitular.weightx = 1.0;
		gbc_txtpnDarAltaTitular.gridx = 0;
		gbc_txtpnDarAltaTitular.gridy = 1;
		add(txtpnDarAltaTitular, gbc_txtpnDarAltaTitular);
		
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
        	 String cadena = textNombre.getText();
             textNombre.setText(cadena.toUpperCase());
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
		comboTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"", "DNI", "LU"}));
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
                        false, false, false, false
                };
                public boolean isCellEditable(int row, int column) {
                        return columnEditables[column];
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
       
	}
	
	private void armarLista(){
		EmitirLicencia emitirLicencia= new EmitirLicencia();
		for (int i = tablaTitulares.getRowCount() -1; i >= 0; i--){ 
			modeloTablaTitulares.removeRow(i); 
			} 
		
		List<Titular> listaTit = emitirLicencia.buscarTitular(textNombre.getText(), textApellido.getText(), textNroDocumento.getText(),(String) comboTipoDoc.getSelectedItem());
		System.out.println(listaTit.size());
		for (Titular titular : listaTit) {
			//modeloListaTitulares.addElement(titular.getApellido());
			modeloTablaTitulares.addRow(new Object[]{titular,titular.getApellido(),titular.getNombre(),titular.getId().getTipoDoc(),titular.getId().getNroDoc()});
		}
	}
		
	private void btnSeleccionarAction(){
		try{
           
              int cantFilasSeleccionadas=0;
              cantFilasSeleccionadas=tablaTitulares.getSelectedRowCount();
               if (cantFilasSeleccionadas>1 || cantFilasSeleccionadas==0)
                            throw new ExcepcionTabla("Seleccionar solo una fila");
                 
	}
		catch(ExcepcionTabla e1){
			
		}
		
	
}
}