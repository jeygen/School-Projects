#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
extern int pop();
extern void push(int);
extern int isEmpty(); // I added this, check if thats allowed

/*
* Part 2
* Same as part 1, but now counting and saving each tag
* Added a direct list/array that has it's 1st element as a key and 2nd element as a counter
* Should ask if there is a better way to do this, like maybe using a linked list?
*/

int main(int argc, char * argv[])
{
	int ch;
	int startTag; // for char after '<'
	int startTagcloser; // for '>' after start tag
	int endTag; // for char after '</'
	int endTagcloser;
	//int **table;
	//int j = 0;
	int i = 0;
	char table [26][2] = {    {'a', 0}, {'b', 0}, {'c', 0}, {'d', 0}, {'e', 0}, 
				              {'f', 0}, {'g', 0}, {'h', 0}, {'i', 0}, {'j', 0},
				              {'k', 0}, {'l', 0}, {'m', 0}, {'n', 0}, {'o', 0},
				              {'p', 0}, {'q', 0}, {'r', 0}, {'s', 0}, {'t', 0},
				              {'u', 0}, {'v', 0}, {'w', 0}, {'x', 0}, {'y', 0},
	  		                  {'z', 0}}; 


	/*
	for (i = 0; i < 26; i++) {
		fprintf(stdout, "%c %d\n", table[i][0], table[i][1]);
	} 
	*/
		

	while ((ch = getchar()) != EOF) {
		if (!(isalpha(ch) || ch == '>' || ch == '<' || ch == '/')) 
			continue;

		//Checking to see if <a></a> format is followed.
		//Only works if single char and lowercase (ask to make sure this is desired)
		//
		if (ch == '<') {

			startTag = getchar();
			
			if (isdigit(startTag) != 0) {
				fprintf(stdout, "NOT valid/");
				exit(1);
			}
			if (startTag == '/') {
				endTag = getchar();
				endTagcloser = getchar();

				if (endTagcloser == '>') {
					if (pop() == endTag) {
						for (i = 0; i < 26; i++) {
							if ((int)table[i][1] > 0)
								fprintf(stdout, "%c %d\n", table[i][0], table[i][1]);
						}	
						fprintf(stdout, "Valid\n");
						exit(0);
						//continue;
					}
					else {
						fprintf(stdout, "NOT Valid\n");
						exit(1);
						//continue;
					}
				}
				else  
					continue;
			}

			startTagcloser = getchar();

			if (startTagcloser != '>') {
				fprintf(stdout, "NOT Valid\n");
				exit(1);
				//continue;
			}

			if (islower(startTag) && startTagcloser == '>') {
				push(startTag);
				for (i = 0; i < 26; i++) {
					if (table[i][0] == startTag)
						table[i][1]++;
				}
			}
			else { 
				continue;
			}
		}
	}

  exit(0);
}
