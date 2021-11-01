#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define SIZE_OF_ARRAY 10
#define TRUE 1
#define FALSE 0
#define NOT_FOUND -1 

int binary_srch(const int search_array[], int target, int size); 

int main()

{
	int length, i, target, location;
	
	printf("Please enter any positive number. This will generate an array whose elements will run from 1 to the entered number.\n");
	scanf("%d",&length);
	
	int search_array[length];
	
	for(i =0; i < length; i++)
	{
		search_array[i] = i+1;
	}
	
	printf("Please enter the number you want to find.\n");
	scanf("%d",&target);
	
	location =  binary_srch(search_array, target, length);
	
	if(location == NOT_FOUND)
	printf("Target not within range.\n");
	else
	printf("The location of the number in the array is: %d\n", location);
	
	
	return 0;
}

int binary_srch(const int search_array[], int target, int size)
{
	
	int top, bottom, middle, index, found;
    bottom = 0;
    top = size - 1;
    found = 0;
    while(found == FALSE && !(bottom > top))
    {
           middle = (top + bottom)/2;
		   if(target == search_array[middle])
		   {
		   index = middle;
		   found = TRUE;
		   }
		   	   if(target > search_array[top] || search_array[bottom] > target)
		   {
			   return NOT_FOUND;
		   }
		   else if(search_array[middle] > target)
		   {
			   top = middle - 1;
			    
		   }
		   else if(target > search_array[middle])
		   {
			   bottom = middle + 1;
		   }
	}
	
	
	return index;
}