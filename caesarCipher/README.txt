CS442 Design Patterns
Fall 2015
ASSIGNMENT NO.2 README FILE

Due Date: OCTOBER 8, 2015
Submission Date: OCTOBER 8, 2015
Grace Period Used This Project: Seven days
Grace Period Remaining: Seven days
Author(s): JIANQIU HUANG AND BRANDON FOO
e-mail(s): JHUANG86@BINGHAMTON.EDU AND ...


PURPOSE:

  This program is designed to decrypt Cipher text from input file using multi-threading approach
  All shared resources are synchronized using the Java modifier "synchronized"
  We choose vector as the data structure to store decoded strings because vector in Java is thread-safe. However, since the addLine method in DecodedStore is  Synchronized, it is also reasonable to use a non-thread-safe data structure like ArrayList. But, considering the scalability of the program in future use, 
  we think a vector is more appropriate when working with multi-threading programs
  Input and output file need be located in the top directory which is the same directory as this README text file

PERCENT COMPLETE:

  The assignment is fully completed; however, the decoded strings are not written in order as the input string file

PARTS THAT ARE NOT COMPLETE:

  N/A

BUGS:

  Strings in the output file are not in-order as the input file string due to multi-threading

FILES:
    
  README.txt, the text file you are presently reading
  
  build.xml, ANT script use to compile and run the program
  CaesarCipherI.java, interface that contains decryption method signiture
  CaesarDecrypt.java, class contains decryption method implementation
  CreateWorkers.java, class contains method to initialize multiple threads
  ThreadedDecrypter.java, class implements runnable and contains the run method for thread execution
  Driver.java, main file associated with the program that contains main 
  DisplayI.java, interface that contains writeToFile method signiture
  DecodedStore.java, class that stores the decode strings and contains method to write to file
  FileProcessor.java, file responsible for retrieving data from an input text file
  Logger.java, class that responsible for printing debugging statements

SAMPLE OUTPUT:

  Sample run with shiftValue = 10, number of threads = 5, debug level = 4:

  remote00:~/designPatterns/assignment2/CaesarDecrypt/caesarCipher> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=yourOutput.txt -Darg2=10 -Darg3=  5 -Darg4=4
  Buildfile: /import/linux/home/jhuang86/designPatterns/assignment2/CaesarDecrypt/caesarCipher/src/build.xml

  jar:

  run:
     [java] FileProcessor constructor called
     [java] FileProcessor constructor called
     [java] CreatedWorkers constructor called
     [java] CaesarDecrypt constructor called
     [java] DecodedStore constructor called
     [java] ThreadedDecrypter constructor called
     [java] Thread constructor called
     [java] ThreadedDecrypter constructor called
     [java] Thread constructor called
     [java] ThreadedDecrypter constructor called
     [java] Thread constructor called
     [java] ThreadedDecrypter constructor called
     [java] Thread constructor called
     [java] ThreadedDecrypter constructor called
     [java] Thread constructor called

  Output file contains:

  remote00:~/designPatterns/assignment2/CaesarDecrypt/caesarCipher> cat yourOutput.txt                                                                         iHRvvQCsiK
  fcqkUNsxXE
  ucplruRtSF
  SZTprhdfwP
  PqzpYWHZFe
  qnYmtlBvoi
  yfevpIDSCN
  PhodEJEqZu
  MgyRgzooma
  GycAcKwBbA

TO COMPILE:
    
  ant -buildfile src/build.xml all

TO RUN:
  Run with command line arguments:
   ********Note: must modify run in build.xml to the following format***********
   
    <target name="run" depends="jar">
        <java jar="${BUILD}/jar/caesarCipher.jar"  fork="true">
            <arg value="${arg0}"/>
            <arg value="${arg1}"/>
            <arg value="${arg2}"/>
            <arg value="${arg3}"/>
            <arg value="${arg4}"/>
        </java>

    </target>

  *************Then run the following command in terminal********************

    ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=secondarg -Darg2=thirdarg -Darg3=fourtharg -Darg4=fiftharg

  Run without comand line arguments:
  ********Note: must modify run in build.xml to the following format***********
  <target name="run" depends="jar">
        <java jar="${BUILD}/jar/caesarCipher.jar"  fork="true">
            <arg value="firstarg"/>
            <arg value="secondarg"/>
            <arg value="$thirdarg"/>
            <arg value="$fourtharg"/>
            <arg value="$fiftharg"/>
        </java>
  </target>

  *************Then run the following command in terminal********************

    ant -buildfile src/build.xml run 

Additional useful ANT commands:

## To clean:
ant -buildfile src/build.xml clean

## To run by specifying args in build.xml
ant -buildfile src/build.xml run b

## To create tarball for submission
ant -buildfile src/build.xml tarzip

    
EXTRA CREDIT:

  N/A

BIBLIOGRAPHY:

  N/A

ACKNOWLEDGEMENT:

  During the coding process one or more of the following people may have been consulted. Their help is greatly appreciated

  Madhu Govindaraju
  Brandon Foo
