import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Lectura_Json {
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public String leerJson() {

        try {
           
            String content = Files.readString(Paths.get("src/listado.json"));
            JSONObject obj = new JSONObject(content);
            JSONObject jsonObject = obj.getJSONObject("employees");
            JSONArray jsonPersonData = jsonObject.getJSONArray("employee");
            StringBuilder st = new StringBuilder();

            for (int i = 0; i < jsonPersonData.length(); i++) {

                JSONObject item = jsonPersonData.getJSONObject(i);
                String id = item.getString("id");
                String name = item.getString("firstName");
                String lastname = item.getString("lastName");
                String photo = item.getString("photo");
                
                Empleado empleado = new Empleado(id, name, lastname, photo);
                empleados.add(empleado);
                
            }

            return st.toString();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } 
        return "";
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    
}
