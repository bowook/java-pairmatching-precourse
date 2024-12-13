package pairmatching.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pairmatching.exception.ErrorMessage;

public class FileLoader {

    public static List<String> fileReadLine(String fileName) throws IOException {
        List<String> items = new ArrayList<>();
        BufferedReader bufferedReader = loadFile(fileName);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            items.add(line);
        }
        return items;
    }

    private static BufferedReader loadFile(String fileName) {
        InputStream inputStream = FileLoader.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException(ErrorMessage.FILE_ERROR.getMessage());
        }
        return new BufferedReader(new InputStreamReader(inputStream));
    }

}