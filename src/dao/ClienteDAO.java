package dao;

import interfaces.CrudDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cliente;
import sistemaveterinaria.Conexion;

public class ClienteDAO implements CrudDAO<Cliente> {

    @Override
    public void guardar(Cliente cliente) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            boolean editando = (cliente.getIdCliente() != -1);

            if (editando) {

                String sql =
                        "UPDATE clientes SET nombre = ?, dni = ? WHERE id_cliente = ?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, cliente.getNombre());
                pst.setString(2, cliente.getDni());
                pst.setInt(3, cliente.getIdCliente());

                pst.executeUpdate();
                pst.close();

            } else {

                String sql =
                        "INSERT INTO clientes (nombre, dni) VALUES (?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, cliente.getNombre());
                pst.setString(2, cliente.getDni());

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
    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql = "SELECT * FROM clientes";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("dni")
                );

                lista.add(cliente);
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
    public void eliminar(int idCliente) {

        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "DELETE FROM clientes WHERE id_cliente = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idCliente);
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

    public ArrayList<Cliente> buscarClientes(String filtro) {

        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conn = null;

        try {

            conn = Conexion.getInstancia().conectar();

            String sql =
                    "SELECT * FROM clientes WHERE nombre LIKE ? OR dni LIKE ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + filtro + "%");
            pst.setString(2, "%" + filtro + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("dni")
                );

                lista.add(cliente);
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