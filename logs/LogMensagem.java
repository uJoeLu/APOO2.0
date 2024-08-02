package logs;

import java.util.logging.Logger;

public class LogMensagem implements Log{
    private static final Logger logger = Logger.getLogger(LogMensagem.class.getName());


    @Override
    public void log(String message) {
        logger.info(message);
    }
    
}
