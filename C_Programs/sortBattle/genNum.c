#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
A simple number generator - did not spend time making safe
arg 1 = number of numbers/entries
arg 2 = 1 for random, 2 for ascending, 3 for descending
*/

int main(int argc, char **argv) {

	int entries;

	switch (atoi(argv[2])) {
		case 1: // Random nums, Avg case for insertionSort()
			for (entries = 0; entries < atoi(argv[1]); entries++) 
				fprintf(stdout, "%d\n", rand() % 3000);
			break;
		case 2: // Ascending sorted nums, Best case for insertionSort()
			for (entries = 0; entries < atoi(argv[1]); entries++) 
				fprintf(stdout, "%d\n", entries);
			break;
		case 3: // Descending sorted nums, Worst case for insertionSort()
			for (entries = atoi(argv[1]); entries > 0; entries--) 
				fprintf(stdout, "%d\n", entries);
			break;
        default:
			fprintf(stdout, "Bad arg");
	}

	exit(0);
}
