
package caesarCipher.util;

public class Logger{


    public static enum DebugLevel { NO_OUTPUT, RESULT_CONTENT, ADD_RESULT, THREAD_RUN, CONSTRUCTOR };

    private static DebugLevel debugLevel;

    /**
     * Set debug level value
     */ 
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
          case 0: debugLevel = DebugLevel.NO_OUTPUT; break;
          case 1: debugLevel = DebugLevel.RESULT_CONTENT; break;
          case 2: debugLevel = DebugLevel.ADD_RESULT; break;
          case 3: debugLevel = DebugLevel.THREAD_RUN; break; 
          case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
          default: System.err.println("Debug value must be from 0-4");
        }
    }

    /**
     * Set debug level value
     */
    public static void setDebugValue (DebugLevel levelIn) {
	    debugLevel = levelIn;
    }

    /**
     * Print debugging message based on debug level
     */
    public static void writeMessage (String message, DebugLevel levelIn ) {
	    if (levelIn == debugLevel)
	        System.out.println(message);
    }

    /**
     * @return debug level
     */
    public String toString() {
	    return "Debug Level is " + debugLevel;
    }
}
