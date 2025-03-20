package br.com.odontoprev.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@Service
public class TipoPlanoOdontologicoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Método para inserir um novo plano odontológico
    public void insertTipoPlanoOdontologico(int id, String nome, String numero, String tipo, double preco, Date carenciaDias, Date validadeDias) {
        String sql = "{call sp_insert_tipo_plano_odontologico(?, ?, ?, ?, ?, ?, ?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id);
                stmt.setString(2, nome);
                stmt.setString(3, numero);
                stmt.setString(4, tipo);
                stmt.setDouble(5, preco);
                stmt.setDate(6, carenciaDias);
                stmt.setDate(7, validadeDias);

                stmt.execute();
                System.out.println("Insert realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar insert: " + e.getMessage());
            }
            return null;
        });
    }

    // Método para atualizar um plano odontológico existente
    public void updateTipoPlanoOdontologico(int id, String nome, String numero, String tipo, double preco, Date carenciaDias, Date validadeDias) {
        String sql = "{call sp_update_tipo_plano_odontologico(?, ?, ?, ?, ?, ?, ?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id); // ID do registro a ser atualizado
                stmt.setString(2, nome);
                stmt.setString(3, numero);
                stmt.setString(4, tipo);
                stmt.setDouble(5, preco);
                stmt.setDate(6, carenciaDias);
                stmt.setDate(7, validadeDias);

                stmt.executeUpdate();
                System.out.println("Update realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar update: " + e.getMessage());
            }
            return null;
        });
    }

    // Método para deletar um plano odontológico existente
    public void deleteTipoPlanoOdontologico(int id) {
        String sql = "{call sp_delete_tipo_plano_odontologico(?)}";

        jdbcTemplate.execute((Connection connection) -> {
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, id); // ID do registro a ser deletado

                stmt.execute();
                System.out.println("Delete realizado com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao executar delete: " + e.getMessage());
            }
            return null;
        });
    }

    // Método de demonstração para execução das operações CRUD
    public void insertDatabase() {
        // Exemplo de INSERT
        insertTipoPlanoOdontologico(1, "Plano Básico", "PL123", "Odontológico", 99.99, Date.valueOf("2023-01-01"), Date.valueOf("2024-01-01"));
        insertTipoPlanoOdontologico(2, "Plano Avançado", "PL456", "Odontológico", 149.99, Date.valueOf("2023-01-01"), Date.valueOf("2024-01-01"));
    }
    public void updateDatabase() {
        // Exemplo de UPDATE
        updateTipoPlanoOdontologico(1, "Plano Básico Atualizado", "PL789", "Odontológico", 109.99, Date.valueOf("2023-01-01"), Date.valueOf("2024-01-01"));
        updateTipoPlanoOdontologico(2, "Plano Avançado Atualizado", "PL987", "Odontológico", 159.99, Date.valueOf("2023-01-01"), Date.valueOf("2024-01-01"));

    }
    public void deleteDatabase() {

        // Exemplo de DELETE
        deleteTipoPlanoOdontologico(1);
        deleteTipoPlanoOdontologico(2);
    }
}
