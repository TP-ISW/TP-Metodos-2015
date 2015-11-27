package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PanelTitularSeleccionado extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTitularSeleccionado() {
		{
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
			txtpnDarAltaTitular.setText("\r\n\tEMITIR LICENCIA");
			GridBagConstraints gbc_txtpnDarAltaTitular = new GridBagConstraints();
			gbc_txtpnDarAltaTitular.weightx = 1.0;
			gbc_txtpnDarAltaTitular.fill = GridBagConstraints.BOTH;
			gbc_txtpnDarAltaTitular.insets = new Insets(0, 0, 5, 0);
			gbc_txtpnDarAltaTitular.gridwidth = 10;
			gbc_txtpnDarAltaTitular.gridx = 0;
			gbc_txtpnDarAltaTitular.gridy = 0;
			add(txtpnDarAltaTitular, gbc_txtpnDarAltaTitular);
			
			
			
			
		
		}
	}

}