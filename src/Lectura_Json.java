import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class Lectura_Json {

    public static void main(String[] args) {

        try {
           
            String content = Files.readString(Paths.get("listado.json"));
            JSONObject obj = new JSONObject(content);
            JSONObject jsonObject = obj.getJSONObject("employees");
            JSONArray jsonPersonData = jsonObject.getJSONArray("employee");
            
            for (int i = 0; i < jsonPersonData.length(); i++) {

                JSONObject item = jsonPersonData.getJSONObject(i);
                String id = item.getString("id");
                String name = item.getString("firstName");
                String lastname = item.getString("lastName");
                String photo = item.getString("photo");

                System.out.println("ID: " + id);
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + lastname);
                System.out.println("Foto: " + photo);
                System.out.println(" ");
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } 
    }
}
