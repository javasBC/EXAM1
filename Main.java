import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection c= null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:D:\\work\\JAVA SPRING\\DB\\studentClassDB.db");

            System.out.println("Opened database successfully");
            Statement statement= c.createStatement();
            System.out.println("here");
            ResultSet rs = statement.executeQuery("SELECT * FROM Students");
            System.out.println("here");

            while (rs.next()){
                int id=rs.getInt("Id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                Boolean vip=rs.getBoolean("vip");
                System.out.printf("["+id+" , "+name+" , "+age+" ]\n");
            }
            rs.close();
            statement.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Done");
    }
}
