#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
extern int pop();
extern void push(int);
extern int isEmpty();
extern void addHeap(int);
extern void printHeap();
extern void printHeapXML(int);
extern int heapDelete();
extern int heapSize2();

int main(int argc, char * argv[])
{
  int value;

  while (scanf("%d\n", &value) != EOF) {
    /*
    if (isdigit(value)) 
    	addHeap(value);
    else {
      fprintf(stderr, "Must input integer!\n");
      exit(1);
    }
    */
    fprintf(stderr, "READING INPUT: %d\n", value);
    addHeap(value);
  }

  printHeap();
  printHeapXML(0);

  int temp;
  int i;
  for (i = heapSize2(); i > 0; i--) { 
    temp = heapDelete();
    push(temp);
    fprintf(stdout, "Deleted element: %d\n", temp);
  }

  while (isEmpty() != 1) 
    fprintf(stdout, "Popped from stack: %d\n", pop());


  exit(0);
}
