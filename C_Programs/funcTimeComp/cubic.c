// O(n^3)
#include <stdio.h>

void cubic(int n) {

	int i = 0;
	int j = 0;
	int k = 0;
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {		
			for (k = 0; k < n; k++) {
				printf("zooom");
			}
		}
	}
}
