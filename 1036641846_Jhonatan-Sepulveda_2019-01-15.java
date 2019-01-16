import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestGrupoEsoft {

	public static void main(String[] args) {
		
		// Read rows and columns for the array
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
		
		
		// Create n x m array
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = ThreadLocalRandom.current().nextInt(1, n*m + 1);;
			}
		}
		// print array
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        System.out.print(matrix[i][j] + "\t");
		    }
		    System.out.println();
		}
		
		
		// Calculate total for every column
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
	    float averageEvenColumns;
	    for (int j = 1; j < m; j+=2) {
	    	sumOddColumns = sumOddColumns + totalColumns[j];
	    	columnsCounter++;
	    }
	    averageEvenColumns = (float)sumOddColumns / (float)columnsCounter;
	    System.out.printf("\nAverage even columns: %.2f\n",averageEvenColumns);
	    
	    // Columns with total greater than $averageOevenColumns
	    int columnsGreaterAverage = 0;
	    for (int j = 0; j < m; j++) {
	    	if(totalColumns[j] > averageEvenColumns)
	    	columnsGreaterAverage++;
	    }
	    System.out.printf("Columns with a total greater than %.2f : %d",averageEvenColumns,columnsGreaterAverage);
	}
}

/** In the conditions, it is asked to consider the average of even columns
 * In the Example, the average for odd columns is calculated
 * In the example "Cantidad de columnas cuyo total es mayor que 12 = 1" is not true
 * 
 * IMPORTANT: I counted the columns whose total is greater than the average of odd columns.  
 */
