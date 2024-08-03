package logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogMensagem implements Log {

    @Override
    public void log(String message) throws IOException {
        try {
            File file = new File("src\\logs\\LOG.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(message);
            bw.newLine();
            bw.flush();

        }catch(IOException e){
            throw new IOException("Erro a gerar log");
        }
    }
}
