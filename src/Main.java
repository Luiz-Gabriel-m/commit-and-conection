import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String url = "jdbc:mysql://localhost:3306/deverdecasa";
        String user = "root";
        String password = "euamoaheloa";

        try {

            Connection conexao = DriverManager.getConnection(url, user, password);

            System.out.println("teste");

            Statement statement = conexao.createStatement();
            String comando = "Select * from cliente order by Nome;";

            ResultSet resultado = statement.executeQuery(comando);
            while (resultado.next()) {
                System.out.println("Id_cliente:" + resultado.getString("codigo") + " ");
                System.out.println("Nome:" + resultado.getString("nome"));
                System.out.println("Telefone: " + resultado.getString("idade"));
                System.out.println("Endereço: " + resultado.getString("peso"));
            }

        } catch(SQLException erro) {
            System.out.println("Ocorrreu o seguinte erro: " + erro.getMessage());
        }

    }
}