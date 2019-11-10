
package SelectUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectUser {


    public static void main(String[] args) {
      
          // Getting string inputs:
        System.out.println("Please enter your first name:");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter UserId:");
        String userId = scanner.nextLine();

        String connectionUrl =
            "jdbc:sqlserver://localhost;databaseName=UsersDb;username=sa;password=w/XhNgY#2R";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection databaseConnection = DriverManager.getConnection(connectionUrl);

            Statement sqlStatement = databaseConnection.createStatement();

            ResultSet resultSet = null;

            String queryString =
                    "SELECT * FROM USERS WHERE firstName = "
                    + "'" + firstName + "' AND lastName = '" + lastName + "' AND UserId = '" + userId;
      
            resultSet = sqlStatement.executeQuery(queryString);

            // Print results from select statement:
            while (resultSet.next()) {
                System.out.println(" firstName: " + resultSet.getString(2) + " lastName:  " + resultSet.getString(3));
            }

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}