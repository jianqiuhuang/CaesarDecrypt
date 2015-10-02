package caesarCipher.decrypt;

import java.util.*;
import caesarCipher.util.*;

public class CreateWorkers  {

    // this class has the method startWokers(...)
    public void startWorkers(int numberOfWorkers, FileProcessor infile){
        //Store all initialized threads
        Vector<Thread> threadContainer = new Vector();
        
        try{
            for(int i = 0; i < numberOfWorkers; i++){
                ThreadedDecrypter obj = new ThreadedDecrypter(infile, i);
                Thread newThread = new Thread(obj);
                threadContainer.addElement(newThread);
                System.out.println("Thread #" + i + " created");
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
}
