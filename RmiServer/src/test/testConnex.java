package test;

import com.server.entities.impl.Product;
import com.server.utils.Database;
import com.server.utils.PostgresDataSource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testConnex {
    public static void main(String[] args) throws ParseException {
        String hostname = "localhost";
        String dbName = "rmidb";
        String user = "postgres";
        String pwd = "";

        PostgresDataSource postgresDataSource = new PostgresDataSource(
                hostname, dbName, user, pwd);

        Database database = new Database(postgresDataSource);

        //List<String> tables = new ArrayList<>();
        //String[][] products = database.select("product");

        database.delete("product", "idProduct", 13);

        //System.out.println("query: " + database.select("product"));




        //database.insert("product",  product);
        //System.out.println("product: " + product.toString());

        /*for (int i=0; i<database.getTableNames().length; i++){
            tables.add(database.getTableNames()[i]);
            System.out.println("name: " + tables.get(i));
        }*/
    }

}
