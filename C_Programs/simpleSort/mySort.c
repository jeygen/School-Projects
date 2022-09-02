/*
The goal is write any type of sort function.
The function will be implemented and tested in sortMain.c
*/

void mySort(int d[], unsigned int n) {
	int temp;
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			if (*(d+i) < *(d+j)) {
				temp = *(d+j);
				*(d+j) = *(d+i);
				*(d+i) = temp;
			}
			else
				continue;
		}
	}
}
