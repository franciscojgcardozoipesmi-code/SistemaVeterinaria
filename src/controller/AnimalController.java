package controller;

import dao.AnimalDAO;
import java.util.ArrayList;
import modelo.Animal;

public class AnimalController {

    private static final AnimalDAO animalDAO = new AnimalDAO();

    public static ArrayList<Object[]> listarAnimales() {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (Animal animal : animalDAO.listar()) {

            String nombreCliente =
                    obtenerNombreCliente(
                            animal.getIdCliente()
                    );

            lista.add(new Object[]{
                animal.getIdAnimal(),
                animal.getNombre(),
                animal.getEspecie(),
                animal.getRaza(),
                animal.getEdad(),
                nombreCliente
            });
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarAnimales(
            String filtro
    ) {

        ArrayList<Object[]> lista =
                new ArrayList<>();

        for (Animal animal
                : animalDAO.buscarAnimales(filtro)) {

            String nombreCliente =
                    obtenerNombreCliente(
                            animal.getIdCliente()
                    );

            lista.add(new Object[]{
                animal.getIdAnimal(),
                animal.getNombre(),
                animal.getEspecie(),
                animal.getRaza(),
                animal.getEdad(),
                nombreCliente
            });
        }

        return lista;
    }

    public static void guardarAnimal(String nombre,
                                     String especie,
                                     String raza,
                                     int edad,
                                     int idCliente,
                                     int idAnimal) {

        Animal animal = new Animal(
                idAnimal,
                nombre,
                especie,
                raza,
                edad,
                idCliente
        );

        animalDAO.guardar(animal);
    }

    public static void eliminarAnimal(int idAnimal) {
        animalDAO.eliminar(idAnimal);
    }
    
    public static ArrayList<Object[]> listarAnimalesParaCombo() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Animal animal : animalDAO.listar()) {

            lista.add(new Object[]{
                animal.getIdAnimal(),
                animal.getNombre(),
                animal.getIdCliente()
            });
        }

        return lista;
    }

        public static int obtenerIdClientePorAnimal(int idAnimal) {

        for (Animal animal : animalDAO.listar()) {

            if (animal.getIdAnimal() == idAnimal) {
                return animal.getIdCliente();
            }
        }

        return -1;
    }
        public static ArrayList<Object[]> listarAnimalesPorCliente(
                int idCliente
        ) {

            ArrayList<Object[]> lista =
                    new ArrayList<>();

            for (Animal animal : animalDAO.listar()) {

                if (animal.getIdCliente() == idCliente) {

                    lista.add(new Object[]{
                        animal.getIdAnimal(),
                        animal.getNombre(),
                        animal.getEspecie(),
                        animal.getRaza(),
                        animal.getEdad(),
                        obtenerNombreCliente(
                                animal.getIdCliente()
                        )
                    });
                }
            }

            return lista;
        }
        private static String obtenerNombreCliente(
                int idCliente
        ) {

            Object[] cliente =
                    ClienteController.obtenerClientePorId(
                            idCliente
                    );

            if (cliente != null) {
                return cliente[1].toString();
            }

            return "Sin cliente";
        }
}