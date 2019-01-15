import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class testGrupoEsoft {

	public static void main(String[] args) {
		
		// Read rows and columns for the matrix
		int n=-1, m=-1;
		Scanner in = new Scanner(System.in);
		System.out.println("Let's create a matrix\n");
		do {
			System.out.printf("Enter the number of rows (greater than 2).\n");
			System.out.print("Rows: ");
			while(!in.hasNextInt()) {
				System.out.println("This is not an integer.");
				System.out.print("Rows: ");
				in.next();
			}
			n = in.nextInt();
		} while (!(n>2));
		do {	
			System.out.printf("Enter the number of columns (greater than 2).\n");
			System.out.print("Columns: ");
			while(!in.hasNextInt()) {
				System.out.println("This is not an integer.");
				System.out.print("Columns: ");
				in.next();
			}
			m = in.nextInt();
		} while (!(m>2));
		System.out.printf("\nmatrix: %dx%d\n",n,m);
		
		
		// Create array nxm
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = ThreadLocalRandom.current().nextInt(1, n*m + 1);;
			}
		}
		// print matrix
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(matrix[i][j] + "\t");
		    }
		    System.out.println();
		}
		
		
		// Calculate total of columns
		int totalColumns[] = new int[m];
	    System.out.println("--- Total Columns ---");
	    for (int j = 0; j < m; j++) {
	    	totalColumns[j] = 0;
	    	for (int i = 0; i < matrix.length; i++) {
		    	totalColumns[j] = totalColumns[j] + matrix[i][j];
	    	}
	    	System.out.print(totalColumns[j] + "\t");
	    }

		// Average even columns
	    int columnsCounter = 0, sumOddColumns = 0;
	    float averageOddColumns;
	    for (int j = 1; j < m; j+=2) {
	    	sumOddColumns = sumOddColumns + totalColumns[j];
	    	columnsCounter++;
	    }
	    averageOddColumns = (float)sumOddColumns / (float)columnsCounter;
	    System.out.printf("\nAverage even columns: %.2f\n",averageOddColumns);
	    
	    // Columns with total greater than $averageOddColumns
	    int columnsGreaterAverage = 0;
	    for (int j = 0; j < m; j++) {
	    	if(totalColumns[j] > averageOddColumns)
	    	columnsGreaterAverage++;
	    }
	    System.out.printf("Columns with a total greater than %.2f : %d",averageOddColumns,columnsGreaterAverage);
	}
}
