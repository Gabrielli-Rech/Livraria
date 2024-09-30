package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
        private static String host = "jdbc:mysql://localhost:3306/mundodoslivros";
    private static String user = "root";
    private static String pass = "";

    public static Connection getConexao() throws SQLException {
        Connection c = null;
        try {
            c = DriverManager.getConnection(host, user, pass);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar\n" + e.getMessage());
        }
        return c;
    }

    public static void executar(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executar'");
    }

    public static ResultSet consultar(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }
}
