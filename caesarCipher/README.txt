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


