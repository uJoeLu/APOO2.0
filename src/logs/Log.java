package logs;

import java.io.IOException;

public interface Log {
    void log(String message) throws IOException;
}
