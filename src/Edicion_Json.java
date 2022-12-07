import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class Edicion_Json {
	boolean Errors = true;
	boolean ValidacionBorrar = false;
	boolean ValidacionAgregar = false;

	public boolean isActive() {
		return this.Errors;
	}

	public boolean isDeleting() {
		return this.ValidacionBorrar;
	}

	public boolean isAdding() {
		return this.ValidacionAgregar;
	}

	public void editarEmpleados() {
		String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a modificar");
		Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
		ArrayList<Empleado> empleados = lectura.getEmpleados();
		JSONObject json = new JSONObject();
		JSONArray jsonArrayEmpleados = new JSONArray();
		JSONObject jsonEmployee = new JSONObject();
		String path = "src/listado.json";
		int validar = Integer.parseInt(identificador);
		int contador = 0;
		for (Empleado empleado : empleados) {
			contador++;
		}
		if (validar > contador) {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		} else {
			for (Empleado empleado : empleados) {
				JSONObject empleadotemp = new JSONObject();
				if (identificador.equals(empleado.getId())) {
					String firstName = JOptionPane.showInputDialog(null,
							"Ingresa el pimer nombre del empleado " + identificador);
					String lastName = JOptionPane.showInputDialog(null,
							"Ingresa el apellido del empleado " + identificador);
					String photo = JOptionPane.showInputDialog(null,
							"Ingresa el link de la imagen del empleado " + identificador);
					empleadotemp.put("id", identificador);
					empleadotemp.put("firstName", firstName);
					empleadotemp.put("lastName", lastName);
					empleadotemp.put("photo", photo);
					if (firstName.equals(empleado.getFirstName())) {
						Errors = false;

					} else {
					}
				} else {
					empleadotemp.put("id", empleado.getId());
					empleadotemp.put("firstName", empleado.getFirstName());
					empleadotemp.put("lastName", empleado.getLastName());
					empleadotemp.put("photo", empleado.getPhoto());
				}

				jsonArrayEmpleados.put(empleadotemp);
			}

			jsonEmployee.put("employee", jsonArrayEmpleados);
			json.put("employees", jsonEmployee);

			try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
				String jsonString = json.toString();
				out.write(jsonString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean eliminarEmpleados() {
		String identificador = JOptionPane.showInputDialog(null, "Ingresa el id del empleado a eliminar");
		Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
		ArrayList<Empleado> empleados = lectura.getEmpleados();
		JSONObject json = new JSONObject();
		JSONArray jsonArrayEmpleados = new JSONArray();
		JSONObject jsonEmployee = new JSONObject();
		String path = "src/listado.json";
		int idEmpleado = 0;
		int contador = 0;
		int validar = Integer.parseInt(identificador);

		for (Empleado empleado : empleados) {
			contador++;
		}
		if (validar > contador) {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		} else {
			contador = 0;
			for (Empleado empleado : empleados) {
				contador++;
				JSONObject empleadotemp = new JSONObject();
				if (identificador.equals(empleado.getId())) {
					ValidacionBorrar = true;
				} else {
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

			try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
				String jsonString = json.toString();
				out.write(jsonString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (jsonArrayEmpleados.length() == (contador - 1)) {
				Errors = false;
			} else {
				Errors = true;
			}
		}
		return Errors;
	}

	public int agregarEmpleado() {
		Lectura_Json lectura = new Lectura_Json();
		lectura.leerJson();
		ArrayList<Empleado> empleados = lectura.getEmpleados();
		JSONObject json = new JSONObject();
		JSONArray jsonArrayEmpleados = new JSONArray();
		JSONObject jsonEmployee = new JSONObject();
		int idEmpleado = 0;
		for (Empleado empleado : empleados) {
			JSONObject empleadotemp = new JSONObject();
			empleadotemp.put("id", empleado.getId());
			empleadotemp.put("firstName", empleado.getFirstName());
			empleadotemp.put("lastName", empleado.getLastName());
			empleadotemp.put("photo", empleado.getPhoto());
			jsonArrayEmpleados.put(empleadotemp);
			idEmpleado++;
		}
		idEmpleado++;

		String idString = String.valueOf(idEmpleado);
		JSONObject empleadotemp = new JSONObject();
		String firstName = JOptionPane.showInputDialog(null, "Ingresa el pimer nombre del empleado ");
		String lastName = JOptionPane.showInputDialog(null, "Ingresa el apellido del empleado ");
		String photo = JOptionPane.showInputDialog(null, "Ingresa el link de la imagen del empleado ");
		String path = "src/listado.json";

		empleadotemp.put("id", idString);
		empleadotemp.put("firstName", firstName);
		empleadotemp.put("lastName", lastName);
		empleadotemp.put("photo", photo);
		jsonArrayEmpleados.put(empleadotemp);
		ValidacionAgregar = true;
		jsonEmployee.put("employee", jsonArrayEmpleados);
		json.put("employees", jsonEmployee);

		try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
			String jsonString = json.toString();
			out.write("");
			out.write(jsonString);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idEmpleado;
	}
}