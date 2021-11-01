/*
This program prompts for the colors of three bands of a resistor, 
* and displays the * value of the resistance in kilo-ohms based on a color code
*/
 
#include <stdio.h>
#include <math.h>
#include <ctype.h>
#include <string.h>
#define NOT_FOUND -1
#define SUB_1 10
#define SUB_2 7
 
 
int search(const char [][SUB_2],const char [], int );
 
int main(void){
 char reply; /* user reply*/
 char left; /* character left in the input stream*/
 int i;
 int counter; /* counters */
 int value; /* subscript of target found in list*/
 double answer = 0.0;

 int no_error = 1; /* denotes no error */
 
 /* initializing the array*/
 char COLOR_CODES[SUB_1][SUB_2] = {"black", "brown", "red", "orange","yellow", "green", "blue", "violet", "gray", "white"}; 
 char target[SUB_2]; /* target string array*/
 
do{
 printf("Enter the colors of the resistor's three bands, beginning with\n");
 printf("the band nearest the end. Type the colors in lowercase letters only, ");
 printf("NO CAPS.\n\n");
 
for(counter = 1; counter <= 3; counter++)
   {
 	printf("Band %d => ", counter);
   scanf("%s", target);
 
   value = search(COLOR_CODES,target, SUB_1);

 if(value == NOT_FOUND)
    break;
 
 //searches for string
 if(value != NOT_FOUND) {
   switch(counter){
       case 1:
          answer = value*SUB_1;
          break;
       case 2:
          answer += value;
          break;
       case 3:
		      answer /= 1000;
          }
        }
 else
       no_error = 0;
 }
  if (value != NOT_FOUND) 
   printf("Resistance value: %.3f kilo-ohms\n\n", answer*=pow(10,value));
 else
   printf("Invalid Color: %s\n\n", target);
  
 
 printf("Do you want to decode another resistor?\n => ");
 scanf("%c%c", &left, &reply);
 printf("\n");
 } while(reply == 'y');
}
 
 
/* function takes as input a list of strings, its size, and a target string. 
 * Then, searches the list for the target and returns as its value the subscript of the target in the list. 
 * It returns -1 if target is not found. */
 
int search(const char COLOR_CODES[][SUB_2], const char target[], int size){
	
    int found = 0;

 
    int i = 0;
	int location;
	for(i = 0; i < size; i++)
	{
		if(strcmp(target, COLOR_CODES[i]) == 0)
		{
		
		location = i;
		found = 1;
	    }
	    
	    if (!found)
	    location = -1;
		
	}
  
 return location;
 }

 