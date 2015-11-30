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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import clasesDeTablas.Titular;
import excepciones.ExcepcionContribuyente;
import excepciones.ExcepcionLicenciasInvalidas;
import excepciones.ExcepcionNull;
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

import java.awt.Image;

public class PanelMenu extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AltaTitular altaTitular = new AltaTitular();
	private JLabel labelFoto;
	private JButton btnAceptar;
	private JButton btnAltaTitular;
	private JButton btnEmitirLicencia;
	private JPanel panelTitulo;
	/**
	 * Create the panel.
	 */
	public PanelMenu(JFrame pantallaPrincipal) {
		setBackground(new Color(245, 255, 250));
		
		
		
		
			GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{44, 94, 129, 123, 65, 20, 83, 109, 108, 294, 0};
		gridBagLayout.rowHeights = new int[]{120, 16, 56, 25, 24, 24, 20, 20, 35, 14, 23, 23, 41, 25, 147, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		/*Titulo*/
	
		
		panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 0, 51));
		panelTitulo.setLayout(null);
		GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
		gbc_panelTitulo.gridwidth = 10;
		gbc_panelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitulo.fill = GridBagConstraints.BOTH;
		gbc_panelTitulo.gridx = 0;
		gbc_panelTitulo.gridy = 0;
		add(panelTitulo, gbc_panelTitulo);
		
		JTextPane txtpnTITULO = new JTextPane();
		txtpnTITULO.setBounds(128, 0, 259, 80);
		panelTitulo.add(txtpnTITULO);
		txtpnTITULO.setEditable(false);
		txtpnTITULO.setBackground(new Color(0, 0, 51));
		txtpnTITULO.setForeground(new Color(0, 102, 204));
		txtpnTITULO.setFont(new Font("Lato Heavy", Font.PLAIN, 30));
		txtpnTITULO.setText("\r\nMENU PRINCIPAL");
		
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/Icono-mano-llave.png")); 
		Image imagen= img.getImage();
		ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(70,70,Image.SCALE_SMOOTH)); 
		JLabel lblImagen = new JLabel(iconoEscalado);
		lblImagen.setBounds(10, 11, 108, 84);
		panelTitulo.add(lblImagen);
		
		
		
		
		ImageIcon iconoAltaTitular=new ImageIcon(this.getClass().getResource("/imagenes/iconoAltaTitular.png")); 
		Image imagenAltaTitular= iconoAltaTitular.getImage();
		ImageIcon imagenAltaTitularEscalada = new ImageIcon (imagenAltaTitular.getScaledInstance(50,50,Image.SCALE_SMOOTH)); 
		btnAltaTitular = new JButton("\t\t\tAlta Titular");
		btnAltaTitular.setBackground(new Color(245, 255, 250));
		btnAltaTitular.setOpaque(true);
		btnAltaTitular.setBorder(null);
		btnAltaTitular.setIcon(imagenAltaTitularEscalada);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		add(btnAltaTitular, gbc_btnNewButton);
		btnAltaTitular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAltaTitularAction(pantallaPrincipal);
				// TODO Auto-generated method stub
				
			}

		

			
		});
		
		btnEmitirLicencia = new JButton("Emitir Licencia");
		ImageIcon iconoEmitirLicencia=new ImageIcon(this.getClass().getResource("/imagenes/iconoEmitirLicencia.png")); 
		Image imagenEmitirLicencia= iconoEmitirLicencia.getImage();
		ImageIcon imagenEmitirLicenciaEscalada = new ImageIcon (imagenEmitirLicencia.getScaledInstance(50,50,Image.SCALE_SMOOTH)); 
	
		btnEmitirLicencia.setBackground(new Color(245, 255, 250));
		btnEmitirLicencia.setBorder(null);
		btnEmitirLicencia.setIcon(imagenEmitirLicenciaEscalada);
		GridBagConstraints gbc_btnEmitirLicencia = new GridBagConstraints();
		gbc_btnEmitirLicencia.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmitirLicencia.gridx = 3;
		gbc_btnEmitirLicencia.gridy = 5;
		add(btnEmitirLicencia, gbc_btnEmitirLicencia);
btnEmitirLicencia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEmitirLicenciaAction(pantallaPrincipal);
				// TODO Auto-generated method stub
				
			}


		

			
		});
		
		
		
	
	}
	
	private void btnAltaTitularAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		this.removeAll();
		PanelAltaTitular panelAlta = new PanelAltaTitular(pantallaPrincipal);
		pantallaPrincipal.setContentPane(panelAlta);
	}
	

	private void btnEmitirLicenciaAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		this.removeAll();
		PanelEmitirLicencia panelEmitirLicencia = new PanelEmitirLicencia(pantallaPrincipal);
		pantallaPrincipal.setContentPane(panelEmitirLicencia);
		
	}
}
