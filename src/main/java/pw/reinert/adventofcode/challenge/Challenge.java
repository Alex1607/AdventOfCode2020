package pw.reinert.adventofcode.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
