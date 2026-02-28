import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Biblioteca {

    private ArrayList<Usuario> usuarios;
    private ArrayList<MaterialBiblioteca> materiales;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        usuarios = new ArrayList<>();
        materiales = new ArrayList<>();
        prestamos = new ArrayList<>();

        precargarDatos();
    }

    //PRECARGA

    private void precargarDatos() {
        //Usuarios precargados
        Usuario u1 = new Usuario("U1", "Juan", "Perez", "juan@mail.com", "4426224765");
        Usuario u2 = new Usuario("U2", "Maria", "Lopez", "maria@mail.com", "4466243571");
        //Añadimos los Usuarios
        usuarios.add(u1);
        usuarios.add(u2);
        //Hijos precargados como un Libro, Revista y el Comic
        Libro l1 = new Libro("L1", "El Quijote", 1605, 5,
                "Cervantes", "Planeta", "123-ABC", "Novela");

        Revista r1 = new Revista("R1", "National Geographic", 2023, 3,
                "NatGeo", 150, "Mensual");

        Comic c1 = new Comic("C1", "Spider-Man", 2022, 4,
                "Stan Lee", "Ditko", "Marvel", "Marvel");
        //Añadimos los Materiales
        materiales.add(l1);
        materiales.add(r1);
        materiales.add(c1);
        //Hacemos un Prestamo
        Prestamo p1 = new Prestamo(u2, l1, "27/2/2026");
        //Añadimos el Prestamo
        materiales.add(l1); 
        prestamos.add(p1);
    }

    //BUSQUEDAS 
    //Metodo Buscar Usuario por ID
    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equalsIgnoreCase(id)) {
                return u;
            }
        }
        return null;
    }
    //Metodo Buscar Material por ID
    public MaterialBiblioteca buscarMaterialPorId(String id) {
        for (MaterialBiblioteca m : materiales) {
            if (m.getIdMaterial().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }
    //Metodo Buscar Prestamos con ID de Usuario
    public void consultarPrestamoPorUsuario(String idUsuario) {
        boolean encontrado = false;

        for (Prestamo p : prestamos) {
            if (p.getUsuario().getIdUsuario().equalsIgnoreCase(idUsuario)) {
                System.out.println(p);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay prestamos registrados para este usuario.");
        }
    }

    //REGISTROS
    //Metodo para Registrar un Usuario
    public void registrarUsuario(String id, String nombre, String apellido, String correo, String telefono) {
        //Verificamos si esta disponible la ID
        if (buscarUsuarioPorId(id) != null) {
            System.out.println("Ya existe un usuario con ese ID.");
            return;
        }

        Usuario nuevo = new Usuario(id, nombre, apellido, correo, telefono);
        usuarios.add(nuevo);
        System.out.println("Usuario registrado correctamente.");
    }
    //Metodo para Registrar un Libro
    public void registrarLibro(String idMaterial, String titulo, int anioPublicacion,
                                int noEjemplares, String autor, String editorial,
                                String isbn, String genero) {
        //Verificamos si esta disponible el ID
        if (buscarMaterialPorId(idMaterial) != null) {
            System.out.println("Ya existe un material con ese ID.");
            return;
        }

        Libro nuevo = new Libro(idMaterial, titulo, anioPublicacion,
                noEjemplares, autor, editorial, isbn, genero);

        materiales.add(nuevo);
        System.out.println("Libro registrado correctamente.");
    }
    //Metodo para Registrar una Revista
    public void registrarRevista(String idMaterial, String titulo, int anioPublicacion,
                                  int noEjemplares, String editorial,
                                  int numeroEdicion, String periodicidad) {
        //Verificamos si esta disponible la ID
        if (buscarMaterialPorId(idMaterial) != null) {
            System.out.println("Ya existe un material con ese ID.");
            return;
        }

        Revista nueva = new Revista(idMaterial, titulo, anioPublicacion,
                noEjemplares, editorial, numeroEdicion, periodicidad);

        materiales.add(nueva);
        System.out.println("Revista registrada correctamente.");
    }
    //Metodo para Registrar un Comic
    public void registrarComic(String idMaterial, String titulo, int anioPublicacion,
                                int noEjemplares, String autor,
                                String ilustrador, String editorial, String universo) {
        //Verificamos si esta disponible el ID
        if (buscarMaterialPorId(idMaterial) != null) {
            System.out.println("Ya existe un material con ese ID.");
            return;
        }

        Comic nuevo = new Comic(idMaterial, titulo, anioPublicacion,
                noEjemplares, autor, ilustrador, editorial, universo);

        materiales.add(nuevo);
        System.out.println("Comic registrado correctamente.");
    }

    //PRESTAMOS 
    //Metodo para Registrar un Prestamo
    public void realizarPrestamo(String idUsuario, String idMaterial, String fechaPrestamo) {
        //Validamos que el Usuario Exista
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        //Validamos si el Material Existe
        MaterialBiblioteca material = buscarMaterialPorId(idMaterial);
        if (material == null) {
            System.out.println("Material no encontrado.");
            return;
        }
        //Validamos si aún hay Ejemplares Disponibles
        if (!material.prestar()) {
            System.out.println("No hay ejemplares disponibles.");
            return;
        }

        Prestamo nuevoPrestamo = new Prestamo(usuario, material, fechaPrestamo);
        material.prestar();

        System.out.println("Prestamo realizado correctamente.");
    }
    //Metodo para Devolver un Material
    public void devolverMaterial(String idUsuario, String idMaterial) {

        Prestamo encontrado = null;

        for (Prestamo p : prestamos) {
            if (p.getUsuario().getIdUsuario().equalsIgnoreCase(idUsuario)
                    && p.getMaterial().getIdMaterial().equalsIgnoreCase(idMaterial)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Prestamo no encontrado.");
            return;
        }

        encontrado.getMaterial().devolver();
        prestamos.remove(encontrado);

        System.out.println("Material devuelto correctamente.");
    }

    //MOSTRAR
    //Metodo para Mostrar Usuarios
    public void mostrarUsuarios() {
        //Validamos que Existan Usuarios
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
    //Metodo para Mostrar Materiales
    public void mostrarMateriales() {
        //Validadmos que Existan Materiales
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }

        for (MaterialBiblioteca m : materiales) {
            System.out.println(m);
        }
    }
    //Metodo para Mostrar Prestamos
    public void mostrarPrestamos() {
        //Validamos que Existan Prestamos
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos registrados.");
            return;
        }

        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    //ELIMINAR
    //Metodo para Eliminar un Usuario
    public void eliminarUsuario(String idUsuario) {
        //Validamos que el Usuario Exista
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        //Tenemos que Validar que NO tenga ningún Prestamo Activo
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getIdUsuario().equalsIgnoreCase(idUsuario)) {
                System.out.println("No se puede eliminar el usuario porque tiene un prestamo activo.");
                return;
            }
        }

        usuarios.remove(usuario);
        System.out.println("Usuario eliminado correctamente.");
    }
    //Metodo para Eliminar un Material
    public void eliminarMaterial(String idMaterial) {
        //Validamos que Exista el Material
        MaterialBiblioteca material = buscarMaterialPorId(idMaterial);
        if (material == null) {
            System.out.println("Material no encontrado.");
            return;
        }
        //Tenemos que Validar que NO se Encuentra activo en un Prestamo
        for (Prestamo p : prestamos) {
            if (p.getMaterial().getIdMaterial().equalsIgnoreCase(idMaterial)) {
                System.out.println("No se puede eliminar el material porque tiene un prestamo activo.");
                return; 
            }
        }

        materiales.remove(material);
        System.out.println("Material eliminado correctamente.");
    }
    //Metodo para Eliminar un Prestamo
    public void eliminarPrestamo(String idUsuario, String idMaterial) {

        Prestamo encontrado = null;
        //Validamos que el Prestamos Exista y lo buscamos con el ID Usuario y Material
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getIdUsuario().equalsIgnoreCase(idUsuario)
                    && p.getMaterial().getIdMaterial().equalsIgnoreCase(idMaterial)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Prestamo no encontrado.");
            return;
        }

        encontrado.getMaterial().devolver();
        prestamos.remove(encontrado);

        System.out.println("Prestamo eliminado correctamente.");
    }

    //REPORTE
    //Metodo para Hacer un Reporte 
    public void generarReporte() {

        try {
            FileWriter writer = new FileWriter("Reporte_Biblioteca.txt");

            writer.write("==== REPORTE BIBLIOTECA ====\n\n");

            writer.write("---- USUARIOS ----\n");
            for (Usuario u : usuarios) {
                writer.write(u.toString() + "\n");
            }

            writer.write("\n---- MATERIALES ----\n");
            for (MaterialBiblioteca m : materiales) {
                writer.write(m.toString() + "\n");
            }

            writer.write("\n---- PRESTAMOS ----\n");
            for (Prestamo p : prestamos) {
                writer.write(p.toString() + "\n");
            }

            writer.close();

            System.out.println("Reporte generado correctamente.");
        //En caso de que no se pueda manejamos el Error
        } catch (IOException e) {
            System.out.println("Error al generar el reporte.");
        }
    }
}