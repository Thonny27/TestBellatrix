package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

public class DbUtil {

    public void insertLog(String type, String message) throws ClassNotFoundException, IOException {

        HashMap<String, String> dbParams = new HashMap();
        dbParams.put("driver", "com.mysql.cj.jdbc.Driver");
        dbParams.put("dbms", "mysql");
        dbParams.put("serverName", "localhost");
        dbParams.put("portNumber", "3306");
        dbParams.put("userName", "root");
        dbParams.put("password", "");
        dbParams.put("databaseName", "bellatrix");

        Class.forName(dbParams.get("driver"));

        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));

        try {

            Connection connection = DriverManager.getConnection("jdbc:"
                    + dbParams.get("dbms")
                    + "://" + dbParams.get("serverName")
                    + ":" + dbParams.get("portNumber")
                    + "/" + dbParams.get("databaseName"), connectionProps);

            Statement stmt = connection.createStatement();

            stmt.executeUpdate("insert into log(type, message) values('"+type+"', '"+message+"')");

        } catch (SQLException e) {
            new LogUtil().save(Level.SEVERE, e.getMessage());
        }

    }

}
