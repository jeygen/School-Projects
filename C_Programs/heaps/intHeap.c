#include <stdio.h>
#include <stdlib.h>

/**
 *  The functions in this module implement a Heapdata structure
 *  of integers.
 */

static int heapSize = 0;
int heap[100];
static int recursionCount = 0;



/**
 * heapSize() returns the number of items in the Heap.
 *
 */
int heapSize2()
{
  return heapSize;  
}

void swap(int *x, int *y) {
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
} 

void maxHeapify(int arr[], int arrSize, int index) {
	int left = 2 * index + 1;
	int right = 2 * index + 2;
	int largest = index;
	
	if (left < heapSize && arr[left] > arr[largest])
		largest = left;

	if (right < arrSize && arr[right] > arr[largest])
		largest = right;

	if (largest != index) {
		swap(&arr[index], &arr[largest]);
		maxHeapify(arr, arrSize, largest);
	}
}

void buildMaxHeap(int arr[], int arrSize) {
	heapSize = arrSize;
	int i;
	for (i = ((arrSize/2)-1); i >= 0; i--) 
		maxHeapify(arr, arrSize, i);
}

/**
 *  addHeap(thing2add) adds the "thing2add" to the Heap.
 *
 */
void addHeap(int thing2add)
{
	heap[heapSize] = thing2add;
	heapSize++;

	buildMaxHeap(heap, heapSize);

}

// Print xml style
void printHeapXML(int i) {

	int j;
	for (j = recursionCount++; j > 0; j--)
		fprintf(stdout, "\t");
	int size = heapSize;
	fprintf(stdout, "<node id=\"%d\">\n", heap[i]);
	
	int left = 2 * i + 1;	

	if(left < heapSize) {
		printHeapXML(left);
		recursionCount--;
	}
	
	int right = 2 * i + 2;	

	if(right < heapSize) {
		printHeapXML(right);
		recursionCount--;
	}

	for (j = (recursionCount - 1); j > 0; j--)
		fprintf(stdout, "\t");
	fprintf(stdout,"</node>\n");
}
	


// for testing purposes
void printHeap() {
	int i;
	fprintf(stdout, "For reference, this is the heap in an array: ");
	for (i = 0; i < heapSize; i++)
		fprintf(stdout, "%d ", heap[i]);
	fprintf(stdout, "\n");
	fprintf(stdout, "For reference, this is the heap in xml, traversed in the preorder pattern: \n");
}


/**
 * heapDelete() removes the biggest integer in the heap and returns it.
 *
 */

int heapDelete()
{
	int i;
	int deletedInt = heap[0];
	heap[0] = heap[heapSize - 1];
	heapSize--;
	buildMaxHeap(heap, heapSize);

  return deletedInt;  //A dummy return statement
}
