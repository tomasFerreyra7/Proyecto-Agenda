import java.util.*;

public class Contactos {
    private String nombre;
    private String localidad;
    private String  direccion;
    private String[] telefono = new String[5];

    public Contactos (String nom, String loc, String dir, String caracteristica, int numero) {
        this.nombre = nom;
        this.localidad = loc;
        this.direccion = dir;

        String num = Integer.toString(numero);
        String num_completo = caracteristica + "-" + num;
        telefono[0] = num_completo;
    }

    // Getters
    public String getDireccion() {
        return direccion;
    }
    public String getLocalidad() {
        return localidad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono[0];
    }

    // Setters
    public void setDireccion(String d) {
        this.direccion = d;
    }
    public void setLocalidad(String l) {
        this.localidad = l;
    }
    public void setNombre(String n){
        this.nombre = n;
    }

    public int elementoVacio() {
        int el = -2;

        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] == null) {
                el = i;
                return el;
            }
        }
        if (el == -2) {
            el = -1;
        }

        return el;
    }

    public boolean validarCaracteristica(String c) {
        if (!(c instanceof String)) {
            return false;
        }
        if (c.charAt(0) != '0') {
            return false;
        }
        if (c.length() < 3 || c.length() > 5) {
            return false;
        }
        if (!c.matches("\\d+")) { // la expresion \\d significa un digito y al agregarle el + indicamos que debe haber mas de uno al agregar el matches realiza la comprobacion
            return false;
        }
        return true;
    }

    public boolean validarNumero(int n) {
        // Convertimos el int en string para realizar las comprobaciones necesarias
        String num = Integer.toString(n);

        if (num.length() < 5 || num.length() > 7) {
            return false;
        }
        if (num.charAt(0) == '0') {
            return false;
        }
        if (!num.matches("\\d+")) { // Se explico en el metodo anterior lo que significa \\d+
            return false;
        }
        return true;
    }

    public void agregarTelefono() {
        if (elementoVacio() == -1) {
            System.out.println("No hay espacio para agregar telefonos");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la caracteristica del numero de telefono: ");
        String c = sc.nextLine();

        while (validarCaracteristica(c) == false) {
            System.out.print("Ingrese nuevamente la caracteristica del numero de telefono: ");
            c = sc.nextLine();
        }

        System.out.print("Ingrese el numero de telefono: ");
        String n = sc.nextLine();

        // Convertimos el n a int para utilizar el metodo de validarNumero()
        int num = Integer.parseInt(n);

        while (validarNumero(num) == false) {
            System.out.println("Numero de telefono invalido");
            System.out.print("Ingrese el numero de telefono: ");
            n = sc.nextLine();

            num = Integer.parseInt(n);
        }

        // Concatenamos el numero con la caracteristica separados por un guion
        String num_completo = c + "-" + num;

        // Lo agregamos al espacio vacio
        telefono[elementoVacio()] = num_completo;
        sc.close();
    }

    public void agregarTelefono(String caracteristica, int numero) {
        if (elementoVacio() == -1) {
            System.out.println("No existen elemenos vacios");
            return;
        }

        if (validarCaracteristica(caracteristica) == false || validarNumero(numero) == false) {
            System.out.println("El numero ingresado es erroneo");
            return;
        }

        String num = Integer.toString(numero);
        String num_completo = caracteristica + "-" + num;
        telefono[elementoVacio()] = num_completo;
    }

    public void listarTelefonos() {
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].isEmpty()) {
                System.out.println((i + 1) + ") " + telefono[i]);
            }
        }
    }

    public boolean comprobarSiExistenNumeros() {
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null) {
                return false; // Si encuentra algun numero retorna false
            }
        }
        return true; // Si no encuentra ningun numero retorna true
    }

    public void eliminarTelefono() {
        listarTelefonos();

        // Comprobar si hay numeros en la lista
        if (comprobarSiExistenNumeros() == true) {
            System.out.println("No existen numeros de telefono");
            return;
        }

        System.out.print("Ingrese el numero de la posicion que desee eliminar: ");
        Scanner sc = new Scanner(System.in);
        int n_pos = sc.nextInt();
        sc.close();

        // Creamos un nuevo array auxiliar
        String[] aux = new String[telefono.length];

        // Llenamos el nuevo array con los elementos del array anterior
        for (int i = 0; i < telefono.length; i++) {
            if (telefono[i] != null && !telefono[i].isEmpty()) {
                aux[i] = telefono[i];
            }
        }

        // Eliminamos el valor que se encuentra en la posicion que deseamos eliminar
        for (int i = 0; i < aux.length; i++) {
            if (i == (n_pos - 1)) {
                aux[i] = null;
            }
        }

        // Borramos telefono[]
        for (int i = 0; i < telefono.length; i++) {
            telefono[i] = null;
        }

        // Cargamos el nuevo array a telefono[]
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != null && !aux[i].isEmpty()) {
                telefono[i] = aux[i];
            }
        }

        System.out.println("Telefono eliminado exitosamente");
    }

    public void modificarTelefono() {
        listarTelefonos();

        // Comprobar si hay numeros en la lista
        if (comprobarSiExistenNumeros() == true) {
            System.out.println("No existen numeros de telefono");
            return;
        }

        System.out.print("Ingrese el numero de la posicion del telefono que desee modificar: ");
        Scanner sc = new Scanner(System.in);
        int n_pos = sc.nextInt();
        n_pos = n_pos - 1;
        sc.nextLine(); // Consumir el salto de linea

        // Obtenemos el indice de donde se encuentra el guion asi solo reemplazamos el numero y no su caracteristica
        int indexGuion = telefono[n_pos].indexOf('-');

        // Obtenemos la caracteristica del telefono a modificar
        String caracteristica = telefono[n_pos].substring(0,indexGuion);

        System.out.print("Ingrese el nuevo numero de telefono: ");
        String new_numberPhone = sc.nextLine();
        sc.close();

        // Concatenamos la caracteristica "-" y el numero nuevo
        telefono[n_pos] = caracteristica + "-" + new_numberPhone;
        System.out.println("Telefono modificado exitosamente");
    }

    public boolean validarPosicion(int p) {
        return p >= 0 && p < telefono.length;
    }
}
