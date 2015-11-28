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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import clasesDeTablas.Clase;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;

public class PanelTitularSeleccionado extends JPanel {

	private JTable tablaTitulares;
	private DefaultTableModel modeloTablaTitulares;
	/**
	 * Create the panel.
	 */
	public PanelTitularSeleccionado(JFrame pantallaPrincipal, Titular titular) {
		
			setBackground(new Color(245, 255, 250));
			
			
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{44, 94, 129, 123, 140, 139, 83, 109, 108, 294, 0};
			gridBagLayout.rowHeights = new int[]{100, 16, 33, 38, 31, 33, 32, 35, 20, 35, 14, 23, 23, 41, 25, 147, 25, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			
			JLabel lblImagen = new JLabel("Foto:");
			GridBagConstraints gbc_lblImagen = new GridBagConstraints();
			gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
			gbc_lblImagen.gridx = 7;
			gbc_lblImagen.gridy = 1;
			add(lblImagen, gbc_lblImagen);
			lblImagen.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.anchor = GridBagConstraints.WEST;
			gbc_lblApellido.fill = GridBagConstraints.VERTICAL;
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 2;
			gbc_lblApellido.gridy = 2;
			add(lblApellido, gbc_lblApellido);
			
			JLabel labelApellidoTitular = new JLabel(titular.getApellido());
			labelApellidoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelApellidoTitular = new GridBagConstraints();
			gbc_labelApellidoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelApellidoTitular.gridx = 3;
			gbc_labelApellidoTitular.gridy = 2;
			add(labelApellidoTitular, gbc_labelApellidoTitular);
			
			
			
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.WEST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 4;
			gbc_lblNombre.gridy = 2;
			add(lblNombre, gbc_lblNombre);
			lblNombre.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelNombreTitular = new JLabel(titular.getNombre());
			labelNombreTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelNombreTitular = new GridBagConstraints();
			gbc_labelNombreTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelNombreTitular.gridx = 5;
			gbc_labelNombreTitular.gridy = 2;
			add(labelNombreTitular, gbc_labelNombreTitular);
			
			JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");
			GridBagConstraints gbc_lblTipoDeDocumento = new GridBagConstraints();
			gbc_lblTipoDeDocumento.anchor = GridBagConstraints.WEST;
			gbc_lblTipoDeDocumento.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoDeDocumento.gridx = 2;
			gbc_lblTipoDeDocumento.gridy = 3;
			add(lblTipoDeDocumento, gbc_lblTipoDeDocumento);
			lblTipoDeDocumento.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelTipoDocTitular = new JLabel(titular.getId().getTipoDoc());
			labelTipoDocTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelTipoDocTitular = new GridBagConstraints();
			gbc_labelTipoDocTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelTipoDocTitular.gridx = 3;
			gbc_labelTipoDocTitular.gridy = 3;
			add(labelTipoDocTitular, gbc_labelTipoDocTitular);
			
			JLabel lblNumeroDoc = new JLabel("N\u00FAmero de documento:");
			GridBagConstraints gbc_lblNumeroDoc = new GridBagConstraints();
			gbc_lblNumeroDoc.anchor = GridBagConstraints.EAST;
			gbc_lblNumeroDoc.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumeroDoc.gridx = 4;
			gbc_lblNumeroDoc.gridy = 3;
			add(lblNumeroDoc, gbc_lblNumeroDoc);
			lblNumeroDoc.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelNroDocTitular = new JLabel(titular.getId().getNroDoc());
			labelNroDocTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelNroDocTitular = new GridBagConstraints();
			gbc_labelNroDocTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelNroDocTitular.gridx = 5;
			gbc_labelNroDocTitular.gridy = 3;
			add(labelNroDocTitular, gbc_labelNroDocTitular);
			
			JLabel lblSexo = new JLabel("Sexo:");
			GridBagConstraints gbc_lblSexo = new GridBagConstraints();
			gbc_lblSexo.anchor = GridBagConstraints.WEST;
			gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSexo.gridx = 2;
			gbc_lblSexo.gridy = 4;
			add(lblSexo, gbc_lblSexo);
			lblSexo.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelSexoTitular = new JLabel(titular.getSexo());
			labelSexoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelSexoTitular = new GridBagConstraints();
			gbc_labelSexoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelSexoTitular.gridx = 3;
			gbc_labelSexoTitular.gridy = 4;
			add(labelSexoTitular, gbc_labelSexoTitular);
			
			JLabel labelFecha = new JLabel("Fecha de Nacimiento:");
			labelFecha.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFecha = new GridBagConstraints();
			gbc_labelFecha.insets = new Insets(0, 0, 5, 5);
			gbc_labelFecha.gridx = 2;
			gbc_labelFecha.gridy = 5;
			add(labelFecha, gbc_labelFecha);
			
			JLabel labelFechaNacTitular = new JLabel(titular.getFechaNacimiento().toString());
			labelFechaNacTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFechaNacTitular = new GridBagConstraints();
			gbc_labelFechaNacTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelFechaNacTitular.gridx = 3;
			gbc_labelFechaNacTitular.gridy = 5;
			add(labelFechaNacTitular, gbc_labelFechaNacTitular);
			
			JLabel lblGrupoSanguineo = new JLabel("Grupo sangu\u00EDneo:");
			lblGrupoSanguineo.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 6;
			add(lblGrupoSanguineo, gbc_lblNewLabel);
			
			JLabel labelGrupoSanguineoTitular = new JLabel(titular.getGrupoSanguineo());
			labelGrupoSanguineoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelGrupoSanguineoTitular = new GridBagConstraints();
			gbc_labelGrupoSanguineoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelGrupoSanguineoTitular.gridx = 3;
			gbc_labelGrupoSanguineoTitular.gridy = 6;
			add(labelGrupoSanguineoTitular, gbc_labelGrupoSanguineoTitular);
			
			JLabel lblFactorRh = new JLabel("Factor RH:");
			GridBagConstraints gbc_lblFactorRh = new GridBagConstraints();
			gbc_lblFactorRh.anchor = GridBagConstraints.WEST;
			gbc_lblFactorRh.insets = new Insets(0, 0, 5, 5);
			gbc_lblFactorRh.gridx = 4;
			gbc_lblFactorRh.gridy = 6;
			add(lblFactorRh, gbc_lblFactorRh);
			lblFactorRh.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelFactorTitular = new JLabel(titular.getFactorRh());
			labelFactorTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFactorTitular = new GridBagConstraints();
			gbc_labelFactorTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelFactorTitular.gridx = 5;
			gbc_labelFactorTitular.gridy = 6;
			add(labelFactorTitular, gbc_labelFactorTitular);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
			gbc_lblDireccin.anchor = GridBagConstraints.WEST;
			gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDireccin.gridx = 2;
			gbc_lblDireccin.gridy = 7;
			add(lblDireccin, gbc_lblDireccin);
			lblDireccin.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
				
			modeloTablaTitulares =(new DefaultTableModel(
			                new Object[][] {
			                },
			                new String[] {
			                       "Clase"
			                }
			        ) {
			                /**
			                 * 
			                 */
			                private static final long serialVersionUID = 1L;
			                boolean[] columnEditables = new boolean[] {
			                        false
			                };
			                public boolean isCellEditable(int row, int column) {
			                        return columnEditables[column];
			                }
			        });
			        
			       
			        
			for (Clase clase : titular.getClasesSolicitadas()) {
						
				modeloTablaTitulares.addRow(new Object[]{clase.getIdClase()});
			}
			
			JLabel labelDirecTitular = new JLabel(titular.getDomicilio());
			labelDirecTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelDirecTitutlar = new GridBagConstraints();
			gbc_labelDirecTitutlar.insets = new Insets(0, 0, 5, 5);
			gbc_labelDirecTitutlar.gridx = 3;
			gbc_labelDirecTitutlar.gridy = 7;
			add(labelDirecTitular, gbc_labelDirecTitutlar);
			
			JLabel lblClasesSolicitadas = new JLabel("Clases solicitadas:");
			GridBagConstraints gbc_lblClasesSolicitadas = new GridBagConstraints();
			gbc_lblClasesSolicitadas.anchor = GridBagConstraints.EAST;
			gbc_lblClasesSolicitadas.fill = GridBagConstraints.VERTICAL;
			gbc_lblClasesSolicitadas.insets = new Insets(0, 0, 5, 5);
			gbc_lblClasesSolicitadas.gridx = 2;
			gbc_lblClasesSolicitadas.gridy = 9;
			add(lblClasesSolicitadas, gbc_lblClasesSolicitadas);
			lblClasesSolicitadas.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 1;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 3;
			gbc_scrollPane.gridy = 10;
			add(scrollPane, gbc_scrollPane);
			
			tablaTitulares = new JTable();
			scrollPane.setViewportView(tablaTitulares);
			tablaTitulares.setModel(modeloTablaTitulares);

			JButton btnVisualizarLicencia = new JButton("Visuallizar licencia");
			btnVisualizarLicencia.setForeground(new Color(153, 0, 0));
			btnVisualizarLicencia.setFont(new Font("Lato Black", Font.PLAIN, 13));
			btnVisualizarLicencia.setBackground(new Color(240, 255, 255));
			GridBagConstraints gbc_btnVisualizarLicencia = new GridBagConstraints();
			gbc_btnVisualizarLicencia.anchor = GridBagConstraints.SOUTH;
			gbc_btnVisualizarLicencia.insets = new Insets(0, 0, 5, 5);
			gbc_btnVisualizarLicencia.gridx = 5;
			gbc_btnVisualizarLicencia.gridy = 14;
			add(btnVisualizarLicencia, gbc_btnVisualizarLicencia);
			btnVisualizarLicencia.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							btnVisualizarLicencia(pantallaPrincipal,titular);
							// TODO Auto-generated method stub
							
						}

						

						
					});
					
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.setForeground(new Color(153, 0, 0));
			btnImprimir.setFont(new Font("Lato Black", Font.PLAIN, 13));
			btnImprimir.setBackground(new Color(240, 255, 255));
			GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
			gbc_btnImprimir.anchor = GridBagConstraints.SOUTH;
			gbc_btnImprimir.insets = new Insets(0, 0, 5, 5);
			gbc_btnImprimir.gridx = 6;
			gbc_btnImprimir.gridy = 14;
			add(btnImprimir, gbc_btnImprimir);
			btnImprimir.addActionListener(new ActionListener() {
						
							@Override
							public void actionPerformed(ActionEvent e) {
								btnImprimirAction();
								// TODO Auto-generated method stub
								
							}


							

							
			});
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(new Color(153, 0, 0));
			btnCancelar.setFont(new Font("Lato Black", Font.PLAIN, 13));
			btnCancelar.setBackground(new Color(240, 255, 255));
			GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
			gbc_btnCancelar.anchor = GridBagConstraints.SOUTHWEST;
			gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
			gbc_btnCancelar.gridx = 7;
			gbc_btnCancelar.gridy = 14;
			add(btnCancelar, gbc_btnCancelar);
			btnCancelar.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									btnCancelarAction();
									// TODO Auto-generated method stub
									
								}

								


								

								
							});
			
		
		
	}

	private void btnVisualizarLicencia(JFrame pantallaPrincipal, Titular titular) {
		// TODO Auto-generated method stub
		Licenciavigente licenciaVigente= crearLicencia(titular);
		this.setVisible(false);
		
		
	}



	private void btnImprimirAction() {
		// TODO Auto-generated method stub
		
	}
	private void btnCancelarAction() {
		// TODO Auto-generated method stub
		
	}
	private Licenciavigente crearLicencia(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}

}

