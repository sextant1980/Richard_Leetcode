package WriteFile;

import java.io.*;

public class BufferReaderCountLineWord {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\Users\\pan\\Desktop\\tmp.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int lineNum = 0;
        int charNum = 0;
        int wordNum = 0;

        String line;
        while((line = bufferedReader.readLine()) != null) {
            charNum += line.length();
            String[] wordArray = line.split("\\s+");
            wordNum += wordArray.length;
            lineNum++;
        }

        System.out.println("total line number is: " + lineNum);
        System.out.println("total character is: " + charNum);
        System.out.println("total word number is: " + wordNum);
    }
}
