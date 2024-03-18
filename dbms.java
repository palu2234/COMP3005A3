import java.sql.*;

public class dbms {
    public String url = "jdbc:postgresql://localhost:5432/assignment3";
    public String user = "postgres";
    public String password = "postgres";

    public Connection connection;

    public dbms() {
        connection = connect();
    }

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database");
                return connection;
            } else {
                System.out.println("Failed to make connection");
                return null;
            }
        }
        catch(Exception e){
            return null;
        }
    }

    public void getAllStudents() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeQuery("select * from students");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("student_id") + "\t" + resultSet.getString("first_name") + "\t" + resultSet.getString("last_name") + "\t" + resultSet.getString("email") + "\t" + resultSet.getString("enrollment_date"));
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate("insert into students (first_name, last_name, email, enrollment_date) values ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')");
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(int id) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate("delete from students where student_id = " + id);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void updateStudentEmail(int id, String email) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate("update students set email = '" + email + "' where student_id = " + id);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }


}
