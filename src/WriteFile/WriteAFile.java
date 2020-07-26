package WriteFile;

import java.io.*;
import java.util.Random;

public class WriteAFile {
    public static void write(String s, File file) throws IOException {
        Writer fileWriter = new FileWriter(file, false);
        fileWriter.write(s);
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Random rd = new Random();
        Writer writer = null;
        try {
            writer = new FileWriter(new File("c:\\Users\\pan\\Desktop\\form99.txt"), false);
            for(int i = 0; i < 30; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    int num1 = rd.nextInt(10 - 8) + 8;
                    int num2 = rd.nextInt(9);
                    sb.append(num1 + " x " + num2 + " =     ");
                }
                sb.append("\n");
                writer.write(sb.toString());
                writer.write("  \n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            writer.close();
        }

    }
}
