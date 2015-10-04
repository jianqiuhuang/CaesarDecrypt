package caesarCipher.decrypt;

public class CaesarDecrypt implements CaesarCipherI {
  
    /**
     * @param line cipher text stored in a string
     * @param shiftValue number of character position to shift
     * @return decoded string 
     */ 
    public synchronized String decode(String line, int shiftValue){
        String result = "";
        //Require decode implementation
        for(int i = 0; i < line.length(); i++){
            boolean lowerCase = false;
            int tmp = (int)line.charAt(i);
            //upper case
            if(tmp <= 90 && tmp >= 65){ 
                lowerCase = false;
            //lower case
            }else if(tmp <= 122 && tmp >= 90){
                lowerCase = true;
            }else{
                System.err.println("input file contains non-alphebaticall character");
                System.exit(1);
            }
            tmp += shiftValue;
            if(lowerCase){
                if(tmp > 122)
                    tmp -= 26;
            }else{
                if(tmp > 90)
                    tmp -= 26;
            }
            result += (char)tmp;
        }
        return result;
    }
   
    /**
     * @return 
     */ 
    public String toString(){
        return "";
    }
}
