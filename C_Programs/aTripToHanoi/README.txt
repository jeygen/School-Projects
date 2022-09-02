Question:

Suppose that towers(5, 2, 3) is invoked.

1.      How will the first recursive call to towers() be invoked? Answer this question in the form:
        towers(x, y, z) where you give the actual values to the three parameters.

	Answer: towers(n-1, from, spare) from line 21 is the first recursive call.
		spare = 6 - from - dest;
		So with an input of towers(5, 3, 2) the first recursive call is towers(4, 2, 1).

2.      How many recursive calls to towers() will be made before this first recursive call actually 
	returns to the initial invocation?

	Answer: It would take 15 recursion calls to return to the original invocation. 
		 

3.      Once towers(5, 2, 3) has invoked its first recursive call to towers() and this invocation has 
	returned, what will be printed to stdout? (i.e. What actual move will be made by towers(5, 2, 3) ?)

	Answer: The first few lines will be "2 3", "2 1", "3 1". The full printout is in stdoutTowers523.txt. 

4.      How will the second recursive call to towers() be invoked? Answer this question in the form: 
	towers(x, y, z) where you give the actual values to the three parameters.

	Answer: The second recursive call will be towers(3, 2, 3)

Question:

Suppose that towers(8, 1, 2) is invoked. How many lines will be printed to stdout? 
	
	Answer: The minimum amount of moves is calculated with 2^n-1.
		2^8-1= 256 - 1 = 255 lines will be printed out.


Bugs: No known bugs.
