package pw.reinert.adventofcode.challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class Challenge {

    private String id;
    private File data;

    protected Challenge(String id, File data) {
        this.id = id;
        this.data = data;
    }

    public abstract void run();

    public String getId() {
        return id;
    }

    public File getData() {
        return data;
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public Stream<String> getStream() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(data));
            return bufferedReader.lines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
