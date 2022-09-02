
# **Towers**

This project explores recursion through the classic Towers of Hanoi puzzle.

Solves the Towers of Hanoi problem and prints the required moves to stdout.
One line of text in the format FromTowerID ToTowerID is written for each move. 
The TowerIDs are '1' (for left tower), '2' (for middle tower) or '3' (for right Tower).

The program behaves as follows depending on the arguments given on the command line:

    No arguments

        If no arguments are given, the problem is solved for moving 3 disks from Tower 1 to Tower 2.

    One argument (numberDisks)

        If only one argument is given, the problem is solved for moving numberDisks disks from Tower 1 to Tower 2.

    Three arguments (numberDisks fromID toID)

        If all three arguments are given, the problem is solved for moving numberDisks disks from Tower fromID to Tower toID. The tower IDs must be either '1', '2' or '3' and the two IDs must be different. 

**EXIT CODE**

If the command is invoked correctly, the moves are output and the exit status is 0 (zero).

Otherwise, an incorrect invocation produces no output. A message is displayed on stderr and the exit status is non-zero.

**BUGS**

The program does not yet behave as specified. The command line args to identify the two towers are not recognized. Furthermore, incorrect invocation is not detected. 

You are provided with an initial version of the main() function in the file towersMain.c and the listing is shown below. However, the bugs identified in the previous section can be fixed in the main() function. 

source: "https://www.ee.ryerson.ca/~courses/coe428/labs/"

**Reminder**
- stdout
    - conventional output
    - typically standard output is line buffered (so the data is flushed when a newline is printed, or when the buffer is full)
    - to redirect stdout to file, cmdline: ./programName > desiredFileToRecieveStdout 
- stderr
    - purpose of the standard error stream is to separate error messages from regular output
    - to redirect stdout to file, cmdline: ./programName 2> desiredFileToRecieveStderr 
- can also do both: ./programName 2> desiredFileToRecieveStderr > desiredFileToRecieveStdout
     

- source: "https://stackoverflow.com/questions/59799454/what-is-the-difference-between-stdout-and-stderr-in-c"
- for more: "https://www.educba.com/stderr-in-c/"
