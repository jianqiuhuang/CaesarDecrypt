package caesarCipher.store;

import java.util.*;
import caesarCipher.decrypt.*;
import caesarCipher.util.*;
import caesarCipher.util.Logger.DebugLevel;
public class DecodedStore implements DisplayI {
    private Vector<String> result;
   
    /**
     * Initialize vector in constructor
     */ 
    public DecodedStore(){
        result = new Vector<String>(); 
    }
    
     /**
      * Adding a line of decoded string to class data structure
      */
    public synchronized void addLine(String line){
        try{
            result.addElement(line);
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * Write data stored in data structure to output file stream
     */   
    public void writeToFile(FileProcessor fileStream) {
	    for(int i = 0; i < this.result.size(); i++){
            fileStream.writeLineToFile(result.elementAt(i));
        }
    }

    /**
     * @return
     */
    public String toString(){
        String result = "";
        for(int i = 0; i < this.result.size(); i++){
            result += this.result.elementAt(i) + ", ";
        }
        return "Result data structure contains: " + result; 
    }
} 


