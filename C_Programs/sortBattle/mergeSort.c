#include "mySort.h"
#include <stdlib.h>
#include <stdio.h>

void mySort(int arr[], unsigned int l, unsigned int r);
void merge(int *arr, int l, int mid, int r); 

void mySort(int arr[], unsigned int l, unsigned int r) {
    //if (l < r) {
    if (myCompare(l, r) < 0) {
        int mid = (l + r) / 2;
        mySort(arr, l, mid); // All the lefts
        mySort(arr, mid + 1, r); // All the rights
        merge(arr, l, mid, r);
    }
}

void merge(int *arr, int l, int mid, int r) {
    int n1 = mid - l + 1; 
    int n2 = r - mid; 

    int *L = (int*) malloc(n1 * (sizeof(int))); 
    int *R = (int*) malloc(n2 * (sizeof(int))); 
    if ( L == NULL || R == NULL) // No metrics function for NULL
        exit(0);
    //int L[n1];
    //int R[n2];

    int i, j, k;
    i = j = k = 0; 

    //for (i = 0; i < n1; i++)
    for(i = 0; myCompare(i, n1) < 0; i++) {
        //L[i] = arr[l + i]; 
        myCopy(&arr[l + i], &L[i]);
    }
    //for (j = 0; j < n2; j++) 
    for(j = 0; myCompare(j, n2) < 0; j++) {
        myCopy(&arr[mid + 1 + j], &R[j]);
        //R[j] = arr[mid + 1 + j];
    }

    i = j = 0;
    k = l;

    /* Merge the temp arrays back into arr[l..r]*/
	//i = 0; // Initial index of first subarray
	//j = 0; // Initial index of second subarray
	//k = l; // Initial index of merged subarray
	//while (i < n1 && j < n2) {
	while(myCompare(i, n1) < 0 && myCompare(j, n2) < 0) {
		//if (L[i] <= R[j]) {
		if (myCompare(L[i], R[j]) <= 0) {
			//arr[k] = L[i];
			myCopy(&L[i], &arr[k]);
			i++; 

		}
		else {
			//arr[k] = R[j];
			myCopy(&R[j], &arr[k]);
			j++;
		}
		k++;
	}

	/* Copy the remaining elements of L[], if there
	are any */
	//while (i < n1) {
	while(myCompare(i, n1) < 0) {
		//arr[k] = L[i];
		myCopy(&L[i], &arr[k]);
		i++;
		k++;
	}

	/* Copy the remaining elements of R[], if there
	are any */
	//while (j < n2) {
	while(myCompare(j, n2) < 0) {
		//arr[k] = R[j];
		myCopy(&R[j], &arr[k]);
		j++;
		k++;
	}

    free(L);
    free(R);
        
}

/*
void mySort(int arr[], unsigned int l, unsigned int r);
void merge(int *arr, int l, int mid, int r); 

void mySort(int arr[], unsigned int l, unsigned int r) {
//void mySort(int *arr, int l, int r) { // first/left index, last/right index // Splits deck into 2 piles
    if (l < r) {
        int mid = (l + r) / 2;
        mySort(arr, l, mid); // All the lefts
        mySort(arr, mid + 1, r); // All the rights
        merge(arr, l, mid, r);
    }
}

void merge(int *arr, int l, int mid, int r) {
    int n1 = mid - l + 1;
    int n2 = r - mid;
    int *L = (int*) malloc(n1 * (sizeof(int))); // pseudo says L[1..n+1]
    int *R = (int*) malloc(n2 * (sizeof(int)));
    if ( L == NULL || R == NULL)
        exit(0);
    int i, j, k;
    i = j = k = 0;

    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[mid + 1 + j];

    i = j = 0;
    k = l;

     // Merge the temp arrays back into arr[l..r]
	i = 0; // Initial index of first subarray
	j = 0; // Initial index of second subarray
	k = l; // Initial index of merged subarray
	while (i < n1 && j < n2) {
		if (L[i] <= R[j]) {
			arr[k] = L[i];
			i++;
		}
		else {
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	// Copy the remaining elements of L[], if there	are any 
	while (i < n1) {
		arr[k] = L[i];
		i++;
		k++;
	}

	// Copy the remaining elements of R[], if there	are any 
	while (j < n2) {
		arr[k] = R[j];
		j++;
		k++;
	}

    free(L);
    free(R);
        
}
*/


/*
void merge(int *A, int *B, int sizeA, int sizeB, int *C) { 
    int i, j, k;
    i = j = k = 0;

    while (i < sizeA && j < sizeB) {
            if (A[i] < B[i])
                C[k++] = A[i++];
            else    
                C[k++] = B[j++];
    }

    for(; i < sizeA; i++) // i keeps prev value as not assigned
        C[k++] = A[i];
    for(; j < sizeB; j++)
        C[k++] = B[j];
}
*/


