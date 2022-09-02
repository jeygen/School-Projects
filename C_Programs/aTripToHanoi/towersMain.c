#include <stdlib.h>
#include <stdio.h>
#include "towers.h"

int main(int argc, char **argv)
{
	int n = 3;
	int from = 1;
	int dest = 2;
	int *p = (int *) malloc(argc * sizeof(int));
	int i = 0;

	for (i = 0; i < argc; i++) 
		p[i] = atoi(argv[i]);
	
	if ((argc == 2 || argc == 3 || argc == 4) && p[1] < 0) {
		fprintf(stderr, "\nInput args are not acceptable\n");
		free(p);
		exit(0);
	}
		
	if (argc == 1)
		towers(n, from, dest);
	else if (argc == 2) {
		n = p[1];
		towers(n, from, dest);
	}
	else if (argc == 4 && p[2] != p[3] && p[2] < 4 && p[2] > 0 && p[3] < 4 && p[3] > 0) {
		n = p[1];
		from = p[2];
		dest = p[3];
		towers(n, from, dest);
	}
	else 
		fprintf(stderr, "\nInput args are not acceptable\n");

	free(p);
	
	exit(0);
}

