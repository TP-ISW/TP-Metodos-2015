package logica;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;

import javax.swing.*;

import clasesDeTablas.Comprobante;
import clasesDeTablas.Licenciavigente;
import excepciones.ExcepcionClaseLicencia;
import persistencia.DAOComprobante;


public class ImprimirLicencia implements Printable{

	private JFrame frame;
	private JPanel panelComprobante;
	private JPanel panelLicencia;
	private JLabel lblFechasistema;
	private Licenciavigente licencia;
	private int idImpresion;
	
	public void imprimirLicencia(Licenciavigente licenciaVigente, JPanel  licenciaAImprimir) throws ExcepcionClaseLicencia{
		
		DAOComprobante daoComprobante = new DAOComprobante();
		licencia = licenciaVigente;
		panelLicencia = licenciaAImprimir;
		
		//se instancia un comprobante y se setean valores ficticios
		Comprobante comprobante = new Comprobante();
		comprobante.setCuit("99999999999");
		comprobante.setFechaEmision(Calendar.getInstance());
		comprobante.setLicenciaExpirada(null);
		comprobante.setMonto((float) 99.0);
		// Se manda a imprimir con el id en 0, lo que hace que se imprima la licencia.
		idImpresion = 0;
		imprimir();
		
		// Se dibuja un comprobante y se imprime con el id en 1, que hace que se imprima el comprobante.
		idImpresion++;
		crearComprobante(comprobante);
		imprimir();
				
		//se guarda el comprobante en la BD
		daoComprobante.save(comprobante);
		
		//Se envía el comprobante y la licencta a la lógica de emitir licencia, para que esta lo persista en la BD.
		EmitirLicencia emitir = new EmitirLicencia();
		emitir.guardarLicencia(licenciaVigente, comprobante);
		
	}
	// Abrimos el diálogo con la impresora.
	public void imprimir() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        try {
            printerJob.printDialog();
            printerJob.print();
        } catch (PrinterException ex) {
            System.out.println("Error:" + ex);
        }
    }
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            if(idImpresion==0) panelLicencia.printAll(graphics);
            else panelComprobante.printAll(graphics);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
	
	
	
	private void crearComprobante(Comprobante comprobante){
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelComprobante = new JPanel();
		panelComprobante.setBounds(10, 11, 264, 256);
		frame.getContentPane().add(panelComprobante);
		panelComprobante.setLayout(null);
		
		JLabel lblComprobanteDePago = new JLabel("COMPROBANTE DE PAGO");
		lblComprobanteDePago.setBounds(56, 11, 163, 14);
		panelComprobante.add(lblComprobanteDePago);
		
		JLabel lblMunicipalidad = new JLabel("Municipalidad de Santa Fe");
		lblMunicipalidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMunicipalidad.setBounds(10, 48, 244, 14);
		panelComprobante.add(lblMunicipalidad);
		
		JLabel lblCuit = new JLabel(""+comprobante.getCuit()+"");
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCuit.setBounds(114, 73, 129, 14);
		panelComprobante.add(lblCuit);
		
		JLabel lblTipoLicencia = new JLabel("Licencia - "+licencia.getClase().getIdClase()+"");
		lblTipoLicencia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTipoLicencia.setBounds(10, 150, 129, 14);
		panelComprobante.add(lblTipoLicencia);
		
		JLabel lblGastosAdministrativos = new JLabel("Gastos Administrativos");
		lblGastosAdministrativos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGastosAdministrativos.setBounds(10, 179, 129, 14);
		panelComprobante.add(lblGastosAdministrativos);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTotalAPagar.setBounds(10, 217, 129, 14);
		panelComprobante.add(lblTotalAPagar);
		
		JLabel lblPrecioLicencia = new JLabel("$"+comprobante.getMonto()+"");
		lblPrecioLicencia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPrecioLicencia.setBounds(185, 150, 69, 14);
		panelComprobante.add(lblPrecioLicencia);
		
		JLabel labelGastos = new JLabel("$8");
		labelGastos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelGastos.setBounds(185, 179, 61, 14);
		panelComprobante.add(labelGastos);
		
		JLabel labelTotal = new JLabel("$XX");
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelTotal.setBounds(182, 217, 61, 14);
		panelComprobante.add(labelTotal);
		
		Calendar fecha = comprobante.getFechaEmision();
		
		lblFechasistema = new JLabel(""+fecha.getInstance().get(Calendar.YEAR)+"/"+fecha.getInstance().get(Calendar.MONTH)+"/"+fecha.getInstance().get(Calendar.DATE)+" "+fecha.getInstance().get(Calendar.HOUR_OF_DAY)+":"+fecha.getInstance().get(Calendar.MINUTE)+":"+fecha.getInstance().get(Calendar.SECOND)+"");
		lblFechasistema.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechasistema.setBounds(10, 101, 209, 14);
		panelComprobante.add(lblFechasistema);
	}
}