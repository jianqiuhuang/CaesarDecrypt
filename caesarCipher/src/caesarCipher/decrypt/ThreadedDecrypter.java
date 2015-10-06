package caesarCipher.decrypt;

import java.util.*;
import caesarCipher.util.*;
import caesarCipher.store.*;
import caesarCipher.util.Logger.DebugLevel;

public class ThreadedDecrypter implements Runnable  {
    private FileProcessor infile;
    private int threadNumber;
    private CaesarDecrypt decrypter;
    private DecodedStore store;
    private int shiftValue;

    public ThreadedDecrypter(FileProcessor fileStream, int num, CaesarDecrypt decrypter, DecodedStore store, int shiftValue){
        this.infile = fileStream;
        this.threadNumber = num;
        this.store = store;
        this.decrypter = decrypter;
        this.shiftValue = shiftValue;
    }

    /**
     * Read a line from input file stream
     * Decode the line
     * Add the decoded string to DecodedStore
     */ 
    public void run() {
        try{
            Logger.writeMessage("run() called", DebugLevel.THREAD_RUN);
            //reading need to be thread-safe
            String line;
            while((line = this.infile.readLineFromFile()) != null){
                String output = decrypter.decode(line, this.shiftValue);
                //System.out.println(threadNumber + ": " + line "---" + output);
                store.addLine(output);
                Logger.writeMessage("Entry added to results data structure", DebugLevel.ADD_RESULT);
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
    
    public String toString(){
        return "In ThreadedDecrypter, thread number is " + Integer.toString(threadNumber) + ", shift value is " + Integer.toString(shiftValue);
    }
}
