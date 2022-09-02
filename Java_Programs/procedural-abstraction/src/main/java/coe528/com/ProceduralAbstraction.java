package coe528.com;

public class ProceduralAbstraction {
    private final static int MAX_SIZE = 10;

    //Requires: None
    //Modifies: None
    //Effects: Returns the smallest positive integer n for which n!
    //         (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    //         integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int num = 1;
        int i = 0;

        for (i = 1; i <= MAX_SIZE; i++) {
            num *= i;
            //System.out.println("Fact: " + num);
            if (num >= x)
                break;
        }

        System.out.println("The smallest factorial that equals or is greater than " + x + " is " + i + "!");
        return i;
    }

    //Requires: None
    //Modifies: None
    //Effects: If the matrix arr satisfies Nice property, prints the sum and
    //         returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        // nice matrix is square, sum of ints row, columns, and diagonals all same
        int rows = arr.length - 1;
        int cols = arr[rows].length - 1;
        int rowSum = 0;
        int colSum = 0;
        int temp = 0;
        int temp2 = 0;
        int diagSum = 0;
        int diagSum2 = 0;

        // Checking to see if matirix is square
        if (rows == cols) {
            System.out.println("Matrix is square");
        }
        else { 
            System.out.println("Matrix is not square");
            return false;
        }

        // Checking to see if the rows sum to the same values
        for (int i = 0; i <= rows; i++) {
            rowSum = 0;
            for (int j = 0; j <= cols; j++) {
                    rowSum += arr[i][j];
            }
            if (i % 2 == 0 || i == 0)
                temp = rowSum;
            else 
                temp2 = rowSum;
            if ( i > 0 && temp != temp2) {
                System.out.println("Rows dont sum.");
                return false;
            }
            //System.out.println(rowSum);
        } 
        temp = temp2 = 0;
       
        // Checking to see if the cols sum to the same values
        for (int i = 0; i <= rows; i++) {
            colSum = 0;
            for (int j = 0; j <= cols; j++) {
                    colSum += arr[j][i];
            }
            if (i % 2 == 0 || i == 0)
                temp = colSum;
            else 
                temp2 = colSum;
            if ( i > 0 && temp != temp2) {
                System.out.println("Cols dont sum.");
                return false;
            }
            //System.out.println(colSum);
        }
        temp = temp2 = 0;
        
        // Checking to see if the diagonals have the same values
        for (int i = 0; i <= rows; i++) 
            diagSum += arr[i][i];
            
        //for (int i = 0; i <= rows; i++) 
        for (int j = cols; j >= 0; j--) {
            diagSum2 += arr[temp][j];
            temp++;
        }

        if (diagSum != diagSum2) {
            System.out.println("Diagonals do not equal each other");
            return false;
        }

        System.out.println("Matrix is nice and the sum is: " + rowSum);
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(reverseFactorial(24));
        System.out.println(reverseFactorial(119));
        System.out.println(reverseFactorial(1));
        System.out.println(reverseFactorial(0));
        System.out.println(reverseFactorial(1722));
        System.out.println("");

        int [][] a = {  // Not nice
        { 1, 0, 0},
        { 0, 1, 0},
        };
        int [][] b = {  // Nice
        { -3, 3, 3, -3},
        { 3, -3, -3, 3},
        { 3, -3, -3, 3},
        { -3, 3, 3, -3}
        };
        int [][] c = { // Not nice`
        { 1, 0,},
        { 0, 1,},
        };
        int [][] d = { // Not nice
        { 0, 1, 0},
        { 0, 1, 0},
        { 0, 1, 0}
        };
        int [][] e = { // Not nice
        { 1, 1, 1},
        { 0, 0, 0},
        { 0, 0, 0}
        };
        int [][] f = { // Nice
        { -1, -1, -1},
        { -1, -1, -1},
        { -1, -1, -1}
        };
        int [][] g = { // Nice
        { 2, 7, 6},
        { 9, 5, 1},
        { 4, 3, 8}
        };
        
        System.out.println("Is matrix a nice? ");
        System.out.println(isMatrixNice(a));
        System.out.println("");
        System.out.println("Is matrix b nice? ");
        System.out.println(isMatrixNice(b));
        System.out.println("");
        System.out.println("Is matrix c nice? ");
        System.out.println(isMatrixNice(c));
        System.out.println("");
        System.out.println("Is matrix d nice? ");
        System.out.println(isMatrixNice(d));
        System.out.println("");
        System.out.println("Is matrix e nice? ");
        System.out.println(isMatrixNice(e));
        System.out.println("");
        System.out.println("Is matrix f nice? ");
        System.out.println(isMatrixNice(f));
        System.out.println("");
        System.out.println("Is matrix g nice? ");
        System.out.println(isMatrixNice(g));
        
    }
}
