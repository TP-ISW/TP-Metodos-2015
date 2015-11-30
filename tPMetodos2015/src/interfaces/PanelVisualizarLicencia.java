package interfaces;

import java.awt.*;
import java.awt.event.*;
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

	private JPanel licenciaCompleta = new JPanel();
	private JButton btnImprimir = new JButton("Imprimir");
	ImprimirLicencia licenciaAImprimir = new ImprimirLicencia();
	private Licenciavigente licencia;
	private JLabel labelFechaNac;

	public PanelVisualizarLicencia(Licenciavigente licVig) {
		licencia = licVig;
		initialize();
	}
		
	private void initialize() {
		
		setBounds(100, 50, 500, 520);
		
		setLayout(null);
		licenciaCompleta.setBounds(30, 11, 460, 471);
		add(licenciaCompleta);
		licenciaCompleta.setLayout(null);
		
		JLabel lblLicenciaN = new JLabel("Licencia N\u00BA:");
		lblLicenciaN.setBounds(165, 48, 118, 14);
		lblLicenciaN.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblLicenciaN);
		
		JLabel lblNroLic = new JLabel(""+licencia.getIdlicencia());
		lblNroLic.setBounds(293, 48, 145, 14);
		lblNroLic.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblNroLic);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(165, 73, 118, 14);
		lblNombres.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(165, 98, 118, 14);
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(165, 123, 118, 14);
		lblDomicilio.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblDomicilio);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setBounds(165, 148, 118, 14);
		lblFechaDeVencimiento.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblFechaDeVencimiento);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(165, 173, 118, 14);
		lblObservaciones.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblObservaciones);
		
		JLabel lblLicenciaDeConducir = new JLabel("LICENCIA DE CONDUCIR");
		lblLicenciaDeConducir.setBounds(165, 11, 273, 14);
		lblLicenciaDeConducir.setFont(new Font("Tahoma", Font.BOLD, 12));
		licenciaCompleta.add(lblLicenciaDeConducir);
		
		JLabel lblApellido_1 = new JLabel(""+licencia.getTitular().getApellido());
		lblApellido_1.setBounds(293, 98, 145, 14);
		lblApellido_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblApellido_1);
		
		JLabel lblNombres_1 = new JLabel(""+licencia.getTitular().getNombre());
		lblNombres_1.setBounds(293, 73, 145, 14);
		lblNombres_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblNombres_1);
		
		JLabel lblDomicilio_1 = new JLabel(""+licencia.getTitular().getDomicilio());
		lblDomicilio_1.setBounds(293, 123, 145, 14);
		lblDomicilio_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblDomicilio_1);
		
		Calendar fechaVencimiento = licencia.getFechaVencimiento();
		
		JLabel lblFecha = new JLabel(""+fechaVencimiento.getInstance().get(Calendar.YEAR)+"/"+fechaVencimiento.getInstance().get(Calendar.MONTH)+"/"+fechaVencimiento.getInstance().get(Calendar.DATE)+" ");
		lblFecha.setBounds(293, 148, 145, 14);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblFecha);
		
		JLabel lblObservaciones_1 = new JLabel(""+licencia.getObservaciones());
		lblObservaciones_1.setBounds(293, 173, 157, 14);
		lblObservaciones_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		licenciaCompleta.add(lblObservaciones_1);
		
		JPanel foto = new JPanel();
		foto.setBounds(32, 52, 110, 110);
		licenciaCompleta.add(foto);
		btnImprimir.setBounds(419, 493, 71, 23);
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					licenciaAImprimir.imprimirLicencia(licencia, licenciaCompleta);
				} catch (ExcepcionClaseLicencia e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(btnImprimir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 493, 63, 23);
		add(btnVolver);
		
		Calendar fechaNacimiento = Calendar.getInstance();
		JLabel lblFechaDeNacimiento = new JLabel(""+fechaNacimiento.getInstance().get(Calendar.YEAR)+"/"+fechaNacimiento.getInstance().get(Calendar.MONTH)+"/"+fechaNacimiento.getInstance().get(Calendar.DATE)+" ");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechaDeNacimiento.setBounds(165, 254, 128, 14);
		licenciaCompleta.add(lblFechaDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSexo.setBounds(237, 254, 54, 14);
		licenciaCompleta.add(lblSexo);
		
		JLabel lblFechaDeOtorgamiento = new JLabel("Fecha de Otorgamiento:");
		lblFechaDeOtorgamiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechaDeOtorgamiento.setBounds(32, 379, 128, 14);
		licenciaCompleta.add(lblFechaDeOtorgamiento);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCategora.setBounds(32, 304, 128, 14);
		licenciaCompleta.add(lblCategora);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGrupo.setBounds(32, 329, 54, 14);
		licenciaCompleta.add(lblGrupo);
		
		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFactor.setBounds(165, 329, 46, 14);
		licenciaCompleta.add(lblFactor);
		
		JLabel lblDonante = new JLabel("Donante:");
		lblDonante.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDonante.setBounds(32, 354, 128, 14);
		licenciaCompleta.add(lblDonante);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDocumento.setBounds(32, 279, 94, 14);
		licenciaCompleta.add(lblDocumento);
		
		labelFechaNac = new JLabel("Fecha de Nacimiento:");
		labelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelFechaNac.setBounds(32, 254, 104, 14);
		licenciaCompleta.add(labelFechaNac);
		
		JLabel labelNroDoc = new JLabel(""+licencia.getTitular().getId().getTipoDoc()+" "+licencia.getTitular().getId().getNroDoc());
		labelNroDoc.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelNroDoc.setBounds(165, 279, 104, 14);
		licenciaCompleta.add(labelNroDoc);
		
		JLabel lblCategoria = new JLabel(licencia.getCategoria());
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCategoria.setBounds(165, 304, 104, 14);
		licenciaCompleta.add(lblCategoria);
		
		JLabel lblA = new JLabel(licencia.getTitular().getGrupoSanguineo());
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblA.setBounds(96, 329, 33, 14);
		licenciaCompleta.add(lblA);
		
		JLabel labelSigno = new JLabel(licencia.getTitular().getFactorRh());
		labelSigno.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelSigno.setBounds(237, 329, 46, 14);
		licenciaCompleta.add(labelSigno);
		
		JLabel lblM = new JLabel(licencia.getTitular().getSexo());
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblM.setBounds(293, 254, 46, 14);
		licenciaCompleta.add(lblM);
		
		JLabel lblSi = new JLabel("No");
		if(licencia.getTitular().getDonante()==true){
			lblSi.setText("Si");
		}
		lblSi.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSi.setBounds(96, 354, 46, 14);
		licenciaCompleta.add(lblSi);
		
		Calendar fechaOtorgamiento = Calendar.getInstance();
		JLabel label_1 = new JLabel(""+fechaOtorgamiento.getInstance().get(Calendar.YEAR)+"/"+fechaOtorgamiento.getInstance().get(Calendar.MONTH)+"/"+fechaOtorgamiento.getInstance().get(Calendar.DATE)+" ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(165, 379, 104, 14);
		licenciaCompleta.add(label_1);
	}
}