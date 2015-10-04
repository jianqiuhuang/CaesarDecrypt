package caesarCipher.decrypt;

import java.util.*;

public interface CaesarCipherI {


    /**
     ** @param line cipher text stored in a string
     ** @param shiftValue number of character position to shift
     ** @return decoded string
     **/
    public String decode(String line, int shiftValue); 
}
