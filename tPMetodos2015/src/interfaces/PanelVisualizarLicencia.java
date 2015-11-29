package interfaces;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import clasesDeTablas.Licenciavigente;
import excepciones.ExcepcionClaseLicencia;
import logica.ImprimirLicencia;


public class PanelVisualizarLicencia extends JPanel{

	private JFrame frame = new JFrame();
	private JPanel licenciaCompleta = new JPanel();
	private JPanel licenciaFrente = new JPanel();
	private JPanel licenciaAtras = new JPanel();
	private JButton btnImprimir = new JButton("Imprimir");
	ImprimirLicencia licenciaAImprimir = new ImprimirLicencia();
	private Licenciavigente licencia;

	public PanelVisualizarLicencia(Licenciavigente licVig) {
		licencia = licVig;
		initialize();
	}
		
	private void initialize() {
		
		frame.setBounds(100, 50, 500, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		licenciaCompleta.setBounds(10, 11, 464, 506);
		frame.getContentPane().add(licenciaCompleta);
		licenciaCompleta.setLayout(null);
		
		licenciaFrente.setBorder(new LineBorder(new Color(0, 0, 0)));
		licenciaFrente.setBounds(10, 11, 460, 219);
		frame.getContentPane().add(licenciaFrente);
		licenciaFrente.setLayout(null);
		licenciaCompleta.add(licenciaFrente);
		
		JLabel lblLicenciaN = new JLabel("Licencia N\u00BA:");
		lblLicenciaN.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblLicenciaN.setBounds(165, 48, 118, 14);
		licenciaFrente.add(lblLicenciaN);
		
		JLabel lblNroLic = new JLabel(""+licencia.getIdlicencia());
		lblNroLic.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNroLic.setBounds(293, 48, 145, 14);
		licenciaFrente.add(lblNroLic);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNombres.setBounds(165, 98, 118, 14);
		licenciaFrente.add(lblNombres);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblApellido.setBounds(165, 73, 118, 14);
		licenciaFrente.add(lblApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDomicilio.setBounds(165, 123, 118, 14);
		licenciaFrente.add(lblDomicilio);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblFechaDeVencimiento.setBounds(165, 148, 118, 14);
		licenciaFrente.add(lblFechaDeVencimiento);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblObservaciones.setBounds(165, 173, 118, 14);
		licenciaFrente.add(lblObservaciones);
		
		JLabel lblLicenciaDeConducir = new JLabel("LICENCIA DE CONDUCIR");
		lblLicenciaDeConducir.setBounds(165, 11, 273, 14);
		lblLicenciaDeConducir.setFont(new Font("Tahoma", Font.BOLD, 12));
		licenciaFrente.add(lblLicenciaDeConducir);
		
		JLabel lblApellido_1 = new JLabel(""+licencia.getTitular().getApellido());
		lblApellido_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblApellido_1.setBounds(293, 73, 145, 14);
		licenciaFrente.add(lblApellido_1);
		
		JLabel lblNombres_1 = new JLabel(""+licencia.getTitular().getNombre());
		lblNombres_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNombres_1.setBounds(293, 98, 145, 14);
		licenciaFrente.add(lblNombres_1);
		
		JLabel lblDomicilio_1 = new JLabel(""+licencia.getTitular().getDomicilio());
		lblDomicilio_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDomicilio_1.setBounds(293, 123, 145, 14);
		licenciaFrente.add(lblDomicilio_1);
		
		Calendar fechaVencimiento = licencia.getFechaVencimiento();
		
		JLabel lblFecha = new JLabel(""+fechaVencimiento.getInstance().get(Calendar.YEAR)+"/"+fechaVencimiento.getInstance().get(Calendar.MONTH)+"/"+fechaVencimiento.getInstance().get(Calendar.DATE)+" ");
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblFecha.setBounds(293, 148, 145, 14);
		licenciaFrente.add(lblFecha);
		
		JLabel lblObservaciones_1 = new JLabel(""+licencia.getObservaciones());
		lblObservaciones_1.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblObservaciones_1.setBounds(293, 173, 157, 14);
		licenciaFrente.add(lblObservaciones_1);
		
		JPanel foto = new JPanel();
		foto.setBounds(24, 48, 110, 110);
		licenciaFrente.add(foto);
		
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
		
		btnImprimir.setBounds(388, 487, 89, 23);
		frame.getContentPane().add(btnImprimir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 487, 89, 23);
		frame.getContentPane().add(btnVolver);
		licenciaAtras.setBounds(10, 257, 460, 219);
		frame.getContentPane().add(licenciaAtras);
		
		licenciaAtras.setBorder(new LineBorder(new Color(0, 0, 0)));
		licenciaAtras.setLayout(null);
		licenciaCompleta.add(licenciaAtras);
		
		Calendar fechaNacimiento = Calendar.getInstance();
		JLabel lblFechaDeNacimiento = new JLabel(""+fechaNacimiento.getInstance().get(Calendar.YEAR)+"/"+fechaNacimiento.getInstance().get(Calendar.MONTH)+"/"+fechaNacimiento.getInstance().get(Calendar.DATE)+" ");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechaDeNacimiento.setBounds(34, 28, 128, 14);
		licenciaAtras.add(lblFechaDeNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSexo.setBounds(252, 78, 54, 14);
		licenciaAtras.add(lblSexo);
		
		JLabel lblFechaDeOtorgamiento = new JLabel("Fecha de Otorgamiento:");
		lblFechaDeOtorgamiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechaDeOtorgamiento.setBounds(34, 178, 128, 14);
		licenciaAtras.add(lblFechaDeOtorgamiento);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCategora.setBounds(34, 103, 128, 14);
		licenciaAtras.add(lblCategora);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGrupo.setBounds(34, 128, 54, 14);
		licenciaAtras.add(lblGrupo);
		
		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFactor.setBounds(182, 128, 46, 14);
		licenciaAtras.add(lblFactor);
		
		JLabel lblDonante = new JLabel("Donante:");
		lblDonante.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDonante.setBounds(34, 153, 128, 14);
		licenciaAtras.add(lblDonante);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento:");
		lblLugarDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLugarDeNacimiento.setBounds(34, 53, 128, 14);
		licenciaAtras.add(lblLugarDeNacimiento);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblDocumento.setBounds(34, 78, 94, 14);
		licenciaAtras.add(lblDocumento);
		
		JLabel label = new JLabel(""+licencia.getTitular().getFechaNacimiento());
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label.setBounds(182, 28, 104, 14);
		licenciaAtras.add(label);
		
		JLabel labelNroDoc = new JLabel(""+licencia.getTitular().getId().getTipoDoc()+" "+licencia.getTitular().getId().getNroDoc());
		labelNroDoc.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelNroDoc.setBounds(138, 78, 104, 14);
		licenciaAtras.add(labelNroDoc);
		
		JLabel lblCategoria = new JLabel(licencia.getCategoria());
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCategoria.setBounds(182, 103, 104, 14);
		licenciaAtras.add(lblCategoria);
		
		JLabel lblA = new JLabel(licencia.getTitular().getGrupoSanguineo());
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblA.setBounds(109, 128, 33, 14);
		licenciaAtras.add(lblA);
		
		JLabel labelSigno = new JLabel(licencia.getTitular().getFactorRh());
		labelSigno.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelSigno.setBounds(251, 128, 46, 14);
		licenciaAtras.add(labelSigno);
		
		JLabel lblM = new JLabel(licencia.getTitular().getSexo());
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblM.setBounds(338, 78, 46, 14);
		licenciaAtras.add(lblM);
		
		JLabel lblSi = new JLabel("No");
		if(licencia.getTitular().getDonante()==true){
			lblSi.setText("Si");
		}
		lblSi.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSi.setBounds(182, 153, 46, 14);
		licenciaAtras.add(lblSi);
		
		Calendar fechaOtorgamiento = Calendar.getInstance();
		JLabel label_1 = new JLabel(""+fechaOtorgamiento.getInstance().get(Calendar.YEAR)+"/"+fechaOtorgamiento.getInstance().get(Calendar.MONTH)+"/"+fechaOtorgamiento.getInstance().get(Calendar.DATE)+" ");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(182, 178, 104, 14);
		licenciaAtras.add(label_1);
	}
}