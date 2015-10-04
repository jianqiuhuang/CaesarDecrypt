package caesarCipher.store;

import caesarCipher.util.*;
public interface DisplayI {
    // add appropriate method
    /**
     * Adding a line of decoded string to class data structure
     */
    public void addLine(String line);

    /**
     * Write data stored in data structure to output file stream
     */
    public void writeToFile(FileProcessor fileStream);

} 
