public class Prueba {
    private Agenda agenda;

    public Prueba() {}

    public void setAgenda(Agenda a) {
        this.agenda = a;
    }

    public void instanciaContactos() {
        Contactos contacto1 = new Contactos("Tomas","Santo Tome", "Aristobulo del Valle","0342",5396493);
        Contactos contacto2 = new Contactos("Franco","Santo Tome", "Santiago del estero 1233","0342",5396493);
        Contactos contacto3 = new Contactos("Justo","Santa Fe", "Guemes 4398","0342",5396493);
        Contactos contacto4 = new Contactos("Raul", "Rafaela", "Lopez 3424","0342",5396493);

        System.out.println("Nombre:" + contacto1.getNombre() + " Localidad:" + contacto1.getLocalidad() + " Direccion:" + contacto1.getDireccion());
        System.out.println("Nombre:" + contacto2.getNombre() + " Localidad:" + contacto2.getLocalidad() + " Direccion:" + contacto2.getDireccion());
        System.out.println("Nombre:" + contacto3.getNombre() + " Localidad:" + contacto3.getLocalidad() + " Direccion:" + contacto3.getDireccion());
        System.out.println("Nombre:" + contacto4.getNombre() + " Localidad:" + contacto4.getLocalidad() + " Direccion:" + contacto4.getDireccion());
    }

    public void instaciaTelefonos() {
        Contactos co = new Contactos("Tomas","Santo Tome", "Aristobulo del Valle","0342",5396493);

        co.agregarTelefono("0342",1234567);
        co.agregarTelefono("0342",7654321);
        co.agregarTelefono("0342",1100110);
        co.agregarTelefono("0342",9999999);

        co.listarTelefonos();
    }

    public void instanciaNot() {
        Nota n1 = new Nota();
        Nota n2 = new Nota();
        Nota n3 = new Nota();
        Nota n4 = new Nota();

        Contactos contacto1 = new Contactos("Tomas","Santo Tome", "Aristobulo del Valle","0342",5396493);
        Contactos contacto2 = new Contactos("Franco","Santo Tome", "Santiago del estero 1233","0342",5672928);
        Contactos contacto3 = new Contactos("Justo","Santa Fe", "Guemes 4398","0342",6829711);
        Contactos contacto4 = new Contactos("Raul", "Rafaela", "Lopez 3424","0342",5849372);

        n1.setContacto(contacto1);
        n2.setContacto(contacto2);
        n3.setContacto(contacto3);
        n4.setContacto(contacto4);

        n1.getContacto();
        n2.getContacto();
        n3.getContacto();
        n4.getContacto();
    }

    public Agenda instanciaAgenda() {
        Contactos contacto1 = new Contactos("Tomas","Santo Tome", "Aristobulo del Valle","0342",5396493);
        Contactos contacto2 = new Contactos("Franco","Santo Tome", "Santiago del estero 1233","0342",5672928);
        Contactos contacto3 = new Contactos("Justo","Santa Fe", "Guemes 4398","0342",6829711);
        Contactos contacto4 = new Contactos("Raul", "Rafaela", "Lopez 3424","0342",5849372);

        Nota n1 = new Nota();
        Nota n2 = new Nota();
        Nota n3 = new Nota();
        Nota n4 = new Nota();
        Nota n5 = new Nota();
        Nota n6 = new Nota();
        Nota n7 = new Nota();
        Nota n8 = new Nota();

        n1.setTitulo("Nota 1");
        n1.setTexto("Texto nota");
        n1.setMes(3);
        n1.setDia(23);
        n1.setContacto(contacto1);


        n2.setTitulo("Nota 2");
        n2.setTexto("Texto nota");
        n2.setMes(3);
        n2.setDia(23);
        n2.setContacto(contacto4);

        n3.setTitulo("Nota 3");
        n3.setTexto("Texto nota");
        n3.setMes(3);
        n3.setDia(23);
        n3.setContacto(contacto2);

        n4.setTitulo("Nota 4");
        n4.setTexto("Texto nota");
        n4.setMes(3);
        n4.setDia(23);
        n4.setContacto(contacto3);

        n5.setTitulo("Nota 5");
        n5.setTexto("Texto nota");
        n5.setMes(3);
        n5.setDia(23);
        n5.setContacto(contacto3);

        n6.setTitulo("Nota 6");
        n6.setTexto("Texto nota");
        n6.setMes(3);
        n6.setDia(23);
        n6.setContacto(contacto3);

        n7.setTitulo("Nota 7");
        n7.setTexto("Texto nota");
        n7.setMes(3);
        n7.setDia(23);
        n7.setContacto(contacto3);

        n8.setTitulo("Nota 8");
        n8.setTexto("Texto nota");
        n8.setMes(3);
        n8.setDia(23);
        n8.setContacto(contacto3);

        Agenda a = new Agenda("Agenda 1");
        a.agregarNota(n1);
        a.agregarNota(n2);
        a.agregarNota(n3);
        a.agregarNota(n4);
        a.agregarNota(n5);
        a.agregarNota(n6);
        a.agregarNota(n7);
        a.agregarNota(n8);

        return a;
    }

    public void pruebaBuscarXContactos() {
        Agenda a = this.instanciaAgenda();
        a.buscarXcontactos("Pepe picapiedra");
    }

    public void pruebaListarContactosAlfa() {
        Agenda a = this.instanciaAgenda();
        a.listarContactosALfa();
    }

    public void pruebaBuscarXTitulos() {
        Agenda a = this.instanciaAgenda();
        a.buscarXtitulos("Nota 7");
    }

}
