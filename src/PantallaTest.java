import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;

public class PantallaTest extends JFrame {
    public PantallaTest() {

        super("Lectura del Json");
        try {
            // creamos el modelo de Tabla
            DefaultTableModel dtm = new DefaultTableModel() {
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
            };
            
            // se crea la Tabla con el modelo DefaultTableModel
            final JTable table = new JTable(dtm);

            // insertamos las columnas
            dtm.addColumn("ID");
            dtm.addColumn("First Name");
            dtm.addColumn("Last Name");
            dtm.addColumn("Photo");

            // creamos un objeto para centrar la tabla
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            
            // insertamos el tamaño de las columnas y centramos los datos
            for (int i = 0; i < 3; i++) {
                table.getColumnModel().getColumn(i).setPreferredWidth(50);
                table.getColumnModel().getColumn(i).setResizable(false);
                table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
            }
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setResizable(false);
            // insertamos el tamaño de las row
            table.setRowHeight(150);
            // insertamos el contenido de las columnas
            Lectura_Json lectura = new Lectura_Json();
            lectura.leerJson();
            for (int i = 0; i < lectura.getEmpleados().size(); i++) {
                Empleado empleado = lectura.getEmpleados().get(i);
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(new URL(empleado.getPhoto())));
                Image image = getScaledImage(imageIcon.getImage(), 200, 150);
                imageIcon = new ImageIcon(image);
                Icon icon = (Icon) imageIcon;
                dtm.addRow(new Object[] { empleado.getId(), empleado.getFirtsName(), empleado.getLastName(), icon });

            }

            // se define el tamaño
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));

            // Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(table);

            // Agregamos el JScrollPane al contenedor
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            // manejamos la salida
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        } catch (IOException e) {

        }
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}