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
import javax.swing.UIManager;
import java.awt.Font;

public class PantallaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	//private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		
		// Logo 
		ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/icono.png"));
	    
	    
	    JLabel icono = new JLabel(img);
	    icono.setBounds(677, 11, 142, 141);
	    add(icono);
		
		setFont(new Font("Lato", Font.PLAIN, 12));
		setTitle("Licencia de conducir\t\t\t\t\t\t\t\t\t\t\t\t");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 929, 718);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FA");
		mnNewMenu.setFont(new Font("Lato", Font.PLAIN, 13));
		mnNewMenu.setForeground(UIManager.getColor("Button.light"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAltaTitular = new JMenuItem("Alta titular");
		mnNewMenu.add(mntmAltaTitular);
		
		JMenuItem mntmEmitirLicencia = new JMenuItem("Emitir Licencia");
		mnNewMenu.add(mntmEmitirLicencia);
		
		JMenu mnEdicin = new JMenu("Edici\u00F3n");
		mnEdicin.setForeground(UIManager.getColor("Button.light"));
		mnEdicin.setFont(new Font("Lato", Font.PLAIN, 13));
		menuBar.add(mnEdicin);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setForeground(UIManager.getColor("Button.light"));
		mnAyuda.setFont(new Font("Lato", Font.PLAIN, 13));
		menuBar.add(mnAyuda);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
		PanelAltaTitular panelAltaTitular = new PanelAltaTitular();
		setContentPane(panelAltaTitular);
	}

}
