package caesarCipher.util;
import java.io.*;

    /**
    *	Source: http://www.programcreek.com/2011/03/java-read-a-file-line-by-line-code-example/
    **/
public class FileProcessor{
	/**
	 * Construct a BufferedReader from the input file
	 * @param fileName the input file name, which contains lines of strings
	 */
	public FileProcessor(String fileName){
		try{
			File infile = new File(fileName);
			br = new BufferedReader(new FileReader(infile));
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();	
		}finally{

        }
	}

	/**
	 * @return retrieve a line from the input file specified in the constructor (null if eof)
	 * @exception e print error message and stack trace to stderr and then exit the program
	 */	
	public String readLineFromFile(){
		String retVal = null;
		try{
			retVal = br.readLine();
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally{

        }
		return retVal;
	}
	
	/**
	 * Close file/BufferedReader stream
	 */
	public void closeFile(){
		try{
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
            
        }
	}	
	private BufferedReader br;
}
