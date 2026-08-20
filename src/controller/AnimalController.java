package controller;

import dao.AnimalDAO;
import java.util.ArrayList;
import modelo.Animal;

public class AnimalController {

    private static final AnimalDAO animalDAO = new AnimalDAO();

    public static ArrayList<Object[]> listarAnimales() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Animal animal : animalDAO.listar()) {

            lista.add(new Object[]{
                animal.getIdAnimal(),
                animal.getNombre(),
                animal.getEspecie(),
                animal.getRaza(),
                animal.getEdad(),
                animal.getIdCliente()
            });
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarAnimales(String filtro) {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Animal animal : animalDAO.buscarAnimales(filtro)) {

            lista.add(new Object[]{
                animal.getIdAnimal(),
                animal.getNombre(),
                animal.getEspecie(),
                animal.getRaza(),
                animal.getEdad(),
                animal.getIdCliente()
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
}