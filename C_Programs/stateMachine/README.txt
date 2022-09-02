LAB4

The following is the generated state machine that was used:

    The assigned state machine message was:

        Hello

        Your personalized state machine description for Lab 4 (coe 428) follows:

        A H G
        B E H
        C F D 
        D B E 
        E G F 
        F D A 
        G A B 
        H H C 

        Your starting state is: C 

            Good luck!

Notes on the code:

    - The code works.
    - Sample input and output was provided to demonstrate
    - If commands are not entered precisely the program will not execute the command (case sensitive)
        - 'p' to print all states
        - 'r' to print current state and legal inputs
        - 'q' to quit
        - '<0 or 1>' to change state
        - 'c <0 or 1> <A-H>' to change 0 or 1 state to desired state
        - 'd' to bring-up delete prompt
            - '0' to delete all garbage
            - '<A-H>' to see status of desired state
        - 'g' to show garbage contents 
        
Bugs:

    - Line 245: the c command only refutes some bad input, it is possible to assign a next state as a letter not A-H, not sure why
    