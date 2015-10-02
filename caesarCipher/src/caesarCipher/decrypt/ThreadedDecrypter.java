package caesarCipher.decrypt;

import java.util.*;
import caesarCipher.util.*;

public class ThreadedDecrypter implements Runnable  {
    private FileProcessor infile;
    private int threadNumber;
    public ThreadedDecrypter(FileProcessor fileStream, int num){
        this.infile = fileStream;
        this.threadNumber = num;
    }

    public void run() {
        try{
            //reading need to be thread-safe
            String line;
            while((line = this.infile.readLineFromFile()) != null){
                CaesarDecrypt decrypt = new CaesarDecrypt();
                String output = decrypt.decode(line);
                System.out.println(this.threadNumber + ", " + line);
                Thread.sleep(1000);
            }
            /**Create an instance of CaesarDecrypt and call decode to obtain the decoded string
             * Create an instance of DecodedStore and call store method inserts the string to its data structure
             */
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{

        }   
    }
    

}
