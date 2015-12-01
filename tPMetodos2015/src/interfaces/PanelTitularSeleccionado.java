package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.net.MalformedURLException;

import clasesDeTablas.Clase;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;
import excepciones.ExcepcionClaseLicencia;
import excepciones.ExcepcionNull;
import excepciones.ExcepcionTabla;
import logica.EmitirLicencia;
import persistencia.FabricaSessionFactory;

import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelTitularSeleccionado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaClase;
	private DefaultTableModel modeloTablaClase;
	private JEditorPane editorPaneObserv;
	private JComboBox comboCategoria;
	
	public PanelTitularSeleccionado(JFrame pantallaPrincipal, Titular titular) {
		
			setBackground(new Color(245, 255, 250));
			
			
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{136, 118, 378, 166, 139, 32, 0, 114, 109, 0};
			gridBagLayout.rowHeights = new int[]{123, 16, 33, 38, 31, 33, 32, 35, 20, 35, 97, 0, 23, 58, 13, 30, 48, 25, 147, 25, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			/*Titulo*/
			
			
			ImageIcon img=new ImageIcon(this.getClass().getResource("/imagenes/Icono-mano-llave.png")); 
			Image imagen= img.getImage();
			ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(70,70,Image.SCALE_SMOOTH)); 
			
				
				JPanel panelTitulo = new JPanel();
				panelTitulo.setBackground(new Color(0, 0, 51));
				panelTitulo.setLayout(null);
				GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
				gbc_panelTitulo.gridwidth = 9;
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
			lblApellido.setForeground(new Color(0, 0, 153));
			lblApellido.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.anchor = GridBagConstraints.EAST;
			gbc_lblApellido.fill = GridBagConstraints.VERTICAL;
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 1;
			gbc_lblApellido.gridy = 2;
			add(lblApellido, gbc_lblApellido);
			
			JLabel labelApellidoTitular = new JLabel(titular.getApellido());
			labelApellidoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelApellidoTitular = new GridBagConstraints();
			gbc_labelApellidoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelApellidoTitular.gridx = 2;
			gbc_labelApellidoTitular.gridy = 2;
			add(labelApellidoTitular, gbc_labelApellidoTitular);
			
			
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 3;
			gbc_lblNombre.gridy = 2;
			add(lblNombre, gbc_lblNombre);
			lblNombre.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelNombreTitular = new JLabel(titular.getNombre());
			labelNombreTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelNombreTitular = new GridBagConstraints();
			gbc_labelNombreTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelNombreTitular.gridx = 4;
			gbc_labelNombreTitular.gridy = 2;
			add(labelNombreTitular, gbc_labelNombreTitular);
			
			
			
			JLabel lblTipoDeDocumento = new JLabel("Tipo de documento:");
			lblTipoDeDocumento.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblTipoDeDocumento = new GridBagConstraints();
			gbc_lblTipoDeDocumento.anchor = GridBagConstraints.EAST;
			gbc_lblTipoDeDocumento.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoDeDocumento.gridx = 1;
			gbc_lblTipoDeDocumento.gridy = 3;
			add(lblTipoDeDocumento, gbc_lblTipoDeDocumento);
			lblTipoDeDocumento.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelTipoDocTitular = new JLabel(titular.getId().getTipoDoc());
			labelTipoDocTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelTipoDocTitular = new GridBagConstraints();
			gbc_labelTipoDocTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelTipoDocTitular.gridx = 2;
			gbc_labelTipoDocTitular.gridy = 3;
			add(labelTipoDocTitular, gbc_labelTipoDocTitular);
			
			JLabel lblNumeroDoc = new JLabel("N\u00FAmero de documento:");
			lblNumeroDoc.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblNumeroDoc = new GridBagConstraints();
			gbc_lblNumeroDoc.anchor = GridBagConstraints.EAST;
			gbc_lblNumeroDoc.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumeroDoc.gridx = 3;
			gbc_lblNumeroDoc.gridy = 3;
			add(lblNumeroDoc, gbc_lblNumeroDoc);
			lblNumeroDoc.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelNroDocTitular = new JLabel(titular.getId().getNroDoc());
			labelNroDocTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelNroDocTitular = new GridBagConstraints();
			gbc_labelNroDocTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelNroDocTitular.gridx = 4;
			gbc_labelNroDocTitular.gridy = 3;
			add(labelNroDocTitular, gbc_labelNroDocTitular);
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblSexo = new GridBagConstraints();
			gbc_lblSexo.anchor = GridBagConstraints.EAST;
			gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSexo.gridx = 1;
			gbc_lblSexo.gridy = 4;
			add(lblSexo, gbc_lblSexo);
			lblSexo.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelSexoTitular = new JLabel(titular.getSexo());
			labelSexoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelSexoTitular = new GridBagConstraints();
			gbc_labelSexoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelSexoTitular.gridx = 2;
			gbc_labelSexoTitular.gridy = 4;
			add(labelSexoTitular, gbc_labelSexoTitular);
			
			JLabel labelFecha = new JLabel("Fecha de Nacimiento:");
			labelFecha.setForeground(new Color(0, 0, 153));
			labelFecha.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFecha = new GridBagConstraints();
			gbc_labelFecha.anchor = GridBagConstraints.WEST;
			gbc_labelFecha.insets = new Insets(0, 0, 5, 5);
			gbc_labelFecha.gridx = 1;
			gbc_labelFecha.gridy = 5;
			add(labelFecha, gbc_labelFecha);
			
			Calendar fecha= titular.getFechaNacimiento();
			JLabel labelFechaNacTitular = new JLabel(""+fecha.getInstance().get(Calendar.YEAR)+"/"+fecha.getInstance().get(Calendar.MONTH)+"/"+fecha.getInstance().get(Calendar.DATE));
			labelFechaNacTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFechaNacTitular = new GridBagConstraints();
			gbc_labelFechaNacTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelFechaNacTitular.gridx = 2;
			gbc_labelFechaNacTitular.gridy = 5;
			add(labelFechaNacTitular, gbc_labelFechaNacTitular);
			
			JLabel lblGrupoSanguineo = new JLabel("Grupo sangu\u00EDneo:");
			lblGrupoSanguineo.setForeground(new Color(0, 0, 153));
			lblGrupoSanguineo.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_lblGrupoSanguineo = new GridBagConstraints();
			gbc_lblGrupoSanguineo.anchor = GridBagConstraints.EAST;
			gbc_lblGrupoSanguineo.insets = new Insets(0, 0, 5, 5);
			gbc_lblGrupoSanguineo.gridx = 1;
			gbc_lblGrupoSanguineo.gridy = 6;
			add(lblGrupoSanguineo, gbc_lblGrupoSanguineo);
			
			JLabel labelGrupoSanguineoTitular = new JLabel(titular.getGrupoSanguineo());
			labelGrupoSanguineoTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelGrupoSanguineoTitular = new GridBagConstraints();
			gbc_labelGrupoSanguineoTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelGrupoSanguineoTitular.gridx = 2;
			gbc_labelGrupoSanguineoTitular.gridy = 6;
			add(labelGrupoSanguineoTitular, gbc_labelGrupoSanguineoTitular);
			
			JLabel lblFactorRh = new JLabel("Factor RH:");
			lblFactorRh.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblFactorRh = new GridBagConstraints();
			gbc_lblFactorRh.anchor = GridBagConstraints.EAST;
			gbc_lblFactorRh.insets = new Insets(0, 0, 5, 5);
			gbc_lblFactorRh.gridx = 3;
			gbc_lblFactorRh.gridy = 6;
			add(lblFactorRh, gbc_lblFactorRh);
			lblFactorRh.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			JLabel labelFactorTitular = new JLabel(titular.getFactorRh());
			labelFactorTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelFactorTitular = new GridBagConstraints();
			gbc_labelFactorTitular.insets = new Insets(0, 0, 5, 5);
			gbc_labelFactorTitular.gridx = 4;
			gbc_labelFactorTitular.gridy = 6;
			add(labelFactorTitular, gbc_labelFactorTitular);
			
			JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
			gbc_lblDireccin.anchor = GridBagConstraints.EAST;
			gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDireccin.gridx = 1;
			gbc_lblDireccin.gridy = 7;
			add(lblDireccin, gbc_lblDireccin);
			lblDireccin.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
				
			modeloTablaClase =(new DefaultTableModel(
			                new Object[][] {
			                },
			                new String[] {
			                       "Objeto","Clase"
			                }
			        ) {
			                /**
			                 * 
			                 */
			                private static final long serialVersionUID = 1L;
			                boolean[] columnEditables = new boolean[] {
			                        false,false
			                };
			                public boolean isCellEditable(int row, int column) {
			                        return columnEditables[column];
			                }
			        });
			        
			SessionFactory factory= FabricaSessionFactory.getFactory();
	        Session session = factory.getCurrentSession(); 
	        session.beginTransaction();
	        session.refresh(titular);
			Hibernate.initialize(titular.getClasesSolicitadas());
			session.getTransaction().commit();
			        
			for (Clase clase :titular.getClasesSolicitadas() ) {
						
				modeloTablaClase.addRow(new Object[]{clase,clase.getIdClase()});
			}
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 1;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 2;
			gbc_scrollPane.gridy = 10;
			add(scrollPane, gbc_scrollPane);
			
			
			tablaClase = new JTable();
			scrollPane.setViewportView(tablaClase);
			tablaClase.setModel(modeloTablaClase);
			
			tablaClase.getColumnModel().getColumn(0).setMaxWidth(0);
		    tablaClase.getColumnModel().getColumn(0).setMinWidth(0);
		    tablaClase.getColumnModel().getColumn(0).setPreferredWidth(0);
			
		    
		    
		    JLabel labelDirecTitular = new JLabel(titular.getDomicilio());
			labelDirecTitular.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_labelDirecTitutlar = new GridBagConstraints();
			gbc_labelDirecTitutlar.insets = new Insets(0, 0, 5, 5);
			gbc_labelDirecTitutlar.gridx = 2;
			gbc_labelDirecTitutlar.gridy = 7;
			add(labelDirecTitular, gbc_labelDirecTitutlar);
			
			JLabel lblClasesSolicitadas = new JLabel("Clases solicitadas:");
			lblClasesSolicitadas.setForeground(new Color(0, 0, 153));
			GridBagConstraints gbc_lblClasesSolicitadas = new GridBagConstraints();
			gbc_lblClasesSolicitadas.anchor = GridBagConstraints.EAST;
			gbc_lblClasesSolicitadas.fill = GridBagConstraints.VERTICAL;
			gbc_lblClasesSolicitadas.insets = new Insets(0, 0, 5, 5);
			gbc_lblClasesSolicitadas.gridx = 1;
			gbc_lblClasesSolicitadas.gridy = 9;
			add(lblClasesSolicitadas, gbc_lblClasesSolicitadas);
			lblClasesSolicitadas.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			
			
			
			JLabel lblObservacin = new JLabel("Observaci\u00F3n:");
			lblObservacin.setForeground(new Color(0, 0, 153));
			lblObservacin.setFont(new Font("Lato Medium", Font.PLAIN, 14));
			GridBagConstraints gbc_lblObservacin = new GridBagConstraints();
			gbc_lblObservacin.anchor = GridBagConstraints.EAST;
			gbc_lblObservacin.insets = new Insets(0, 0, 5, 5);
			gbc_lblObservacin.gridx = 1;
			gbc_lblObservacin.gridy = 12;
			add(lblObservacin, gbc_lblObservacin);
					
		
						
						editorPaneObserv = new JEditorPane();
						GridBagConstraints gbc_editorPaneObserv = new GridBagConstraints();
						gbc_editorPaneObserv.gridwidth = 2;
						gbc_editorPaneObserv.gridheight = 2;
						gbc_editorPaneObserv.insets = new Insets(0, 0, 5, 5);
						gbc_editorPaneObserv.fill = GridBagConstraints.BOTH;
						gbc_editorPaneObserv.gridx = 2;
						gbc_editorPaneObserv.gridy = 12;
						add(editorPaneObserv, gbc_editorPaneObserv);
						editorPaneObserv.addKeyListener(new KeyListener(){
				            
				            public void keyTyped(KeyEvent e)
				             
				            {

				             if (editorPaneObserv.getText().length()== 200)
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
						
						JLabel lblCategora = new JLabel("Categor\u00EDa:");
						lblCategora.setForeground(new Color(0, 0, 153));
						lblCategora.setFont(new Font("Lato Medium", Font.PLAIN, 14));
						GridBagConstraints gbc_lblCategora = new GridBagConstraints();
						gbc_lblCategora.anchor = GridBagConstraints.EAST;
						gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
						gbc_lblCategora.gridx = 1;
						gbc_lblCategora.gridy = 15;
						add(lblCategora, gbc_lblCategora);
						
						comboCategoria = new JComboBox();
						comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"", "nuevo", "renovacion"}));
						GridBagConstraints gbc_comboCategoria = new GridBagConstraints();
						gbc_comboCategoria.insets = new Insets(0, 0, 5, 5);
						gbc_comboCategoria.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboCategoria.gridx = 2;
						gbc_comboCategoria.gridy = 15;
						add(comboCategoria, gbc_comboCategoria);
			
						JButton btnVisualizarLicencia = new JButton("Visualizar licencia");
						btnVisualizarLicencia.setForeground(new Color(0, 0, 51));
						btnVisualizarLicencia.setFont(new Font("Lato Black", Font.PLAIN, 13));
						btnVisualizarLicencia.setBackground(new Color(240, 255, 255));
						GridBagConstraints gbc_btnVisualizarLicencia = new GridBagConstraints();
						gbc_btnVisualizarLicencia.anchor = GridBagConstraints.SOUTH;
						gbc_btnVisualizarLicencia.insets = new Insets(0, 0, 5, 5);
						gbc_btnVisualizarLicencia.gridx = 4;
						gbc_btnVisualizarLicencia.gridy = 17;
						add(btnVisualizarLicencia, gbc_btnVisualizarLicencia);
						btnVisualizarLicencia.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										btnVisualizarLicencia(pantallaPrincipal,titular);
										// TODO Auto-generated method stub
										
									}

									

									
								});
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(new Color(0, 0, 51));
			btnCancelar.setFont(new Font("Lato Black", Font.PLAIN, 13));
			btnCancelar.setBackground(new Color(240, 255, 255));
			GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
			gbc_btnCancelar.anchor = GridBagConstraints.SOUTHWEST;
			gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
			gbc_btnCancelar.gridx = 7;
			gbc_btnCancelar.gridy = 17;
			add(btnCancelar, gbc_btnCancelar);
			btnCancelar.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									btnCancelarAction(pantallaPrincipal);
									// TODO Auto-generated method stub
									
								}

								


								

								
							});
			
		
		
	}

	private void btnVisualizarLicencia(JFrame pantallaPrincipal, Titular titular) {
		// TODO Auto-generated method stub
		try{
			
			if(tablaClase.getSelectedRowCount()!=1 )
			 throw new ExcepcionTabla("Seleccionar una fila");
				
			
			Clase claseSeleccionada= (Clase) tablaClase.getValueAt(tablaClase.getSelectedRow(),0);
			 
			if(comboCategoria.getSelectedIndex()==0){
				throw new ExcepcionNull("Completar categoría");
			}
			EmitirLicencia licencia = new EmitirLicencia();
			Licenciavigente licenciaVigente = licencia.crearLicencia(titular, editorPaneObserv.getText(), (String) comboCategoria.getSelectedItem(), claseSeleccionada);
			
			PanelVisualizarLicencia panelVisualizarLicencia = new PanelVisualizarLicencia(licenciaVigente, pantallaPrincipal);
			//this.setVisible(false);
			
			pantallaPrincipal.setContentPane(panelVisualizarLicencia);
			
		}
			catch(ExcepcionTabla e1){
				JOptionPane.showMessageDialog(this,e1.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(ExcepcionClaseLicencia e2){
				JOptionPane.showMessageDialog(this,e2.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			catch( ExcepcionNull e3){
				
				JOptionPane.showMessageDialog(this,e3.getMensaje(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		
		
		
	}



	
	private void btnCancelarAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		pantallaPrincipal.setContentPane(new PanelMenu(pantallaPrincipal));
	}
	
}

