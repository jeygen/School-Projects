#include <stdlib.h>
#include <time.h>
#include <stdio.h>
#include "timeFunc.h"

int main(int argc, char *argv[]) {

	char func = argv[1][0]; // This accesses 1st char of {'i','n','p','u','t','\0'}
	unsigned long long n = atoi(argv[2]);
	clock_t start, end;
	double totalTime;

	start = clock();
	switch(func) {
		case 'l':
			linear(n);
			break;
		case 'q':
			quad(n);
			break;
		case 'c':
			cubic(n);
			break;
	}
	end = clock();
	
	totalTime = (double)(end-start) / (double)(CLOCKS_PER_SEC);
	printf("\nExecution time for the %s function is %0.8lf seconds.\n", argv[1], totalTime);

	exit(EXIT_SUCCESS);
}
