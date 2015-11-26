package logica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;

import clasesDeTablas.Comprobante;
import persistencia.DAOComprobante;

public class ImprimirLicencia {

	static void imprimirLicencia(){
		
		DAOComprobante daoComprobante = new DAOComprobante();
		
		
		//se instancia un comprobante y se setean valores ficticios
		Comprobante comprobante = new Comprobante();
		comprobante.setCuit("XX-XXXXXXXX-X");
		comprobante.setFechaEmision(Calendar.getInstance());
		comprobante.setLicenciaExpirada(null);
		comprobante.setMonto((float) 99.0);
		
		imprimirComprobante(comprobante);

				
		//se guarda el comprobante en la BD
		daoComprobante.save(comprobante);
		
	}
	public void imprimirComprobante(comprobante) {
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
            panel.printAll(graphics);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}
