import util.DbUtil;
import util.LogUtil;

import java.io.IOException;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        new LogUtil().save(Level.INFO, "logeando info...");

        new LogUtil().save(Level.WARNING, "codigo en prueba");

        new DbUtil().insertLog(Level.INFO.toString(), "logeando in db2");

    }

}
