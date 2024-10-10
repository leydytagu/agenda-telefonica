import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(5); // Agenda con capacidad máxima de 5 contactos
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Agenda Telefónica ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono de un contacto");
            System.out.println("6. Ver si la agenda está llena");
            System.out.println("7. Ver espacio disponible en la agenda");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Captura el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
                    agenda.agregarContacto(nuevoContacto);
                    break;

                case 2:
                    agenda.listarContactos();
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoBuscar = scanner.nextLine();
                    agenda.buscarContacto(nombreBuscar, apellidoBuscar);
                    break;

                case 4:
                    System.out.print("Nombre: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEliminar = scanner.nextLine();
                    Contacto contactoEliminar = new Contacto(nombreEliminar, apellidoEliminar, "");
                    agenda.eliminarContacto(contactoEliminar);
                    break;

                case 5:
                    System.out.print("Nombre: ");
                    String nombreMod = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoMod = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();
                    agenda.modificarTelefono(nombreMod, apellidoMod, nuevoTelefono);
                    break;

                case 6:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("Todavía hay espacio disponible.");
                    }
                    break;

                case 7:
                    agenda.espacioLibre();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}
