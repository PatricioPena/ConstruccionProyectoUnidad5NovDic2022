import java.io.IOException;

public class Conexion_Json_Pantalla {
    public static void main(String[] args) throws IOException {
       PantallaTest frame = new PantallaTest();
       frame.pack();
       frame.setBounds(0,0,1920,1280);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
}
