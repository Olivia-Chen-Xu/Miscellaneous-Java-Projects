// A magic square is a square matrix of consecutive numbers, 
// such that the numbers in the rows, the numbers in the columns, and the numbers in the diagonals add up to the same sum. 

import java.util.Scanner;
import java.text.DecimalFormat;

public class MagicSquareGenerator {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();
      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
      magic.checkRows();
      magic.checkColumns(); 
      magic.checkDiagonals(); 
   }
}

class MagicSquare {
   private int size, row, col;
   private int[][] magic;
   private DecimalFormat output;

   public MagicSquare(int s) {
      size = s;
      magic = new int[size][size];
      output = new DecimalFormat("000");
   }

   public void computeMagicSquare() {
      magic[0][size / 2] = 1;
      row = 0;
      col = size / 2;
      magic[row][col] = 1;

      for (int k = 2; k <= size * size; k++) {
         if ((k - 1) % size == 0) {
            row++;
         } else if (col > size - 2) {
            col = 0;
            row--;
         } else if (row < 1) {
            row = size - 1;
            col++;
         } else {
            row--;
            col++;
         }
         // System.out.print(row + "." + col + " ");
         magic[row][col] = k;
      }

   }

   public void displayMagicSquare() {
      System.out.println();
      System.out.println(size + "x" + size + " Magic Square");
      System.out.println("==================");
      System.out.println();
      for (int[] r : magic) {
         for (int c : r)
            System.out.print(output.format(c) + " ");
         System.out.println();
      }
   }

   public void checkRows() {
      System.out.println();
      System.out.println("Checking Rows");
      System.out.println("=============");
      System.out.println();

      int sum;
      for (int r = 0; r < size; r++) {
         sum = 0;
         for (int c = 0; c < size - 1; c++) {
            System.out.print(output.format(magic[r][c]) + "+");
            sum += magic[r][c];
         }
         System.out.print(output.format(magic[r][size - 1]));
         sum += magic[r][size - 1];
         System.out.print(" = " + sum);
         System.out.println();
      }
   }

   public void checkColumns() {
      System.out.println();
      System.out.println("Checking Columns");
      System.out.println("================");
      System.out.println();

      int sum;
      for (int c = 0; c < size; c++) {
         sum = 0;
         for (int r = 0; r < size - 1; r++) {
            System.out.print(output.format(magic[r][c]) + "+");
            sum += magic[r][c];
         }
         System.out.print(output.format(magic[size - 1][c]));
         sum += magic[size - 1][c];
         System.out.print(" = " + sum);
         System.out.println();
      }
   }

   public void checkDiagonals() {
      System.out.println();
      System.out.println("Checking Diagonals");
      System.out.println("==================");
      System.out.println();

      int sum = 0;
      for (int k = 0; k < size - 1; k++) {
         System.out.print(output.format(magic[0 + k][0 + k]) + "+");
         sum += magic[0 + k][0 + k];
      }
      System.out.print(output.format(magic[size - 1][size - 1]));
      sum += magic[size - 1][size - 1];
      System.out.print(" = " + sum);
      System.out.println();

      sum = 0;
      for (int k = 0; k < size - 1; k++) {
         System.out.print(output.format(magic[0 + k][size - 1 - k]) + "+");
         sum += magic[0 + k][size - 1 - k];
      }
      System.out.print(output.format(magic[size - 1][0]));
      sum += magic[size - 1][0];
      System.out.print(" = " + sum);
      System.out.println();
   }

}
