public class Nota {
    private String titulo;
    private String texto;
    private int mes;
    private int dia;
    private Contactos contacto;

    public Nota (){}

    // Getters
    public String getTitulo() {
        return titulo;
    }
    public String getTexto() {
        return texto;
    }
    public int getMes() {
        return mes;
    }
    public int getDia() {
        return dia;
    }
    public Contactos getContacto() {
        return contacto;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }
}
