#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TOTAL 8
#define TOTAL2 5040

// State structure
typedef struct state_tag {
    char name;
    struct state_tag* zeroState;
    struct state_tag* oneState;
    int alive;
}state_t;

// Prototypes
void noCommands(state_t *currentState);
void oneZeroCommands(int i, state_t *currentState);
void print(state_t **arr, int size);
void change(state_t *cs, int newZeroOrOne, state_t *newState);
void garbage(state_t **arr, state_t *cs);
int garbageBuddy(state_t *currentState);
void garbageAdd(char c);
void delete(int d, char c, state_t **arr, int size);

// Gobal var
struct state_tag *cS; // global current state
char staticControlArr[TOTAL2]; // for accessible states
char staticGarbageList[TOTAL]; // for deleted states
int staticCount; // for index of staticControlArr

// Driver
int main(int argc, char * argv[]) {
    int i = 0;

    for (i = 0; i < TOTAL2; i++) { // filling both static arrays with 'z' dummy variables
        staticControlArr[i] = 'z';
    }
    for (i = 0; i < TOTAL; i++) {
        staticGarbageList[i] = 'z';
    }

    //state_t A, B, C, D, E, F, G, H;
    state_t *currentState, *A, *B, *C, *D, *E, *F, *G, *H;
    
    //currentState = (state_t*)malloc(sizeof(state_t));
    A = (state_t*)malloc(sizeof(state_t));
    B = (state_t*)malloc(sizeof(state_t));
    C = (state_t*)malloc(sizeof(state_t));
    D = (state_t*)malloc(sizeof(state_t));
    E = (state_t*)malloc(sizeof(state_t));
    F = (state_t*)malloc(sizeof(state_t));
    G = (state_t*)malloc(sizeof(state_t));
    H = (state_t*)malloc(sizeof(state_t));

    A->name = 'A';
    A->zeroState = (state_t*)malloc(sizeof(state_t));
    A->zeroState = H;
    A->oneState = (state_t*)malloc(sizeof(state_t));
    A->oneState = G;

    B->name = 'B';
    B->zeroState = (state_t*)malloc(sizeof(state_t));
    B->zeroState = E;
    B->oneState = (state_t*)malloc(sizeof(state_t));
    B->oneState = H;

    C->name = 'C';
    C->zeroState = (state_t*)malloc(sizeof(state_t));
    C->zeroState = F;
    C->oneState = (state_t*)malloc(sizeof(state_t));
    C->oneState = D;

    D->name = 'D';
    D->zeroState = (state_t*)malloc(sizeof(state_t));
    D->zeroState = B;
    D->oneState = (state_t*)malloc(sizeof(state_t));
    D->oneState = E;

    E->name = 'E';
    E->zeroState = (state_t*)malloc(sizeof(state_t));
    E->zeroState = G;
    E->oneState = (state_t*)malloc(sizeof(state_t));
    E->oneState = F;

    F->name = 'F';
    F->zeroState = (state_t*)malloc(sizeof(state_t));
    F->zeroState = D;
    F->oneState = (state_t*)malloc(sizeof(state_t));
    F->oneState = A;

    G->name = 'G';
    G->zeroState = (state_t*)malloc(sizeof(state_t));
    G->zeroState = A;
    G->oneState = (state_t*)malloc(sizeof(state_t));
    G->oneState = B;

    H->name = 'H';
    H->zeroState = (state_t*)malloc(sizeof(state_t));
    H->zeroState = H;
    H->oneState = (state_t*)malloc(sizeof(state_t));
    H->oneState = C;
   
    // Point currentstate to A
    cS = A; 

    // Making 1D array of pointers to print 
    state_t** arr = (state_t**)malloc(TOTAL * sizeof(state_t*));

    for (i = 0; i < TOTAL; i++) {
        arr[i] = (state_t*)malloc(TOTAL * sizeof(state_t));
    }
    *arr = A;
    *(arr+1) = B;
    *(arr+2) = C;
    *(arr+3) = D;
    *(arr+4) = E;
    *(arr+5) = F;
    *(arr+6) = G;
    *(arr+7) = H;
    
    fprintf(stdout, "\n***\nWelcome to state machine\n***\nInput options (case sensitive):\n");
    noCommands(cS);

    // LOOP runs until user inputs 'q'
    LOOP: 

    fprintf(stdout, "\n***\n");
    fprintf(stdout, "Please input args.\n");
    char inChar; 
    scanf(" %c", &inChar);
    
    int temp2;
    char tempChar;
    state_t *tempState;

    // Args to replay greeting and show current state
    if (inChar == 'r')
        noCommands(cS);

    // Args for oneZeroCommands
    if (inChar == '0')
        oneZeroCommands(0, cS);
    if (inChar == '1')
        oneZeroCommands(1, cS);

    // Args for print
    if (inChar == 'p')
        print(arr, TOTAL);

    // Args for garbage    
    if (inChar == 'g') {
        print(arr, TOTAL);
        garbage(arr, cS);
    }

    // Args for change
    if (inChar == 'c') {
        scanf(" %d", &temp2);
        scanf(" %c", &inChar);
        for (i = 0; i < TOTAL; i++) {
                    if (arr[i][0].name == inChar)
                        tempState = arr[i];
                }
        change(cS, temp2, tempState);
    }

    // Args for quit
    if (inChar == 'q') {
        fprintf(stdout, "Goodbye\n");    
        exit(0);
    }    

    // Args for delete
    if (inChar == 'd') {
        fprintf(stdout, "Input 0 to delete all garbage, otherwise input <A-H> to check status of specific state:\n");
        scanf(" %c", &inChar);
        if (inChar == '0')
            delete(0, 'z', arr, TOTAL);
        else 
           delete(1, inChar, arr, TOTAL);
    }
    
    goto LOOP;

    free(cS);
    free(A);
    free(B);
    free(C);
    free(D);
    free(E);
    free(F);
    free(G);
    for (i = 0; i < TOTAL; i++) {
        arr[i] = (state_t*)malloc(TOTAL * sizeof(state_t));
    }
    free(arr);

    exit(0);
}

// EFFECTS: stdout greets user with current state
void noCommands(state_t *currentState) { 
    fprintf(stdout, "---To change what the current state's zero state or one state value is: c <0 or 1> <A-H>\n");
    fprintf(stdout, "---To change current state to it's one or zero state: <0 or 1>\n");
    fprintf(stdout, "---To identify unreachable states: g\n");
    fprintf(stdout, "---To delete garbage or specified states: d or d <A-H>\n");
    fprintf(stdout, "---To quit: q\n");
    fprintf(stdout, "---To replay this message: r\n");
    fprintf(stdout, "***\nThe current state is: %c\n***\n", currentState->name);
}

// MODIFIES: currentState  
// EFFECTS: stdout currentState's nextState and then change current state to next state
void oneZeroCommands(int i, state_t *currentState) {
    if (i == 1) {
        fprintf(stdout, "The next state of \"%c\" is \"%c\"\n", currentState->name, currentState->oneState->name);
        cS = currentState->oneState;
        fprintf(stdout, "New current state is \"%c\"\n", cS->name);
    }        
    else if (i == 0) {
        fprintf(stdout, "The next state of \"%c\" is \"%c\"\n", currentState->name, currentState->zeroState->name);
        cS = currentState->zeroState;
        fprintf(stdout, "New current state is \"%c\"\n", cS->name);
    }
    else
        fprintf(stderr, "Incorrect input");
}

// EFFECTS: Prints all states and each states Zero state and One state
void print(state_t **arr, int size) {
    int i = 0;
    for(i = 0; i < size; i++) {
        if (*(arr+i) == NULL)
            fprintf(stderr, "Pointing to NULL");
        if ((*(arr+i))->name == 'z' || (*(arr+i))->name == ' ')
            continue;
        fprintf(stdout, "----\nSTATE: %c\nNextZeroState: %c\nNextOneState: %c\n", arr[i][0].name, (*(arr+i))->zeroState->name, (*(arr+i))->oneState->name); 
    }
}

// MODIFIES: cS
// EFFECTS: Changes oneState or zeroState of cs
void change(state_t *cs, int newZeroOrOne, state_t *newState) {
    if ((int)(newState->name) > 64 && (int)(newState->name < 73)) { // not sure why this method isn't working
        if (newZeroOrOne == 1) {
            cs->oneState = newState;
            fprintf(stdout, "One state successfully changed.");
        }
        if (newZeroOrOne == 0) {
            cs->zeroState = newState;
            fprintf(stdout, "Zero state successfully changed.");
        }
    }
    else
        fprintf(stdout, "Input bad");
}

// EFFECTS: Print all states that are reachable and unreachable from current state
void garbage(state_t **arr, state_t *cs) {
    char controlArr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    int size = TOTAL;
    int i = 0;
    int j = 0;
    int counter = 0;
    int counter2 = 0;

    garbageBuddy(cs); // recursive function that determines which states are reachable
    
    fprintf(stdout, "\nReachable states from (%c)'s perspective:", cs->name);
    for(i = 0; i < TOTAL2; i++) {
        if (staticControlArr[i] != 'z') { 
            fprintf(stdout, " %c ", staticControlArr[i]);
            counter++; 
        }
    }
    fprintf(stdout, "\n");

    for(i = 0; i < TOTAL; i++) {
        for(j = 0; j < TOTAL2; j++) {
            if (controlArr[i] == staticControlArr[j]) // replacing the control arrays elements with dummy variable 'z' if they exist in a temp state array
                controlArr[i] = 'z';
        }
    }
    if (controlArr[i] != 'z') 
            fprintf(stdout, "Garbage:");
    for(i = 0; i < TOTAL; i++) {
        if (controlArr[i] != 'z' && (*(arr+i))->name != ' ') {// if in local control array and not nameless (' ') in passed pointer array
            fprintf(stdout, " %c ", controlArr[i]);
            staticGarbageList[i] = controlArr[i];
        }
        else
            counter2++;
    }
    if (counter2 == TOTAL)
        fprintf(stdout, " No garbage\n");
    for (i = 0; i < TOTAL2; i++) {
        staticControlArr[i] = 'z';
    }
}

// MODIFIES: staticControlArr[] via garbageAdd()
// EFFECTS: Recursive function that adds availabe states to the staticControlArr[]
int garbageBuddy(state_t *currentState) {
    int i = 0;

    for (i = 0; i < TOTAL2; i++) {
        if (currentState->name == staticControlArr[i])
            return 0;
    }

    if (currentState->name == 'A' || currentState->name == 'B' || currentState->name == 'C' || currentState->name == 'D' ||
        currentState->name == 'E' || currentState->name == 'F' || currentState->name == 'G' || currentState->name == 'H') {
            garbageAdd(currentState->name);
            garbageBuddy(currentState->oneState);
            garbageBuddy(currentState->zeroState);
    }

    return 0;
} 

// MODIFES: staticControlArr[], static count
// EFFECTS: Adds letter name to available states
void garbageAdd(char c) {
    staticControlArr[staticCount] = c;
    staticCount++;
}

// MODIFIES: arr[][].name which is an array of pointers
// EFFECTS: Stdout's the staticGarbageList[] which reps the deleted states
void delete(int d, char c, state_t **arr, int size) {
    int i = 0;
    int j = 0;
    int counter = 0;

    if (d == 0) { // to delete all garbage states, if the state is on the staticGarbageList it is replaced with ' ', if any states removed counter becomes non-zero 
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if((*(arr+i))->zeroState->name == staticGarbageList[j]) {
                    (*(arr+i))->zeroState->name = ' ';
                    counter++;
                }
                if((*(arr+i))->oneState->name == staticGarbageList[j]) {
                    (*(arr+i))->oneState->name = ' ';
                    counter++;
                }
            }
        }
   } 

    if (counter == 0) { // checks counter to see if any states deleted
        fprintf(stdout, "\nNo states deleted.\n");
    }

    j = 0;
    for (i = 0; i < TOTAL; i++) { // is staticGarbageList is empty (all 'z') then skip printing list of deleted states
        if (staticGarbageList[i] == 'z')
            j++;
        if (j == TOTAL-1)
            goto SKIP;
    }

    fprintf(stdout, "Current list of deleted states: ");
    for (i = 0; i < TOTAL; i++) {
        if (staticGarbageList[i] != 'z')
            fprintf(stdout, " %c ", staticGarbageList[i]);
    }
    
    fprintf(stdout, "\n");

    SKIP:

    counter = 0;
    if (d == 1) { 

        for (i = 0; i < TOTAL; i++) {
            if (staticGarbageList[i] == c) {
                fprintf(stdout, "%c is deleted\n", c);
                counter++;
            }
        }
        if (counter == 0) 
            fprintf(stdout, "%c is not deleted\n", c);
    }
}
       



