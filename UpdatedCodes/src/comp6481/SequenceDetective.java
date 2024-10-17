package comp6481;

import java.util.Scanner;

public class SequenceDetective {
	    public static int patternSearch(int[][] grid, int[] numbers) {
	        int ctr = 0;
	    	int row = grid.length;
	        int col = grid[0].length;
	        int len = numbers.length;
	    
	        int[][] directions = {
	            {0, -1}, // Left
	            {0, 1},  // Right
	            {-1, 0}, // Up
	            {1, 0},  // Down
	            {-1, -1},// Diagonal left-up
	            {-1, 1}, // Diagonal right-up
	            {1, -1}, // Diagonal left-down
	            {1, 1}   // Diagonal right-down
	        };
	    
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                for (int dir = 0; dir < 8; dir++) {
	                    int r = i, c = j;
	                    int k;
	    
	                    for (k = 0; k < len; k++) {
	                        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != numbers[k]) {
	                            break;
	                        }
	    
	                        r += directions[dir][0];
	                        c += directions[dir][1];
	                    }
	    
	                    if (k == len) {
	                        
	                        String printString = "";

	                        for (int l = 0; l < len; l++) {
	                            printString += "(" + (i + l * directions[dir][0]) + "," + (j + l * directions[dir][1]) + "),";
	                        }


	                        System.out.println(printString.substring(0 , printString.length() - 1));    
	                        ctr++;
	 

	                    }
	                }
	            }
	        }
	        return ctr;
	    }

	    public static void main(String[] args){
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of rows: ");
	        int row = Integer.parseInt(scanner.nextLine().trim());

	        System.out.print("Enter the number of columns: ");
	        int col = Integer.parseInt(scanner.nextLine().trim());

	        int[][] grid = new int[row][col ];

	        System.out.println("Enter the elements of the array:");
	        for (int i = 0; i < row; i++) {
	            String temp = scanner.nextLine().trim();

	            for (int j = 0; j < col; j++) {
	                grid[i][j] = Integer.parseInt(temp.split(" ")[j]);
	            }
	        }

	        System.out.print("Enter the word to search: ");
	        String word = scanner.nextLine();
	        String[] temp = word.split(" ");
	        int[] numbers = new int[temp.length];

	        for(int i=0;i<numbers.length;i++){
	            numbers[i] = Integer.parseInt(temp[i]);
	        } 

	        int found;
	        found = patternSearch(grid , numbers);
	        if (found == 0)
	        	System.out.println("Nothing found");
	        else
	        	System.out.println("Detective found " + found + " occurrences");
	    }
}


/*
Test Case 1 
Enter the number of rows: 9
Enter the number of columns: 8
Enter the elements of the array:
4 9 2 4 3 7 4 7
2 3 4 3 5 3 8 8
1 1 2 2 2 7 9 9
4 3 2 1 2 3 4 10
10 9 2 2 2 9 12 1
8 3 7 3 3 3 13 2
4 9 8 4 4 8 4 4
3 8 7 1 0 2 1 9
3 1 2 3 4 5 6 7
Enter the word to search: 1 2 3 4
(3,3),(3,2),(3,1),(3,0)
(3,3),(3,4),(3,5),(3,6)
(3,3),(2,3),(1,3),(0,3)
(3,3),(4,3),(5,3),(6,3)
(3,3),(2,2),(1,1),(0,0)
(3,3),(2,4),(1,5),(0,6)
(3,3),(4,2),(5,1),(6,0)
(3,3),(4,4),(5,5),(6,6)
(8,1),(8,2),(8,3),(8,4)
Detective found 9 occurrences
*/

/* Test Case 2
Enter the number of rows: 2
Enter the number of columns: 3
Enter the elements of the array:
1 2 1 
1 2 1
Enter the word to search: 1 2 1
(0,0),(0,1),(0,2)
(0,2),(0,1),(0,0)
(1,0),(1,1),(1,2)
(1,2),(1,1),(1,0)
Detective found 4 occurrences

*/

/* Test Case 3
Enter the number of rows: 3
Enter the number of columns: 3
Enter the elements of the array:
1 2 1 
1 2 1 
1 2 1 
Enter the word to search: 1 2 1 
(0,0),(0,1),(0,2)
(0,0),(1,1),(2,2)
(0,2),(0,1),(0,0)
(0,2),(1,1),(2,0)
(1,0),(1,1),(1,2)
(1,2),(1,1),(1,0)
(2,0),(2,1),(2,2)
(2,0),(1,1),(0,2)
(2,2),(2,1),(2,0)
(2,2),(1,1),(0,0)
Detective found 10 occurrences
*/

/*Test Case 4 
Enter the number of rows: 3
Enter the number of columns: 2
Enter the elements of the array:
3 3
3 3
3 3
Enter the word to search: 3 3 
(0,0),(0,1)
(0,0),(1,0)
(0,0),(1,1)
(0,1),(0,0)
(0,1),(1,1)
(0,1),(1,0)
(1,0),(1,1)
(1,0),(0,0)
(1,0),(2,0)
(1,0),(0,1)
(1,0),(2,1)
(1,1),(1,0)
(1,1),(0,1)
(1,1),(2,1)
(1,1),(0,0)
(1,1),(2,0)
(2,0),(2,1)
(2,0),(1,0)
(2,0),(1,1)
(2,1),(2,0)
(2,1),(1,1)
(2,1),(1,0)
Detective found 22 occurrences

*/

/*Test Case 5
 Enter the number of rows: 4
Enter the number of columns: 2
Enter the elements of the array:
9 5 
0 0 
0 0 
1 0 
Enter the word to search: 9 9
Nothing found
 */



