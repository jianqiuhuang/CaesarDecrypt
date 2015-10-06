CS442 Design Patterns
Fall 2015
ASSIGNMENT NO.2 README FILE

Due Date: OCTOBER 8, 2015
Submission Date: OCTOBER 8, 2015
Grace Period Used This Project: N/A
Grace Period Remaining: N/A
Author(s): JIANQIU HUANG AND BRANDON FOO
e-mail(s): JHUANG86@BINGHAMTON.EDU AND ...


PURPOSE:

  This program is designed to decrypt Cipher text file using the multi-threading approach

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

[
  Copy and paste a recent CORRECT output from your test runs, ALONG with the
  command line. Cut it short if more than 10 lines. Here is a sample:

  [erdil@the_caribbean:~erdil]$ ./a.out topaz 12345 binaenaleyh
  SOME OUTPUT
  SOME MORE
  WOW, IT DOES NOT END
  [snip here] (-> if too long)
  OH MY..
  FINALLY
  [erdil@the_caribbean:~erdil]$
]

TO COMPILE:

[
  Document here how your TA can build your program after extracting your
  gzipped-tarball. (Note: ideally, TA should just do a "make". Justify extra
  steps needed). Be as clear as possible, refer to "... FOR DUMMIES" book
  format. Assume your TA is completely lost, trying to save the universe.
  Here is a sample:

  Just extract the files and then do a "make".
]

TO RUN:

[
  Document here how your TA can test your program after extracting your gzipped-
  tarball. Be as clear as possible, refer to "... FOR DUMMIES" book format.
  Assume your TA is completely lost, there is another universe. Here is a
  sample:

  Please run as: ./a.out <REGHOST> <REGPORT> <UNIQNAME>
  For example:   ./a.out topaz 12345 binaenaleyh
]

EXTRA CREDIT:

[
  Document here extra work you have done to get bonus grade, IF THERE IS ANY.
  Otherwise, say "N/A"
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<NAMES OF GROUP MEMBERS>

[
  Document here any sources, books, internet resources you have benefited from.

  Here are some samples:

  * http://spring2004.cs654.allprojectsolutions.binghamtonuniversity.com

  * Deitel, H. M., and Deitel P. J. Java How To Program 3/E. Upper Saddle River:
    Prentice Hall, 1999 (pp. 385-369)
]

ACKNOWLEDGEMENT:

[
  Document here your classmates, and/or other people who have helped you.
  DON'T ACKNOWLEDGE YOUR TEAMMATES.
  Here is a sample:

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  B. Gates
  S. Jobs

]
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
ant -buildfile src/build.xml run -Darg0=firstarg 

## To run by specifying args in build.xml
ant -buildfile src/build.xml run b

## To create tarball for submission
ant -buildfile src/build.xml tarzip


