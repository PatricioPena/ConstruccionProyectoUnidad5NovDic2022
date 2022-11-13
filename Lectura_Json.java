import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Lectura_Json {

    public static void main(String[] args) {
        
        JSONParser parser = new JSONParser();
        
        try {
            
            Object obj = parser.parse(new FileReader("listado.Json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);
            
            JSONArray array = (JSONArray) jsonObject.get("employee");
            System.out.println("");
            
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                
                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("ID: " + jsonObject1.get("id"));
                System.out.println("Nombre: " + jsonObject1.get("firstname"));
                System.out.println("Telefono: " + jsonObject1.get("lastname"));
                System.out.println("Email: " + jsonObject1.get("photo"));
                
                System.out.println("");
            }
            
        } catch(FileNotFoundException e) { }
        catch(IOException e) { }
        catch(ParseException e) { }
        
    }
    
}
