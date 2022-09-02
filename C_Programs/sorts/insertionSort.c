/* 
This insertion sort example and text was taken from https://www.geeksforgeeks.org/insertion-sort/ and https://www.youtube.com/watch?v=OGzPmgsI-pQ
It has been annotated and is to be used for reference.
*/

// C program for insertion sort
/*
To sort an array of size n in ascending order: 
1: Iterate from arr[1] to arr[n] over the array. 
2: Compare the current element (key) to its predecessor. 
3: If the key element is smaller than its predecessor, compare it to the elements before. 
    Move the greater elements one position up to make space for the swapped element.

    Time Complexity: O(n^2) 
    Auxiliary Space: O(1)
    Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
    Algorithmic Paradigm: Incremental Approach
    Sorting In Place: Yes
    Stable: Yes
    Online: Yes
    Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
*/

#include <math.h>
#include <stdio.h>

/* Function to sort an array using insertion sort*/
void insertionSort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++) { // notice i starts from 1 instead of 0
        key = arr[i]; // Assigning a key to 1st unsorted element, elements to the right are "unsorted"
        j = i - 1; // j is being assigned 1 value below each i value, the "sorted" element

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > key) { // This slides everything greater to the right to "make room" for insertion
            arr[j + 1] = arr[j]; // 
            j = j - 1; // j decrements
        }
        arr[j + 1] = key; // this is the insertion
    }
}

// A utility function to print an array of size n
void printArray(int arr[], int n)
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

/* Driver program to test insertion sort */
int main()
{
    int arr[] = { 12, 11, 13, 5, 6 };
    int n = sizeof(arr) / sizeof(arr[0]);

    insertionSort(arr, n);
    printArray(arr, n);

    return 0;
}
