package br.edu.ifpe.FormularioDeCadastro.logs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogMensagem implements ILog {

    private File file = new File("src\\logs\\LOG.txt");
    private FileWriter fw;
    private BufferedWriter bw;

    public LogMensagem() {
        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void log(String message) {
        try {
            bw.write(message);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            return;
        }
    }

    public void closer() {
        try {
            bw.close();
        } catch (IOException e) {
            return;
        }
    }
}
