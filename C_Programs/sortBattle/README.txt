To compare insertionSort(), mergeSort():
	1. Compile with make 
	2a. Run runSorts35.sh or runSorts1000.sh scripts and the randomly generated numbers from the text files will be input into each sorting function.
	Or
	2b. Run insertionSort.c or mergeSort.c individually and input your own values to be sorted.
    Or
	2c. Run runInsertSorts.sh to compare insertSort() against itself with 5000 ascending, descending and random values.
	Or
	2d. Run runMergeSorts.sh to compare mergeSort() against itself with 5000 ascending, descending and random values.

# Questions and Answers

1. A brief summary of what you accomplished and what (if any) parts you did not
complete or bugs that you are aware of but have not fixed.

	- Code was written for the insertion sort and merge sort sorting algorithms. The code that was
	  implemented drew from the "Introduction to Algorithms" and www.geeksforgeeks.org website for 
	  guidance.

	- Insertion sort iterates over the full array starting from the initial "key" value. The key value
	  is then compared to its predecessor. If smaller, it then compares to elements before this point.
	  Once it is larger than the element it is comparing itself to it inserts itself into the array at the
	  new position. The larger elements bump up a position in the array to accomodate the swapped element. 
	
	- Merge sort is a recursive or divide and conquer function. It calls itself recursively, and halves itself
	  until the arrays that constitute it become a single element. The algorithm then merges the elements into 
	  sorted sub-arrays. These sub-arrays are joined by the merge function inside of the merge sort algorithm back 
	  into a single array.

	- After insertionSort and mergeSort were implemented, all the conditional, and array assignment operations
	  were replaced with the myCompare(), myCopy, and mySwap() functions from the metrics code. These functions
	  track the number of operations the algorithms perform while sorting.

	- Additionally, genNum was written to generate user defined text files of integers that were sorted or random 
	  to be used for analysis purposes. 
	  	- avgInsert.txt contains 5000 random values. 
		- bestInsert.txt contains 5000 ascending sorted values.
		- worstInsert.txt contains 5000 sorted descending value. 
		- numList35.txt and numList1000.txt contain random values with 35 and 1000 entries.

	- runSorts35.sh and runSorts1000.sh run both sorting algorithms with 35 or 1000 entries.

	- runInsertSorts.sh and runMergeSorts.sh run the titular algorithm with 5000 random, ascending sorted and descending 
	  sorted values.

2. Analysis (including equations for number of moves, swaps and compares as a function of n) for the best-, 
average- and worst-case behaviors of insertionSort and mergeSort.

	* The paticular insertionSort and mergeSort that was implemented did not require any mySwap() functions.
	  It is reasonable to infer that there may be more myCopies() and myCompares() as a result.

	InsertionSort()
		Best case
			Theoretical: After applying asymptotic analysis, the theoretical best case is omega(n).
			Experimental: 5000 ascending sorted entries.
				Number of Comparisons: 2998 - Comp(n) = 0.6(n-4) 
				Number of Swaps: 0 
				Number of Copies: 1998 - Copy(n) = 0.4(n-4)
				Total Number of operations: 4996 - T(n) = (n-4)
			Notes: Insertion sort when given a sorted ascending list performed very quickly.
				   It took T(n) = (n-4) to complete the sort. This matches the linear theoretical expectation. 

		Worst case
			Theoretical: After applying asymptotic analysis, the theoretical worst case is O(n^2).
			Experimental: 5000 descending sorted entries.
				Number of Comparisons: 1,000,999 - Comp(n) = n^1.62
				Number of Swaps: 0 
				Number of Copies: 501498 - Copy(n) = n^1.54
				Total Number of operations: 1,502,479 - T(n) = n^1.67 ~ n^2 
			Notes: Insertion sort when given a sorted descending list performed very slowly.
				   It took T(n) = n^1.67 ~ n^2  to complete the sort. This approximatly matches the quadratic theoretical expectation. 
		
		Average case
			Theoretical: After applying asymptotic analysis, the theoretical average case is theta(n^2).
			Experimental: 5000 random unsorted entries.
				Number of Comparisons: 503,014 - Comp(n) = n^1.54
				Number of Swaps: 0 
				Number of Copies: 252,011 - Copy(n) = n^1.46
				Total Number of operations: 755,025 - T(n) = n^1.59 ~ n^2
			Notes: Insertion sort when given a unsorted random list performed very slowly.
				   It took T(n) = n^1.67 ~ n^2  to complete the sort. This approximatly matches the quadratic theoretical expectation.

	MergeSort()
		Best case
			Theoretical: After applying asymptotic analysis, the theoretical best case is omega(nlog(n)).
			Experimental: 5000 ascending sorted entries.
				Number of Comparisons: 37034 - Compare(n) = 7.41n
				Number of Swaps: 0
				Number of Copies: 19952 - Copy(n) = 3.99n
				Total Number of operations: 56986 - T(n) ~ nlog(n)
			Notes: As 5000lg(5000) = 61438, the total approximate experimental operation count was very similar to the 
				   nlog(n) amount.

		Worst case
			Theoretical: After applying asymptotic analysis, the theoretical worst case is O(nlog(n)).
			Experimental: 5000 descending sorted entries.
				Number of Comparisons: 37804 - Compare(n) = 7.56n
				Number of Swaps: 0 
				Number of Copies: 19952 - Copy(n) = 3.99n
				Total Number of operations: 57761 - T(n) ~ nlog(n)
			Notes: As 5000lg(5000) = 61438, the total approximate experimental operation count was very similar to the 
				   expected amount.
		
		Average case
			Theoretical: After applying asymptotic analysis, the theoretical average case is theta(nlog(n)).
			Experimental: 5000 random unsorted entries.
				Number of Comparisons: 44827 - Compare(n) = 8.96n
				Number of Swaps: 0 
				Number of Copies: 19952 - Copy(n) = 3.99n
				Total Number of operations: 64779 - T(n) ~ nlog(n)
			Notes: As 5000lg(5000) = 61438, the total approximate experimental operation count was very similar to the 
				   expected amount.		

		Additional notes on mergeSort():
			As the algortihm performed almost the same with sorted, reverse sorted and random values, the true best case
			would be proportional to the entry amount. The quality of the sorting time would still be T(n) = nlog(n) but it would
			perform faster as there would be less to sort. 