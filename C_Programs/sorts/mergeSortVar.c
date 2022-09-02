#include <stdio.h>
#include <stdlib.h>

// Takes two sorted lists and makes one sorted list to pass by reference
// This code is a mixture of pseudocode for "Introduction to Algorithims", my own contributions and largely the version from "https://www.geeksforgeeks.org/merge-sort/"

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

    /* Merge the temp arrays back into arr[l..r]*/
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

	/* Copy the remaining elements of L[], if there
	are any */
	while (i < n1) {
		arr[k] = L[i];
		i++;
		k++;
	}

	/* Copy the remaining elements of R[], if there
	are any */
	while (j < n2) {
		arr[k] = R[j];
		j++;
		k++;
	}

    free(L);
    free(R);
        
}


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

void mergeSort(int *arr, int l, int r) { // first/left index, last/right index // Splits deck into 2 piles

    if (l < r) {
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid); // All the lefts
        mergeSort(arr, mid + 1, r); // All the rights
        merge(arr, l, mid, r);
    }
}


    

int main() {
    int i;
    int arr[] = {1, 2, 5, 5, 10};
    int arr2[] = {0, 2, 3, 6, 20};
    int arr3[] = {10, 2, 3, 6, 20};

    int merged[10];

    //merge(arr, arr2, 5, 5, merged);
    mergeSort(arr3, 0, 4);
    for (i = 0; i < 5; i++)
        printf("%d\n", arr3[i]);

    return 0;
}
