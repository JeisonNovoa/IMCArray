import java.util.ArrayList;
import javax.swing.JOptionPane;

public class proceso {
	public void iniciar() {
		menu();
	}
	static ArrayList<String> nombres = new ArrayList<String> ();
	static ArrayList<Double> pesos = new ArrayList<Double> ();
	static ArrayList<Double> alturas = new ArrayList<Double> ();
	static ArrayList<Double> imcs = new ArrayList<Double> ();
	static ArrayList<Integer> telefonos = new ArrayList<Integer> ();
	
	public void menu() {
		int valid;
		do {
			valid = Integer.parseInt(JOptionPane.showInputDialog(null, "Programa para calcular IMC\n"
					+ "\n1) Ingresar usuario"
					+ "\n2) Imprimir datos"
					+ "\n3) Consulta individual"
					+ "\n4) Eliminar persona"
					+ "\n5) Actualizar"
					+ "\n6 Limpiar lista"
					+ "\n7) Salir"
					+ "\nIngrese una opcion:"));
			switch(valid) {
				case 1:
					getData();
					break;
				case 2:
					if(nombres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					IMC();
					printData();
					break;
				case 3:
					if(nombres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					IMC();
					searchName();
					break;
				case 4:
					if(nombres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					deleteUser();
					JOptionPane.showMessageDialog(null, "el usuario se ha eliminado con exito");
					break;
				case 5:
					if(nombres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					 updateUser();
						JOptionPane.showMessageDialog(null, "el usuario se ha actualizado con exito");
					break;
				case 6:
					if(nombres.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					clearList();
					JOptionPane.showMessageDialog(null, "Los datos se han eliminado con exito");
					break;
				case 7:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta", "ALERTA", JOptionPane.WARNING_MESSAGE);
			}
		}while(valid != 7);
	}
	
	public void getData(){
		String nombre;
		double peso, altura;
		int telefono;	
		nombre = JOptionPane.showInputDialog(null, "ingresar nombre: ");
		nombres.add(nombre);
		telefono = Integer.parseInt(JOptionPane.showInputDialog(null, nombre + " ingrese su numero de telefono: "));
		telefonos.add(telefono);
		peso = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese su peso en kg: "));
		pesos.add(peso);
		altura = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese su altura en metros: "));
		alturas.add(altura);
	}
	
	public void IMC() {
		imcs.clear();
		double imc = 0;
		for (int i = 0; i < pesos.size(); i++) {
			imc = pesos.get(i) / (alturas.get(i) * alturas.get(i));
			imcs.add(imc);
		}
	}
	
	public void printData() {
		for (int i = 0; i < imcs.size(); i++) {
			System.out.println(status(i)); 
		}
	}
		
	public void searchName() {
		String name = JOptionPane.showInputDialog("Ingrese nombre que desea buscar");
		if(!(nombres.contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro un usario con dicho nombre", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}else {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equals(name)) {
					System.out.println(status(i));
				}
			}
			
		}
		
	}
	
	public void deleteUser() {
		String name = JOptionPane.showInputDialog("Ingrese nombre del usuario que desea eliminar");
		if(!(nombres.contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro un usario con dicho nombre", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}else {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equals(name)) {
					nombres.remove(i);
					telefonos.remove(i);
					pesos.remove(i);
					alturas.remove(i);
					imcs.remove(i);
				}
			}
		}
	}
	
	public void updateUser() {
		String name = JOptionPane.showInputDialog("Ingrese nombre del usuario que desea actualizar");
		String nombre;
		double peso, altura;
		int telefono;	
		if(!(nombres.contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro un usario con dicho nombre", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}else {
			for (int i = 0; i < nombres.size(); i++) {
				if (nombres.get(i).equals(name)) {
					nombre = JOptionPane.showInputDialog(null, "ingresar nombre: ");
					nombres.set(i, nombre);
					telefono = Integer.parseInt(JOptionPane.showInputDialog(null, nombre + " ingrese su numero de telefono: "));
					telefonos.set(i, telefono);
					peso = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese su peso en kg: "));
					pesos.set(i, peso);
					altura = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese su altura en metros: "));
					alturas.set(i, altura);
				}
			}
		}
		
	}
	
	public void clearList() {
		nombres.clear();
		telefonos.clear();
		pesos.clear();
		alturas.clear();
		imcs.clear();	
	}
	
	public String status(int i) {
		if(imcs.get(i) < 18.0) return mensaje(i) + "\nEstado: Anorexia\n\n";
		
		else if(imcs.get(i) < 20.0) return mensaje(i) + "\nEstado: Delgadez\n\n";
		
		else if(imcs.get(i) < 27.0) return mensaje(i) + "\nEstado: Normalidad\n\n";
		
		else if(imcs.get(i) < 30.0) return mensaje(i) + "\nEstado: Obesidad(grado1)\n\n";
		
		else if(imcs.get(i) < 35.0) return mensaje(i) + "\nEstado: Obesidad(grado2)\n\n";
		
		else if(imcs.get(i) < 40.0) return mensaje(i) + "\nEstado: Obesidad(grado3)\n\n";
		
		else return mensaje(i) + "\nEstado: Obesidad Morbida\n\n";
	}
	
	public String mensaje(int i) {
		return "usuario: "
			+ (i+1) 
			+") Nombre:" + nombres.get(i) 
			+ "\nTelefono: " + telefonos.get(i);
	}
}