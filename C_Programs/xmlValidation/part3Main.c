#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
extern char *  pop();
extern void push(char *);
extern void freeStack();
extern void allocate();
extern void print();
#define MAX_TAG_LENGTH 10

int main(int argc, char * argv[])
{
	int ch;
	char startTag[MAX_TAG_LENGTH]; // for string after '<'
	int startTagcloser; // for '>' after start tag
	char endTag[MAX_TAG_LENGTH]; // for char after '</'
	int endTagcloser;
  int i = 0;

  char *temp2 = (char*)malloc(50*sizeof(char));
  char *temp = (char*)malloc(50*sizeof(char));
 
  allocate();

  for (i = 0; i < MAX_TAG_LENGTH; i++) { 
          startTag[i] = '\0';
          endTag[i] = '\0';
  }
  
  
  //TOP:
  while ((ch = getchar()) != EOF) {
    if (!(isalpha(ch) || ch == '>' || ch == '<' || ch == '/'))
      continue;
    //
    i = 0;
		if (ch == '<') {
      
			startTag[0] = getchar();

      if (isalpha(startTag[0]) && startTag[0] != '/') { //this skips over non-alpha but doesnt invalidate
        while ((ch = getchar()) != '>') {
            if (isdigit(ch) != 0) {
              fprintf(stdout, "NOT valid\n");
              exit(1);
            //  goto TOP;
            }
            if (i < MAX_TAG_LENGTH)
              startTag[++i] = ch;
        }
        push(startTag);
        for (i = 0; i < MAX_TAG_LENGTH; i++) // important, dont leave commented out by end of session
          startTag[i] = 0;
        //print();
      }
    

      if (startTag[0] == '/') { 
        i = 0;
        //endTag[0] = '/';
        while ((ch = getchar()) != '>') {
          if (isdigit(ch) != 0) {
            fprintf(stdout, "NOT valid\n");
            exit(1);
          //  goto TOP;
          }
          if (i < MAX_TAG_LENGTH) 
            endTag[i++] = ch;
        }
        push(endTag);
        temp2 = pop(); 
        temp = pop();
        
        if(strcmp(temp, temp2) == 0)
          fprintf(stdout, "Valid\n");
        else {
          fprintf(stdout, "NOT valid\n");
          exit(1);
        }
        //print(); 
        for (i = 0; i < MAX_TAG_LENGTH; i++) {
            startTag[i] = 0;
            endTag[i] = 0;
        }
      }
    }

  } // main while brace		
    
  freeStack();
  exit(0);
}
