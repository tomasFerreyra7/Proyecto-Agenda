import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Agenda {
    private String nombre;
    private ArrayList<Nota> notas;

    public Agenda(String nombre) {
        this.nombre = nombre;
        notas = new ArrayList<>();
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public void listarNotas() {

        System.out.println("Nombre: " +nombre);
        for (Nota n : this.notas) {
            System.out.println("Titulo: " + n.getTitulo() + " Texto: " + n.getTexto() + " Mes: " + n.getMes() + " Dia: " + n.getDia());
            Contactos c = n.getContacto();
            System.out.println("Contacto: " + c.getNombre() + " Localidad: " + c.getLocalidad() + " Direccion: " + c.getDireccion());
            System.out.println("Telefonos: ");
            c.listarTelefonos();
        }
    }

    public void buscarXcontactos(String nombre){
        int cant_notas = 0;
        boolean found = false;

        for (Nota n : notas) {
            Contactos c = n.getContacto();
            if (nombre.equalsIgnoreCase(c.getNombre())) {
                cant_notas ++;
                found = true;
                System.out.println("Titulo:" + n.getTitulo() + " Texto:" + n.getTexto());
            }
        }

        if (found == true) {
            System.out.println("Total de notas: " + cant_notas);
        } else {
            System.out.println("El contacto " + nombre + " no se encuentra");
        }
    }
    public void listarContactosALfa(){
        ArrayList<String> nombres = new ArrayList<>();

        // Agregamos todos los contactos al array
        for (Nota n : this.notas) {
            Contactos c = n.getContacto();
            nombres.add(c.getNombre());
        }

        // Recorremos de nuevo el array para ver si hay mas de una ocurrencia igual
        for (int i = 0 ; i < nombres.size() ; i++) {
            for (int j = i + 1 ; j < nombres.size() ; j++) {
                if (nombres.get(i).equals(nombres.get(j))) {
                    nombres.remove(j);
                    j--;
                }
            }
        }

        // Llamamos al metodo Collections.sort para ordenar alfabeticamente el Array list
        Collections.sort(nombres);

        System.out.println(nombres);
    }
    public void buscarXtitulos(String inicio){
        for (Nota n : this.notas) {
            if (inicio.equals(n.getTitulo())) {
                Contactos c = n.getContacto();
                System.out.println(n.getTitulo() + "-" + n.getTexto() + "-" + c.getNombre() + " " + c.getLocalidad() + " " + c.getTelefono());
            }
        }
    }
}
