package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogUtil {

    private static Logger logger = Logger.getLogger("MyLog");

    public void save(Level level, String message) throws IOException {

        LogManager.getLogManager().readConfiguration(
                this.getClass().getClassLoader().getResourceAsStream("logging.properties"));

        logger.log(level, message.trim());

    }

}
