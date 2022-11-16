import static org.junit.Assert.assertEquals;
import java.io.File;
import org.junit.Test;

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
}
