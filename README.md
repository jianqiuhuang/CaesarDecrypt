# CaesarDecrypt

Local Cipher Library

The functionality listed below should be placed in appropriate classes/methods.
From the command line, accept the following as input:
The name of the cipher text input file (referred to as input.txt below)
The name of the decoded text output file (referred to as decided_strings.txt below)
The cipher algorithm shift: an integer indicating how many positions each character has been moved by the cipher algorithm.
The number of threads to be used: referred to as NUM_THREADS below
Debug Value: an integer that controls what is printed on stdout
Validate that the correct number of command line argumets have been passed.
Perform validation that the value of NUM_THREADS is between 1 and 5.
The value of DEBUG_VALUE should be between 0 and 4.
A class CaesarCipher.javaCaesarDecrypt.java that has a method to convert a given cipher text to plain text string. The cipher algorithm replaces each character in the string by 1 position (for SHIFT=1). So, A is replaced by B, D is replaced by E, and Z is replaced by A. Similarly, a is replaced by b, d is replaced by e, and z is replaced by a.
A class, DecodedStore, java, with an appropriate data structure as a data member, to store decoded strings. This class should have a method to add a string at a time to this data structure. It should have a displayDataToFile(...) method that should print all the data it has to decoded_strings.txt.
DecodedStore should implement an interface DisplayPersistent DisplayI. The method displayDataToFile(...) should be in this interface.
From the main thread, create an instance of the class CreateWorkers, which should have a method startWorkers(..). The startWorkers method should start NUM_THREADS instances of ThreadedDecrypter. The threaded class, ThreadedDecrypter, in its run() method should do the following:
While the end of file has not been reached:
Invoke a method in the FileProcessor to read one line
Decrypt the string using the instance of CeaserCipher
Write it to DecodedStore
The startWorkers(...) method should join on all the threads it creates.
Assume that the input file will have one unique string per line, no white spaces, and no empty lines. However, it is possible that the input file has no strings at all.
The Driver code (use Driver class) should validate command line arguments, create an instance of CreateWorkers and invoke the method startWokers(...) on it, and then invoke the displayData(...) method on the DecodedStore.
The Driver code can create an instance each for input file stream, output file stream, CeaserCipher, and DecodedStore. These references can be passed it to the required classes. It should not create
Except in the Logger class, do not make any other method static.
The DEBUG_VALUE should be accordingly set in the class Logger. Use the DEBUG_VALUE in the following way:
DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called]
DEBUG_VALUE=2 [Print to stdout everytime an entry is added to the Results data structure]
DEBUG_VALUE=1 [Print to stdout the contents of the data structure in Results]
DEBUG_VALUE=0 [No output should be printed from the application]
The Logger class should have a static method to writeOuput(...).
Place the FileProcessor.java in the util/ folder.
