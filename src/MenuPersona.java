import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuPersona {
    HashMap<Integer, Persona>personas= new HashMap<>();

    public void add(Persona persona){
        this.personas.put(persona.getDni(), persona);
    }
    public void addAll(List<Persona> listaDePersonas){
        for(Persona p :  listaDePersonas){
            personas.put(p.getDni(), p);
        }
    }
    public void altaPersona(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el dni: ");
        Integer dni = scanner.nextInt();

        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();

        Persona persona = new Persona(nombre, edad, dni);

        this.add(persona);
    }
    public void eliminarPersona(Integer dni){

        System.out.println("Las personas disponibles son las siguientes: ");
        this.listarPersonas();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el dni de la persona a eliminar: ");
        dni = scanner.nextInt();

        // remove(), además de remover el elemento, devuelve el valor asociado a la clave que
        // se le pasa como parámetro.
        // Si no encuentra la clave devuelve null.
        if(personas.remove(dni) == null){
            System.out.println("No se encontró la persona con el dni ingresado");
        }


    }

    public void modificarPersona(){

        System.out.println("Las personas disponibles son las siguientes: ");
        this.listarPersonas();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el dni de la persona a modificar: ");
        Integer dni = scanner.nextInt();

        System.out.println("Ingrese los nuevos datos de la persona (el dni no puede cambiarse): ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        Integer edad = scanner.nextInt();

        Persona persona = new Persona(nombre, edad, dni);
        personas.replace(persona.getDni(), persona);
    }

    public void listarPersonas(){
        for (Map.Entry<Integer, Persona> persona : personas.entrySet()) {
            System.out.println(persona.getKey() + " - " + persona.getValue().getNombre()+ " " + persona.getValue().getEdad() + " años");
        }



    }
}
