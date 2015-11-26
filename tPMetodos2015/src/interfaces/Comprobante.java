package interfaces;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class Comprobante implements Printable{

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JButton btnImprimir;
	private JLabel lblFechasistema;
	private Calendar fecha;

	public Comprobante() {
		initialize();
	}
	
	public void imprimirComprobante() {
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
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 264, 256);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblComprobanteDePago = new JLabel("COMPROBANTE DE PAGO");
		lblComprobanteDePago.setBounds(56, 11, 163, 14);
		panel.add(lblComprobanteDePago);
		
		JLabel lblMunicipalidad = new JLabel("Municipalidad de Santa Fe");
		lblMunicipalidad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMunicipalidad.setBounds(10, 48, 244, 14);
		panel.add(lblMunicipalidad);
		
		JLabel lblCuit = new JLabel("CUIT:  30-99903338-1");
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCuit.setBounds(114, 73, 129, 14);
		panel.add(lblCuit);
		
		JLabel lblTipoLicencia = new JLabel("Licencia - XX");
		lblTipoLicencia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTipoLicencia.setBounds(10, 150, 129, 14);
		panel.add(lblTipoLicencia);
		
		JLabel lblGastosAdministrativos = new JLabel("Gastos Administrativos");
		lblGastosAdministrativos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGastosAdministrativos.setBounds(10, 179, 129, 14);
		panel.add(lblGastosAdministrativos);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTotalAPagar.setBounds(10, 217, 129, 14);
		panel.add(lblTotalAPagar);
		
		JLabel lblPrecioLicencia = new JLabel("$XX");
		lblPrecioLicencia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPrecioLicencia.setBounds(185, 150, 69, 14);
		panel.add(lblPrecioLicencia);
		
		JLabel labelGastos = new JLabel("$XX");
		labelGastos.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelGastos.setBounds(185, 179, 61, 14);
		panel.add(labelGastos);
		
		JLabel labelTotal = new JLabel("$XX");
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelTotal.setBounds(182, 217, 61, 14);
		panel.add(labelTotal);
		
		lblFechasistema = new JLabel(""+fecha.getInstance().get(Calendar.YEAR)+"/"+fecha.getInstance().get(Calendar.MONTH)+"/"+fecha.getInstance().get(Calendar.DATE)+" "+fecha.getInstance().get(Calendar.HOUR_OF_DAY)+":"+fecha.getInstance().get(Calendar.MINUTE)+":"+fecha.getInstance().get(Calendar.SECOND)+"");
		lblFechasistema.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechasistema.setBounds(10, 101, 209, 14);
		panel.add(lblFechasistema);
				
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimirComprobante();
			}
		});
		btnImprimir.setBounds(104, 278, 89, 23);
		frame.getContentPane().add(btnImprimir);
		
		table = new JTable();
		table.setBounds(272, 289, -261, 99);
		frame.getContentPane().add(table);
		
		
	}
}
