package interfaces;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import clasesDeTablas.Licenciavigente;
import excepciones.ExcepcionClaseLicencia;
import logica.ImprimirLicencia;


public class PanelVisualizarLicencia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 882180666384926462L;

	private JPanel licenciaCompleta;
	private JButton btnImprimir = new JButton("Imprimir");
	ImprimirLicencia licenciaAImprimir = new ImprimirLicencia();
	private Licenciavigente licencia;
	private JLabel labelFechaNac;
	private JLabel lblSi;

	public PanelVisualizarLicencia(Licenciavigente licVig, JFrame pantallaPrincipal, PanelTitularSeleccionado panelTitularSeleccionado) {
		try{
		licencia = licVig;
		initialize(pantallaPrincipal, panelTitularSeleccionado);
		}
		catch(MalformedURLException e1){
			System.out.println("Error foto persona");
		}
	}
		
	private void initialize(JFrame pantallaPrincipal, PanelTitularSeleccionado panelTitularSeleccionado) throws MalformedURLException {
		
		setBounds(100, 50, 500, 520);
		
		setLayout(null);
		licenciaCompleta= new JPanel();
		licenciaCompleta.setBackground(Color.WHITE);
		licenciaCompleta.setBorder(new LineBorder(new Color(0, 0, 0)));
		licenciaCompleta.setBounds(30, 11, 460, 471);
		add(licenciaCompleta);
		licenciaCompleta.setLayout(null);
		
		JPanel panelLicenciaFrente = new JPanel();
		panelLicenciaFrente.setBackground(new Color(204, 204, 255));
		panelLicenciaFrente.setBounds(32, 22, 403, 194);
		licenciaCompleta.add(panelLicenciaFrente);
		panelLicenciaFrente.setLayout(null);
		
		btnImprimir.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnImprimir.setForeground(new Color(0, 0, 51));
		btnImprimir.setBounds(369, 493, 121, 23);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					licenciaAImprimir.imprimirLicencia(licencia, licenciaCompleta);
					btnHomeAction(pantallaPrincipal);
				} catch (ExcepcionClaseLicencia e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(btnImprimir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Lato Black", Font.PLAIN, 13));
		btnVolver.setForeground(new Color(0, 0, 51));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVolverAction(pantallaPrincipal,panelTitularSeleccionado);
			}

			
		});
		btnVolver.setBounds(30, 493, 118, 23);
		add(btnVolver);
		if(licencia.getTitular().getDonante()==true){
			lblSi= new JLabel("Si");
		}
		
		JLabel lblLicenciaN = new JLabel("Licencia N\u00BA:");
		lblLicenciaN.setBounds(156, 46, 50, 12);
		panelLicenciaFrente.add(lblLicenciaN);
		lblLicenciaN.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblLicenciaDeConducir = new JLabel("LICENCIA DE CONDUCIR");
		lblLicenciaDeConducir.setBounds(156, 5, 145, 15);
		panelLicenciaFrente.add(lblLicenciaDeConducir);
		lblLicenciaDeConducir.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(156, 58, 74, 14);
		panelLicenciaFrente.add(lblNombres);
		lblNombres.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(156, 76, 67, 14);
		panelLicenciaFrente.add(lblApellido);
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(156, 96, 50, 14);
		panelLicenciaFrente.add(lblDomicilio);
		lblDomicilio.setFont(new Font("Dialog", Font.PLAIN, 9));
				
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setBounds(156, 121, 118, 14);
		panelLicenciaFrente.add(lblFechaDeVencimiento);
		lblFechaDeVencimiento.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(156, 146, 118, 14);
		panelLicenciaFrente.add(lblObservaciones);
		lblObservaciones.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblObservaciones_1 = new JLabel(""+licencia.getObservaciones());
		lblObservaciones_1.setBounds(258, 146, 135, 14);
		panelLicenciaFrente.add(lblObservaciones_1);
		lblObservaciones_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		File file = new File(licencia.getTitular().getFoto());
		ImageIcon iconoFotoPersona=new ImageIcon(file.toURL()); 
		Image imagenFotoPersona= iconoFotoPersona.getImage();
		ImageIcon iconoFotoPersonaEscalado = new ImageIcon (imagenFotoPersona.getScaledInstance(70,70,Image.SCALE_SMOOTH)); 
		JLabel lblFoto = new JLabel(iconoFotoPersonaEscalado);
		lblFoto.setBounds(23, 26, 110, 109);
		panelLicenciaFrente.add(lblFoto);
		
		JLabel lblNroLic = new JLabel(""+licencia.getIdlicencia());
		lblNroLic.setBounds(258, 44, 23, 14);
		panelLicenciaFrente.add(lblNroLic);
		lblNroLic.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblNombres_1 = new JLabel(""+licencia.getTitular().getNombre());
		lblNombres_1.setBounds(262, 59, 131, 12);
		panelLicenciaFrente.add(lblNombres_1);
		lblNombres_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblDomicilio_1 = new JLabel(""+licencia.getTitular().getDomicilio());
		lblDomicilio_1.setBounds(258, 97, 135, 12);
		panelLicenciaFrente.add(lblDomicilio_1);
		lblDomicilio_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		
		Calendar fechaVencimiento = licencia.getFechaVencimiento();
		int mesVencimiento = fechaVencimiento.get(Calendar.MONTH)+1;
		JLabel lblFecha = new JLabel(""+fechaVencimiento.get(Calendar.DATE)+"/"+mesVencimiento+"/"+fechaVencimiento.get(Calendar.YEAR)+" ");
		lblFecha.setBounds(262, 121, 118, 14);
		panelLicenciaFrente.add(lblFecha);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JLabel lblApellido_1 = new JLabel(""+licencia.getTitular().getApellido());
		lblApellido_1.setBounds(258, 76, 135, 14);
		panelLicenciaFrente.add(lblApellido_1);
		lblApellido_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(32, 245, 403, 182);
		licenciaCompleta.add(panel);
		panel.setLayout(null);
		
		labelFechaNac = new JLabel("Fecha de Nacimiento:");
		labelFechaNac.setBounds(10, 24, 90, 11);
		panel.add(labelFechaNac);
		labelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(10, 46, 94, 14);
		panel.add(lblDocumento);
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(10, 71, 46, 14);
		panel.add(lblCategora);
		lblCategora.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(10, 96, 54, 14);
		panel.add(lblGrupo);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblDonante = new JLabel("Donante:");
		lblDonante.setBounds(10, 121, 46, 14);
		panel.add(lblDonante);
		lblDonante.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblSi = new JLabel("No");
		lblSi.setBounds(68, 121, 46, 14);
		panel.add(lblSi);
		lblSi.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblFechaDeOtorgamiento = new JLabel("Fecha de Otorgamiento:");
		lblFechaDeOtorgamiento.setBounds(10, 146, 128, 14);
		panel.add(lblFechaDeOtorgamiento);
		lblFechaDeOtorgamiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel labelSigno = new JLabel(licencia.getTitular().getFactorRh());
		labelSigno.setBounds(232, 96, 90, 14);
		panel.add(labelSigno);
		labelSigno.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblA = new JLabel(licencia.getTitular().getGrupoSanguineo());
		lblA.setBounds(54, 96, 128, 14);
		panel.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel labelNroDoc = new JLabel(""+licencia.getTitular().getId().getTipoDoc()+" "+licencia.getTitular().getId().getNroDoc());
		labelNroDoc.setBounds(68, 46, 152, 14);
		panel.add(labelNroDoc);
		labelNroDoc.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblM = new JLabel(licencia.getTitular().getSexo());
		lblM.setBounds(222, 22, 54, 14);
		panel.add(lblM);
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 9));
		

		Calendar fechaNacimiento = licencia.getTitular().getFechaNacimiento();
		int mesNacimiento = fechaNacimiento.get(Calendar.MONTH)+1;
		JLabel lblFechaDeNacimiento = new JLabel(""+fechaNacimiento.get(Calendar.DATE)+"/"+mesNacimiento+"/"+fechaNacimiento.get(Calendar.YEAR)+" ");
		lblFechaDeNacimiento.setBounds(110, 22, 72, 14);
		panel.add(lblFechaDeNacimiento);
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblCategoria = new JLabel(licencia.getCategoria());
		lblCategoria.setBounds(68, 71, 280, 14);
		panel.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		Calendar fechaOtorgamiento = Calendar.getInstance();
		int mesOtorgamiento = fechaOtorgamiento.getInstance().get(Calendar.MONTH)+1;
		JLabel label_1 = new JLabel(""+fechaOtorgamiento.getInstance().get(Calendar.DATE)+"/"+mesOtorgamiento+"/"+fechaOtorgamiento.getInstance().get(Calendar.YEAR)+" ");
		label_1.setBounds(116, 146, 104, 14);
		panel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(192, 22, 54, 14);
		panel.add(lblSexo);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setBounds(192, 96, 46, 14);
		panel.add(lblFactor);
		lblFactor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
	}
	private void btnHomeAction(JFrame pantallaPrincipal) {
		// TODO Auto-generated method stub
		setVisible(false);
		pantallaPrincipal.setContentPane(new PanelMenu(pantallaPrincipal));
	}
	private void btnVolverAction(JFrame pantallaPrincipal,PanelTitularSeleccionado panelTitularSeleccionado) {
				// TODO Auto-generated method stub
		
		setVisible(false);
		pantallaPrincipal.setContentPane(panelTitularSeleccionado);
	}
}