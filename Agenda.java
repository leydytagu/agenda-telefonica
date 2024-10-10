import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda(int capacidadMaxima) {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarContacto(Contacto contacto) {
        if (contacto.getNombre().isEmpty() || contacto.getApellido().isEmpty()) {
            System.out.println("El nombre y apellido no pueden estar vacíos.");
            return;
        }

        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
            return;
        }

        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe en la agenda.");
            return;
        }

        contactos.add(contacto);
        System.out.println("Contacto añadido correctamente.");
    }

    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            contactos.stream()
                    .sorted(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido))
                    .forEach(System.out::println);
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        Optional<Contacto> contactoEncontrado = contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido))
                .findFirst();

        if (contactoEncontrado.isPresent()) {
            System.out.println("Teléfono: " + contactoEncontrado.get().getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("No se ha encontrado el contacto para eliminar.");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Optional<Contacto> contactoEncontrado = contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido))
                .findFirst();

        if (contactoEncontrado.isPresent()) {
            contactoEncontrado.get().setTelefono(nuevoTelefono);
            System.out.println("Teléfono actualizado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public void espacioLibre() {
        int espacioRestante = capacidadMaxima - contactos.size();
        System.out.println("Espacio disponible: " + espacioRestante + " contactos.");
    }
}
