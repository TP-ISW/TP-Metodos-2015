package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class PantallaPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuItem menu_EmitirLicencia;
	private JMenuItem menu_AltaTitular;
	
	


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setResizable(false);
		
		
		
		
		setFont(new Font("Lato", Font.PLAIN, 12));
		setTitle("Licencia de conducir\t\t\t\t\t\t\t\t\t\t\t\t");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 980, 710);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoCarnet.png")).getImage());
		

		/*
		// Logo 
		ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/iconoAuto.png")); 
		JLabel lblNewLabel = new JLabel(img);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		 */
		
		/*
		JMenuBar menuBar
	    |_______ JMenu (menu)
	    |           |_______ JMenuItem (menu_AltaTitular)
	    |           |_______ JMenuItem (menu_EmitirLicenci)
	    |
	    |_______ JMenu (Edición)
	    |
	    |_______ JMenu (Ayuda)
	              
		*/
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Men\u00FA");
		menu.setFont(new Font("Lato", Font.PLAIN, 13));
		menu.setForeground(UIManager.getColor("Button.light"));
		menuBar.add(menu);
		
		menu_AltaTitular = new JMenuItem("Alta titular");
		menu.add(menu_AltaTitular);
		menu_AltaTitular.addActionListener(this);
		
		
		menu_EmitirLicencia = new JMenuItem("Emitir Licencia");
		menu.add(menu_EmitirLicencia);
		menu_EmitirLicencia.addActionListener(this);
		
		JMenu edicion = new JMenu("Edici\u00F3n");
		edicion.setForeground(UIManager.getColor("Button.light"));
		edicion.setFont(new Font("Lato", Font.PLAIN, 13));
		menuBar.add(edicion);
		
		JMenu ayuda = new JMenu("Ayuda");
		ayuda.setForeground(UIManager.getColor("Button.light"));
		ayuda.setFont(new Font("Lato", Font.PLAIN, 13));
		menuBar.add(ayuda);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		PanelMenu panelMenu = new PanelMenu(this);
		setContentPane(panelMenu);
		
		
		
		
		
		
		
		
		
	}

	



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== menu_AltaTitular){
			PanelAltaTitular panelAltaTitular= new PanelAltaTitular(this);
			setContentPane(panelAltaTitular);
		}
		if(e.getSource()== menu_EmitirLicencia){
			PanelEmitirLicencia panelEmitirLicencia= new PanelEmitirLicencia(this);
			setContentPane(panelEmitirLicencia);
		}
	}
}