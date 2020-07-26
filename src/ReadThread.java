import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class ReadThread implements Runnable{

    protected BlockingQueue<String> blockingQueue = null;

    public ReadThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("e:\\My SQL standard examples\\Antra_training\\Java\\day_04\\input.txt")));
            String buffer =null;
            while((buffer=br.readLine())!=null){
                String bufferTmp = buffer.replace(" ", "");
                String[] numTmp = bufferTmp.split("[+-]");
                if(numTmp.length <= 1){
                    blockingQueue.put(buffer);
                } else {
                    String opeTmp = buffer.replaceAll("[\\s\\d]", "");
                    int result = Integer.parseInt(numTmp[0]);
                    int p = 1;
                    for (char x : opeTmp.toCharArray()) {
                        if (x == '+') {
                            result += Integer.parseInt(numTmp[p]);
                        } else if (x == '-') {
                            result -= Integer.parseInt(numTmp[p]);
                        }
                        p++;
                    }
                    String num_buffer = buffer + " = " + Integer.toString(result);
                    blockingQueue.put(num_buffer);
                }
            }
            blockingQueue.put("EOF");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch(InterruptedException e){

        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}