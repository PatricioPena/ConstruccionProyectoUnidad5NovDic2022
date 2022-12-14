import static org.junit.Assert.assertEquals;
import java.io.File;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class Junit_Tests {
    private String path = ("C:\\Users\\aeort\\Documents\\Construccion\\ConstruccionProyectoUnidad5NovDic2022\\src\\listado.json");

    @Test
    public void JSONexists() {   
        File file = new File(path);
        boolean expectedResult = true;
        boolean actualResult = false;
        if (file.exists()){
            actualResult = true;
        }
        assertEquals(expectedResult, actualResult);
    }

    @BeforeEach
    void setup(){
        Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
    }

    @Test
    public void ValidarDatos(){
            Validacion_Json validacionJSON = new Validacion_Json();           
            validacionJSON.ValidarJson();
            boolean expectedResult = false;
            boolean actualResult = validacionJSON.isActive();
            assertEquals(expectedResult, actualResult);
    }

    @Test
    public void validarModificacion(){
            Edicion_Json edicion = new Edicion_Json();           
            edicion.editarEmpleados();
            boolean expectedResult = true;
            boolean actualResult = edicion.isActive();
            assertEquals(expectedResult, actualResult);
    }

    @Test
    public void validarEliminar(){
            Edicion_Json edicion = new Edicion_Json();           
            edicion.eliminarEmpleados();
            boolean expectedResult = false;
            boolean actualResult = edicion.isDeleting();
            assertEquals(expectedResult, actualResult);
    }

    @Test
    public void validarAgregar(){
            Edicion_Json edicion = new Edicion_Json();             
            edicion.agregarEmpleado();
            boolean expectedResult = true;
            boolean actualResult = edicion.isAdding();
            assertEquals(expectedResult, actualResult);
    }

}
