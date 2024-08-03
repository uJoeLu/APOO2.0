package logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogMensagem implements Log {
    
    private File file = new File("src\\logs\\LOG.txt");
    private FileWriter fw;
    private BufferedWriter bw;

    public LogMensagem() throws IOException{
        fw = new FileWriter(file, true);
        bw = new BufferedWriter(fw);
    }

    @Override
    public void log(String message) throws IOException {
        bw.write(message);
        bw.newLine();
        bw.flush();
    }
    public void closer() throws IOException{
        bw.close();
    }
}
