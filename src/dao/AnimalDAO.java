package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Animal;
import sistemaveterinaria.Conexion;

public class AnimalDAO implements CrudDAO<Animal> {

    @Override
    public void guardar(Animal animal) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (animal.getIdAnimal() != -1);

            if (editando) {

                String sql =
                        "UPDATE animales SET nombre = ?, especie = ?, raza = ?, edad = ?, id_cliente = ? WHERE id_animal = ?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, animal.getNombre());
                pst.setString(2, animal.getEspecie());
                pst.setString(3, animal.getRaza());
                pst.setInt(4, animal.getEdad());
                pst.setInt(5, animal.getIdCliente());
                pst.setInt(6, animal.getIdAnimal());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO animales (nombre, especie, raza, edad, id_cliente) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, animal.getNombre());
                pst.setString(2, animal.getEspecie());
                pst.setString(3, animal.getRaza());
                pst.setInt(4, animal.getEdad());
                pst.setInt(5, animal.getIdCliente());

                pst.executeUpdate();
                pst.close();
            }

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Animal> listar() {

        ArrayList<Animal> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = "SELECT * FROM animales";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal(
                        rs.getInt("id_animal"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getInt("id_cliente")
                );

                lista.add(animal);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    @Override
    public void eliminar(int idAnimal) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "DELETE FROM animales WHERE id_animal = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idAnimal);
            pst.executeUpdate();

            pst.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Animal> buscarAnimales(String filtro) {

        ArrayList<Animal> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT * FROM animales "
                    + "WHERE nombre LIKE ? "
                    + "OR especie LIKE ? "
                    + "OR raza LIKE ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + filtro + "%");
            pst.setString(2, "%" + filtro + "%");
            pst.setString(3, "%" + filtro + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal(
                        rs.getInt("id_animal"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getInt("id_cliente")
                );

                lista.add(animal);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}