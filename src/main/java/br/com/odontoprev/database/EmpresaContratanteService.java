package br.com.odontoprev.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class EmpresaContratanteService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para inserir uma nova empresa contratante
    public void insertEmpresaContratante(int id, String nomeEmpresa, String cnpj, int numeroContrato) {
        String sql = "{call sp_insert_empresa_contratante(?, ?, ?, ?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id);
                stmt.setString(2, nomeEmpresa);
                stmt.setString(3, cnpj);
                stmt.setInt(4, numeroContrato);

                stmt.execute();
                System.out.println("Insert de empresa contratante realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar insert: " + e.getMessage());
            }
            return null;
        });
    }

    // Método para atualizar uma empresa contratante existente
    public void updateEmpresaContratante(int id, String nomeEmpresa, String cnpj, int numeroContrato) {
        String sql = "{call sp_update_empresa_contratante(?, ?, ?, ?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id); // ID do registro a ser atualizado
                stmt.setString(2, nomeEmpresa);
                stmt.setString(3, cnpj);
                stmt.setInt(4, numeroContrato);

                stmt.executeUpdate();
                System.out.println("Update de empresa contratante realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar update: " + e.getMessage());
            }
            return null;
        });
    }

    // Método para deletar uma empresa contratante existente
    public void deleteEmpresaContratante(int id) {
        String sql = "{call sp_delete_empresa_contratante(?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id); // ID do registro a ser deletado

                stmt.execute();
                System.out.println("Delete de empresa contratante realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar delete: " + e.getMessage());
            }
            return null;
        });
    }

    // Método de demonstração para execução das operações CRUD
    public void insertEmpresa() {
        // Exemplo de INSERT
        insertEmpresaContratante(1, "Empresa X", "12345678000100", 1001);
        insertEmpresaContratante(2, "Empresa Y", "98765432000199", 1002);
    }

    public void updateEmpresa() {

        // Exemplo de UPDATE
        updateEmpresaContratante(1, "Empresa X Atualizada", "12345678000100", 1003);
        updateEmpresaContratante(2, "Empresa Y Atualizada", "98765432000199", 1004);
    }

    public void deleteEmpresa() {

        // Exemplo de DELETE
        deleteEmpresaContratante(1);
        deleteEmpresaContratante(2);
    }
}

