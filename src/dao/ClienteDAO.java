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

            boolean editando =
                    cliente.getIdCliente() != -1;

            if (editando) {
                String sql =
                        "UPDATE clientes SET "
                        + "nombre = ?, "
                        + "dni = ?, "
                        + "telefono = ?, "
                        + "direccion = ?, "
                        + "correo = ?, "
                        + "observaciones = ? "
                        + "WHERE id_cliente = ?";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, cliente.getNombre());
                pst.setString(2, cliente.getDni());
                pst.setString(3, cliente.getTelefono());
                pst.setString(4, cliente.getDireccion());
                pst.setString(5, cliente.getCorreo());
                pst.setString(6, cliente.getObservaciones());
                pst.setInt(7, cliente.getIdCliente());

                pst.executeUpdate();
                pst.close();

            } else {
                String sql =
                        "INSERT INTO clientes "
                        + "(nombre, dni, telefono, direccion, correo, observaciones) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement pst =
                        conn.prepareStatement(sql);

                pst.setString(1, cliente.getNombre());
                pst.setString(2, cliente.getDni());
                pst.setString(3, cliente.getTelefono());
                pst.setString(4, cliente.getDireccion());
                pst.setString(5, cliente.getCorreo());
                pst.setString(6, cliente.getObservaciones());

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

            asegurarColumnaActivo(
                    conn
            );

            String sql =
                    "SELECT * FROM clientes "
                    + "WHERE activo = 1";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("correo"),
                        rs.getString("observaciones")
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
            asegurarColumnaActivo(
                    conn
            );
            String sql =
                    "UPDATE clientes "
                    + "SET activo = 0 "
                    + "WHERE id_cliente = ?";

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
            
            asegurarColumnaActivo(
                    conn
            );

            String sql =
                    "SELECT * FROM clientes "
                    + "WHERE activo = 1 "
                    + "AND (nombre LIKE ? OR dni LIKE ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "%" + filtro + "%");
            pst.setString(2, "%" + filtro + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("correo"),
                        rs.getString("observaciones")
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
   
    private void asegurarColumnaActivo(
            Connection conn
    ) throws Exception {

        boolean existeColumna = false;

        PreparedStatement pstConsultar =
                conn.prepareStatement(
                        "PRAGMA table_info(clientes)"
                );

        ResultSet rs =
                pstConsultar.executeQuery();

        while (rs.next()) {

            if ("activo".equalsIgnoreCase(
                    rs.getString("name")
            )) {

                existeColumna = true;
                break;
            }
        }

        rs.close();
        pstConsultar.close();

        if (!existeColumna) {

            PreparedStatement pstCrear =
                    conn.prepareStatement(
                            "ALTER TABLE clientes "
                            + "ADD COLUMN activo "
                            + "INTEGER NOT NULL DEFAULT 1"
                    );

            pstCrear.executeUpdate();
            pstCrear.close();
        }
    }
    public ArrayList<Cliente> listarInactivos() {

        ArrayList<Cliente> lista =
                new ArrayList<>();

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            asegurarColumnaActivo(
                    conn
            );

            String sql =
                    "SELECT * FROM clientes "
                    + "WHERE activo = 0 "
                    + "ORDER BY nombre";

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sql);

                    ResultSet rs =
                            pst.executeQuery()
            ) {

                while (rs.next()) {

                    Cliente cliente =
                            new Cliente(
                                    rs.getInt("id_cliente"),
                                    rs.getString("nombre"),
                                    rs.getString("dni"),
                                    rs.getString("telefono"),
                                    rs.getString("direccion"),
                                    rs.getString("correo"),
                                    rs.getString("observaciones")
                            );

                    cliente.setActivo(false);

                    lista.add(
                            cliente
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar clientes inactivos: "
                    + e.getMessage()
            );
        }

        return lista;
    }
    public boolean reactivar(
            int idCliente
    ) {

        String sql =
                "UPDATE clientes "
                + "SET activo = 1 "
                + "WHERE id_cliente = ? "
                + "AND activo = 0";

        try (
                Connection conn =
                        Conexion.getInstancia().conectar()
        ) {

            asegurarColumnaActivo(
                    conn
            );

            try (
                    PreparedStatement pst =
                            conn.prepareStatement(sql)
            ) {

                pst.setInt(
                        1,
                        idCliente
                );

                return pst.executeUpdate() > 0;
            }

        } catch (Exception e) {

            System.out.println(
                    "Error al reactivar el cliente: "
                    + e.getMessage()
            );

            return false;
        }
    }
}