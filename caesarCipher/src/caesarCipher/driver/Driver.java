
package caesarCipher.driver;

import caesarCipher.util.FileProcessor.java;
public class Driver{
    /**
     * Used to output error message made by invalid command line argument and then exit the program
     */
    public static void usage(){
        System.out.println("Usage: ant -buildfile src/build.xml run <input-file-name> <output-file-name> <shift-value> <number-of-threads> <debug-level> \n"
                + "number-of-trhreads: 1-5\n"
                + "debug-level: 0-4");
        System.exit(1);
    }
	public static void main(String args[]) {
        //Parsing command line arguments
        if(args.length != 5){
            usage();
        }
        String inputFileName = args[0], outputFileName = args[1];
        int shiftValue = 0, numberOfThreads = 0, debugValue = 0;
        //Parsing integers
        try{
            shiftValue = Integer.parseInt(args[2]);
            numberOfThreads = Integer.parseInt(args[3]);
            debugValue = Integer.parseInt(args[4]);
        }catch(Exception e){
            System.err.println("<shift-value>, <number-of-threads>, and <debug-level> must be integers");
            e.printStackTrace();
            System.exit(1);
        }finally{

        }
        //Check value boundaries
        if(numberOfThreads < 1 || numberOfThreads > 5){
            System.err.println("<number-of-threads> must be in the range of 1-5");
            usage();
        }
        if(debugValue < 0 || debugValue > 4){
            System.err.println("<debug-level> must be in the range of 0-4");
            usage();
        }

        /******************/
        FileProcessor infile = new FileProcessor(inputFileName);


        infile.closeFile();
        

	} // end main(...)

} // end public class Driver

