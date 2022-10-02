package org.example.util;

import java.io.*;

public class FileUtil {

    public static String getFileContent(final File file) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        final StringBuilder text = new StringBuilder();

        String line = bufferedReader.readLine();
        while (line != null) {
            for (char c : line.toCharArray()) {
                text.append(c);
            }

            line = bufferedReader.readLine();
        }

        return text.toString();
    }

}
