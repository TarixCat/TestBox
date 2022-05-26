package me.devtarix.TestBox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataCSVOutput {
    public File fileout;
    public FileWriter writer;
    private String FILENAME;

    public DataCSVOutput() {

        FILENAME = "test.csv";
        fileout = new File(FILENAME);
        try {
            boolean v = fileout.createNewFile();
            if (v) {
                Main.print("File created.");
            } else {
                Main.print("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        createWriter();
    }

    public void createWriter() {
        try {
            writer = new FileWriter(FILENAME);
            writer.write("lvalue,xvalue\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void writeToFile(String msg) {
        try {
            writer.write(msg);
        } catch (IOException e) {
            Main.print("Error writing to file: " + e.getMessage());
        }
    }

    public void closeFile() {
        try {
            writer.close();
            Main.print("Closed writer.");
        } catch (IOException e) {
            Main.print("You should never see this: " + e.getMessage());
        }
    }
}
