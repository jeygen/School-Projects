## Making a Sort Algo

	An excercise in creating a sort algo and learning how to provide command line arguments to a C program.

	Parts of my code were taken from the COE 428 Lab Guide.

# Lab Questions

	1.   Suppose you were given an object module (with no access to source code) that sorted an array of 
             integers very efficiently. However, the sort function in the object module must be invoked with the following signature:

		betterSort(int data[], first, last);

	     Where the array to sort is data and the parameters first and last give the indices of the portion of the array that is to be sorted.
	     How could you write a mySort() function with the signature used in this lab that could exploit the better sorting function 
             in the supplied object module? 

	       	     - As betterSort() is a superior algorithm it would be smart to use it within the mySort() function.

		     - mySort(int data[], unsigned int n) {
			     betterSort(*data, 0, n-1); // This accounts for the different ways of the functions handle size.
		       }

# Issues

	- The programs seem to be running as expected.





# Some Notes on Compiling

- Notes on headerfiles
	- contain func declarations, macros to be shared b/t source files
	- 2 types: <compiler> and "userdefined"
		- #include before both types, preprocessing directive
		- <> searches for name in sys dir, "" searches for name in current dir
	- cleaner than copying contents of header file

- Notes on edits, compiling, linking, and running
	- Compilation
		- done with gcc or GNU Compiler Collection
		- Translation of written source code to object or executable code 
		- steps: 
			- preprocessing
				- removes comments from source
				- gets the header files
				- replaces macros with their values
				- name.i, to stop compiling at this point "gcc -E name.c"
			- compiling
				- takes name.i generates Intermediate Representation
				- main.s file now, to stop at this step "gcc -S name.c"
			- assembling
				- IR to object code (machine with linking info)
				- name.o (not human readable)
				- to stop at this step "gcc -c name.c"
			- linking
				- creates final executable file in binary
				- 2 roles:
					- linking all the source files, or object codes in a projo
						- want to compile name.c w/ name2.c for single program?
						- this step links the object files of name.c and name2.c
						- "gcc -o desiredName name.o name2.o name3.o", this links the .o's
							- to get .o's compile with -c flag
					- links functions with their definitions
				- "gcc name.c" will finish this step and a.out executable file will be created 
				- if we want a name other than a.out, "gcc -o name.c desiredName"
				- execute with ./name or ./a.out 


# to Do

	1. ~~Create mySort.c~~, ~~mySort.h~~, ~~sortMain.c~~
	2. ~~Modify sortMain.c to accept command line arguments as the array to sort~~

