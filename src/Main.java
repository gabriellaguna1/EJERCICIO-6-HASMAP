import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.compare;
import static java.util.stream.Collectors.averagingDouble;

public class Main {
    public static void main(String[] args) {

        String opc;
        Map<Character, Integer> mapa= new HashMap<>();

        do{
        System.out.println("Ingrese una palabra: ");
        Scanner sr= new Scanner(System.in);
        String palabra= sr.nextLine();

        char[]palabrita= palabra.toCharArray();

        for(Character c: palabrita){
            if(!mapa.containsKey(c)){
                mapa.put(c,1);
            }else{
                mapa.put(c, mapa.get(c)+1);
            }
        }

        System.out.println("desea continuar? s / n");
        Scanner eleccion= new Scanner(System.in);
        opc=eleccion.nextLine();
        System.out.println("palabra "+palabra+" "+mapa);

         }while(!opc.equalsIgnoreCase("n"));


        // Escriba un programa que genere una lista de números aleatorios, la ordene y
        // luego elimine los duplicados. Utilice un HashSet para almacenar los números
        // únicos y un ArrayList para la lista original

        List<Integer> numerosAleatorios = new ArrayList<>();
        Integer num;

        for(int i=0; i<10; i++){
            num= (int) (Math.random()*10);
            numerosAleatorios.add(num);
        }

        System.out.println("mostrando lista de numeros aleatorios");
        for(Integer i: numerosAleatorios){
            System.out.println(i);
        }

        Set<Integer>hashSet= new HashSet<>();

        System.out.println("pasando los numeros de la lista al hashSet");
        for(Integer i: numerosAleatorios){
            hashSet.add(i);
        }

        System.out.println("mostrando hashSet");
        for(Integer i : hashSet){
            System.out.println(i);
        }

       // Escriba un programa que solicite al usuario que ingrese una lista de nombres
        // de personas y sus edades, y luego ordene la lista por edad. Utilice un
        // TreeMap para almacenar los nombres y las edades

        Scanner sr= new Scanner(System.in);
        Scanner sc= new Scanner(System.in);
        String name;
        Integer edad;
        TreeMap<Integer, String>arbol= new TreeMap<>();

        opc= "s";

        do{
            System.out.println("ingrese nombre: ");
            name= sr.nextLine();
            System.out.println("Ingrese edad: ");
            edad= sc.nextInt();
            arbol.put(edad, name);

            System.out.println("desea continuar? s/n");
            opc= sr.nextLine();
        }while(!opc.equalsIgnoreCase("n"));

        System.out.println("mostrando arbol");
        for(Map.Entry<Integer,String> a : arbol.entrySet()){
            System.out.println("Nombre: "+ a.getKey()+" - edad: "+a.getValue());
        }

        //Escriba un programa que lea una lista de números enteros y luego calcule la
        // suma y el promedio. Utilice un ArrayList para almacenar los números y una
        // HashMap para calcular la frecuencia de cada número. (Averiguar cómo hacer
        // una suma de elementos de una lista con streams). Stream es un flujo de
        // datos que a través de métodos concatenados podemos filtrarlos, modificarlos
        // y realizar distintas operaciones que devuelvan un flujo totalmente diferente

        List<Integer>listaDeEnteros= Arrays.asList(5,6,8,7,1,5,2,3,5,9);
        Stream<Integer> streamdeLista= listaDeEnteros.stream();
        HashMap<Integer, Integer>mapDeNumeros= new HashMap<>();

        for(Integer i: listaDeEnteros){
            if(!mapDeNumeros.containsKey(i)){
                mapDeNumeros.put(i, 1);
            }else{
                mapDeNumeros.put(i, mapDeNumeros.get(i)+1);
            }
        }

        System.out.println("mostrando mapa de enteros");
        for(Map.Entry<Integer, Integer> i : mapDeNumeros.entrySet()){
            System.out.println("numero: "+ i.getKey()+" - frecuencia: "+ i.getValue());
        }

        System.out.println("Utilizando el STREAM");
        Integer suma = streamdeLista.reduce(0, (a,b)-> a+b).intValue();
        System.out.println("suma de los numeros enteros en la lista de stream: "+ suma);

        Float promedio= (float) suma/listaDeEnteros.size();
        System.out.println("el promedio de los numeros de la lista de stream es: "+promedio);

        // Escriba un programa que lea una lista de números enteros y luego ordene la
        // lista en orden ascendente y descendente. Utilice un TreeSet para almacenar
        // los números y mostrarlos en orden ascendente y descendente

        List<Integer>listaEj5= Arrays.asList(2,5,8,4,6,9,7,6,6,4,7,4,1,0);

        TreeSet<Integer>setEj5= new TreeSet<>(listaEj5);

        System.out.println("mostrando lista forma descendente");
        listaEj5.sort(Collections.reverseOrder());
        System.out.println(listaEj5);
        System.out.println("mostrando lista ordenada de forma ascendente");
        listaEj5.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("Lista ordenada de menor a mayor: " + listaEj5);

        //Cree una clase Persona con los atributos nombre, dni y edad. Luego debe
        // crear otra clase que se encargue de la alta, baja y modificación de las
        // personas. Esta última clase debe tener un HashMap de Personas donde la
        // clave sea el dni y el valor el objeto Persona. Además de los métodos de ABM
        // se debe contar con uno que agregue un objeto ya creado, otro que tome una
        // lista de Personas y las agregue en el Map, y por último, un método que
        // devuelva la estructura ordenada por edad. Pista: El HashMap no es una
        // estructura de datos ordenada, por ende, el método no puede devolver este
        // tipo de mapa

        Persona persona1 = new Persona("Juan", 20, 12345678);
        Persona persona2 = new Persona("Matias", 30, 87654321);
        Persona persona3 = new Persona("Pedro", 18, 789456123);
        Persona persona4 = new Persona("Maria", 20, 96325874);
        Persona persona5 = new Persona("Ana", 40, 321654987);

        ArrayList<Persona> lista = new ArrayList<>(Arrays.asList(persona1, persona2, persona3, persona4, persona5));

        MenuPersona m= new MenuPersona();
        m.addAll(lista);

        m.altaPersona();
        m.modificarPersona();
        m.eliminarPersona(12345678);

    }





}