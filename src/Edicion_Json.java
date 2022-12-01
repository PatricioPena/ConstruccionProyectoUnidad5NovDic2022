import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class Edicion_Json
{
	boolean Errors=true;

    public boolean isActive(){
        return this.Errors;
    }

	public void editarEmpleados()
	{
		
		String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a modificar");
		Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
		ArrayList<Empleado> empleados = lectura.getEmpleados();		
		JSONObject json = new JSONObject();
		JSONArray jsonArrayEmpleados = new JSONArray();
		JSONObject jsonEmployee = new JSONObject();
		
		for(Empleado empleado: empleados){
			JSONObject empleadotemp = new JSONObject();
			if(identificador.equals(empleado.getId())){
				String firstName = JOptionPane.showInputDialog(null, "Ingresa el pimer nombre del empleado " + identificador);
				String lastName = JOptionPane.showInputDialog(null, "Ingresa el apellido del empleado " + identificador);
				String photo = JOptionPane.showInputDialog(null, "Ingresa el link de la imagen del empleado " + identificador);
				empleadotemp.put("id", identificador);
				empleadotemp.put("firstName", firstName);
				empleadotemp.put("lastName", lastName);
				empleadotemp.put("photo", photo);
				if (firstName.equals(empleado.getFirstName())) {  
					Errors=false; 
					
				} else {
				}	
			}else{	
				empleadotemp.put("id", empleado.getId());
				empleadotemp.put("firstName", empleado.getFirstName());
				empleadotemp.put("lastName", empleado.getLastName());
				empleadotemp.put("photo", empleado.getPhoto());			
			}

			jsonArrayEmpleados.put(empleadotemp);
		}

		jsonEmployee.put("employee", jsonArrayEmpleados);
		json.put("employees", jsonEmployee);

		String path = "src/listado.json";
		
		try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
			String jsonString = json.toString();
			out.write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean eliminarEmpleados()
	{
		
		String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a eliminar");
		Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
		ArrayList<Empleado> empleados = lectura.getEmpleados();		
		JSONObject json = new JSONObject();
		JSONArray jsonArrayEmpleados = new JSONArray();
		JSONObject jsonEmployee = new JSONObject();
		int idEmpleado = 0;
		for(Empleado empleado: empleados){		
			JSONObject empleadotemp = new JSONObject();
			if(identificador.equals(empleado.getId())){
				
			}else{	
				idEmpleado++;
				String idString = String.valueOf(idEmpleado);
				empleadotemp.put("id", idString);
				empleadotemp.put("firstName", empleado.getFirstName());
				empleadotemp.put("lastName", empleado.getLastName());
				empleadotemp.put("photo", empleado.getPhoto());
				jsonArrayEmpleados.put(empleadotemp);			
			}

			
		}

		jsonEmployee.put("employee", jsonArrayEmpleados);
		json.put("employees", jsonEmployee);

		String path = "src/listado.json";
		
		try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
			String jsonString = json.toString();
			out.write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Errors;
	}
	
}