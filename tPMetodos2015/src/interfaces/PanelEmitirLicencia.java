package interfaces;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.SystemColor;
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

public class PanelEmitirLicencia extends JPanel {
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textNroDocumento;
	private JList listaTitulares;
	private JComboBox comboTipoDoc;
	private DefaultListModel modeloListaTitulares;

	/**
	 * Create the panel.
	 */
	public PanelEmitirLicencia() {
		setBackground(new Color(245, 255, 250));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{43, 146, 204, 17, 123, 157};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{4.9E-324, 0.0, 1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
              e.toString().toUpperCase();
             
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
		
		listaTitulares = new JList();
		modeloListaTitulares = new DefaultListModel();
		GridBagConstraints gbc_listaTitulares = new GridBagConstraints();
		gbc_listaTitulares.gridwidth = 4;
		gbc_listaTitulares.insets = new Insets(0, 0, 0, 5);
		gbc_listaTitulares.fill = GridBagConstraints.BOTH;
		gbc_listaTitulares.gridx = 2;
		gbc_listaTitulares.gridy = 8;
		add(listaTitulares, gbc_listaTitulares);
		listaTitulares.setModel(modeloListaTitulares);

	}
	
	private void armarLista(){
		EmitirLicencia emitirLicencia= new EmitirLicencia();
		List<Titular> listaTit = emitirLicencia.buscarTitular(textNombre.getText(), textApellido.getText(), textNroDocumento.getText(),(String) comboTipoDoc.getSelectedItem());
		for (Titular titular : listaTit) {
			modeloListaTitulares.addElement(titular.getApellido());
		}
	}

}
