/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author patri
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       pantalla p = new pantalla();
       Lectura_Json l = new Lectura_Json();
       p.getjTextArea1().setText(l.leerJson());
       p.setVisible(true);
       p.setLocationRelativeTo(null);
    }
    
}
