package caesarCipher.decrypt;

import java.util.*;
import caesarCipher.util.*;
import caesarCipher.store.*;
import caesarCipher.util.Logger.DebugLevel;

public class CreateWorkers  {

    /**
     * @param numberOfWorkers number of threads to initiate
     * @param infile input file stream
     * @param decrypter decrypt object
     * @param store object that store decode string
     * @param shiftValue # of shift position for decryption
     * @param logger debugging object
     **/
    public void startWorkers(int numberOfWorkers, FileProcessor infile, CaesarDecrypt decrypter, DecodedStore store, int shiftValue){
        //Store all initialized threads
        Vector<Thread> threadContainer = new Vector();
        
        try{
            for(int i = 0; i < numberOfWorkers; i++){
                ThreadedDecrypter obj = new ThreadedDecrypter(infile, i, decrypter, store, shiftValue);
                Logger.writeMessage("ThreadedDecrypter constructor called", DebugLevel.CONSTRUCTOR); 
                Thread newThread = new Thread(obj);
                Logger.writeMessage("Thread constructor called", DebugLevel.CONSTRUCTOR);
                threadContainer.addElement(newThread);
               // System.out.println("Thread #" + i + " created");
                newThread.start();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally{

        }

        //Join all threads before exiting
        try{
            for(int i = 0; i < numberOfWorkers; i++){
                threadContainer.get(i).join();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally{

        }    
    }

    /**
     * @return
     */
    public String toString(){
        return "";
    }
}
