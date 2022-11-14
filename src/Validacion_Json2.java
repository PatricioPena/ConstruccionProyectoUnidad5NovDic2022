import java.io.IOException;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;

public class Validacion_Json2 {
  public static void main(String[] args) {
    try {
      SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
      // Load the schema.
      Schema schema = schemaStore.loadSchema(Validacion_Json2.class.getResource("/schema.json"));

      Validator validator = new Validator();

      // Will not throw an exception.
      validator.validate(schema, Validacion_Json2.class.getResourceAsStream("/listado.json"));

    } catch (SchemaException | IOException e) {
      e.printStackTrace();
    }
  }
}