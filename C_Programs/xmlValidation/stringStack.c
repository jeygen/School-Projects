/**
 *  The functions in this module implement a Stack data structure
 *  of integers.  (Note that chars are also integers so this
 *  integer Stack can be used for chars as well.)
 *
 *  NOTE: the stack is implemented as a fixed size array (size = 100).
 *  Consequently, no more than 100 integers can be pushed onto
 *  the Stack at any given time.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Implementation hints:
//   The 3 functions--push, pop and isEmpty--share information
//   about the array used to implement the stack and the index
//   of the "top" of the stack.
//
//   You may want to make these variables global...
//   ...but that would
//   be a mistake (because anyone using the module would have
//   to ensure that they did not use global variables with the
//   same names).
//
//   An alternative in C is a "static global".
//   If a global variable is qualified as "static", it is global only
//   within the source code file where it is declared.
//   In parituclar, it cannot conflict with any other global variable.
//
//  RECOMMENDATION:
//   Uncomment the following 2 lines and use these static globals!
static int top = 0; // indicates where the top of the stack is
static char* stack[100];



/**
 *  push(thing2push) adds the "thing2push" to the top of the stack.
 *
 *  If there is no more space available on the Stack, an error
 *  message is printed to stderr.
 */
void push(char *thing2push)
{

  top++;// good top, but experimenting
  if (top > 100) {
    fprintf(stderr, "Stack overflow\n");
  }
  if (strlen(thing2push) > 100) {
	fprintf(stderr, "String too long to push.");
  } 
  
  stack[top] = (char*)malloc(sizeof(char)*(strlen(thing2push)+1));
  strcpy(stack[top], thing2push); 
}

/**
 * isEmpty() returns a non-zero integer (not necessarily 1) if the
 * stack is empty; otherwise, it returns 0 (zero).
 *
 */
int isEmpty()
{
  if (top <= 0)
    return 1; // it top is at 0 then return 0 for true 
  else
    return 0; // else returns 1 for false  
}

/**
 * pop() removes the top integer on the stack and returns it.
 *
 * If pop() is attempted on an empty stack, an error message
 * is printed to stderr and the value -1 (minus one) is returned.
 */

char* pop()
{
  
  if (isEmpty() == 1) 
    fprintf(stderr, "Stack underflow\n");
  
  top--; // top decrements

  int tempTop = 1 + top;
  return stack[tempTop]; // returns top of stack (before decrement)

}

void allocate() {
  *stack = malloc(sizeof(char*)*100);
}

void freeStack() {
  int i = 0;
  for (i = 0; i < 100; i++) 
    free(stack[i]);
  free(stack);
}

void print() { // for testing
    int i;
    stack[10] = "apple";
    for (i = 0; i < 100; i++) 
      fprintf(stdout, "%s", stack[i]);
}



