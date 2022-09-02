#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "mySort.h"

/*
This will check the accuracy of the implemented sort function, mySort.c.

(Will not throw error if mySort.c is left empty and test array is intialized already sorted.)
*/

int main(int argc, char * argv[]) {

    /* If args passed convert to array and sort */
    if (argc > 1) {
	    fprintf(stderr, "The command line arguments will all be converted to integers and are:\n");
	    int *p = (int *) malloc(argc * sizeof(int));
	    for(int i = 1; i < argc; i++) {
	        fprintf(stderr, "Arg: %d is %d as an integer.\n", i, atoi(argv[i]));	
	    }
	    for(int i = 0; i < argc; i++) 
		p[i] = atoi(argv[i]);
	    mySort(p, argc); 	 

	    /* Check that the data array is sorted. */   
	    for(int i = 0; i < argc-1; i++) {  
		    if (p[i] > p[i+1]) {  
		    fprintf(stderr, "Sort error: p[%d] (= %d)"   " should be <= p[%d] (= %d)- -aborting\n",   i, p[i], i+1, p[i+1]);  
		    exit(1);  
	    }  
	    }  

	    /* Print sorted array to stdout */  
	    for(int i = 1; i < argc; i++) {  
	    printf("%d\n", p[i]);  
	    }  
            
            free(p);	
    }
    else {
	    fprintf(stderr, "There were no command line arguments so using hard coded array values.\n");
	    int data[100000]; /* Array of ints to sort */  
	    int nDataItems; /* number of actual items in the array */ 
	      
	    /* Test data */  
	    nDataItems = 4;  
	    data[0] = 60;  
	    data[1] = 50;  
	    data[2] = 30;  
	    data[3] = 40;  
	    mySort(data, nDataItems);	

	    /* Check that the data array is sorted. */   
	    for(int i = 0; i < nDataItems-1; i++) {  
		    if (data[i] > data[i+1]) {  
		    fprintf(stderr, "Sort error: data[%d] (= %d)"   " should be <= data[%d] (= %d)- -aborting\n",   i, data[i], i+1, data[i+1]);  
		    exit(1);  
		    }  
	    }  

	    /* Print sorted array to stdout */  
	    for(int i = 0; i < nDataItems; i++) {  
	    printf("%d\n", data[i]);  
	    }  
    }
	exit(0);
}
