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
	/**
	 * Create the panel.
	 */
	public PanelMenu(JFrame pantallaPrincipal) {
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
		
		/*Titulo*/
		JTextPane txtpnDarAltaTitular = new JTextPane();
		txtpnDarAltaTitular.setEditable(false);
		txtpnDarAltaTitular.setBackground(new Color(0, 0, 51));
		txtpnDarAltaTitular.setForeground(SystemColor.window);
		txtpnDarAltaTitular.setFont(new Font("Lato Heavy", Font.PLAIN, 30));
		txtpnDarAltaTitular.setText("\r\n\tMENU PRINCIPAL");
		GridBagConstraints gbc_txtpnDarAltaTitular = new GridBagConstraints();
		gbc_txtpnDarAltaTitular.weightx = 1.0;
		gbc_txtpnDarAltaTitular.fill = GridBagConstraints.BOTH;
		gbc_txtpnDarAltaTitular.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnDarAltaTitular.gridwidth = 10;
		gbc_txtpnDarAltaTitular.gridx = 0;
		gbc_txtpnDarAltaTitular.gridy = 0;
		add(txtpnDarAltaTitular, gbc_txtpnDarAltaTitular);
		
		btnAltaTitular = new JButton("Alta Titular");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
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
		GridBagConstraints gbc_btnEmitirLicencia = new GridBagConstraints();
		gbc_btnEmitirLicencia.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmitirLicencia.gridx = 2;
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
		PanelAltaTitular panelAlta = new PanelAltaTitular();
		pantallaPrincipal.setContentPane(panelAlta);
	}
	

	private void btnEmitirLicenciaAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		this.removeAll();
		PanelEmitirLicencia panelEmitirLicencia = new PanelEmitirLicencia();
		pantallaPrincipal.setContentPane(panelEmitirLicencia);
		
	}
}
