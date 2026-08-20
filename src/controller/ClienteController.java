package controller;

import dao.ClienteDAO;
import java.util.ArrayList;
import modelo.Cliente;
import factory.ModeloFactory;

public class ClienteController {

    private static final ClienteDAO clienteDAO = new ClienteDAO();

    public static ArrayList<Object[]> listarClientes() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Cliente cliente : clienteDAO.listar()) {

            lista.add(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getDni()
            });
        }

        return lista;
    }

    public static ArrayList<Object[]> buscarClientes(String filtro) {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Cliente cliente : clienteDAO.buscarClientes(filtro)) {

            lista.add(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getDni()
            });
        }

        return lista;
    }

    public static void eliminarCliente(int idCliente) {
        clienteDAO.eliminar(idCliente);
    }

    public static void guardarCliente(String nombre,
                                      String dni,
                                      int idCliente) {

        Cliente cliente = ModeloFactory.crearCliente(
                idCliente,
                nombre,
                dni
        );

        clienteDAO.guardar(cliente);
    }

    public static ArrayList<Object[]> listarClientesParaCombo() {

        ArrayList<Object[]> lista = new ArrayList<>();

        for (Cliente cliente : clienteDAO.listar()) {

            lista.add(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getDni()
            });
        }

        return lista;
    }

    public static Object[] obtenerClientePorId(int idCliente) {

        for (Cliente cliente : clienteDAO.listar()) {

            if (cliente.getIdCliente() == idCliente) {

                return new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNombre(),
                    cliente.getDni()
                };
            }
        }

        return null;
    }
}