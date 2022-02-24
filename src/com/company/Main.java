package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /// int[] array1D = new int[10];
        // int[] array1D = {1, 2, 3, 4, 5, 6};

        //int [][] array2D = new int[10][10];
        //char[][] array2D = {{'-', '*', '-', '-'}, {'-', '-', '*', '-'}, {'-', '*', '-', '-'}, {'*', '-', '*', '-'}};

        char[][] array2D = generateArray2D();


        Random random = new Random();

        int loop = random.nextInt(20) + 1;



        printArray(array2D);

        for (int l = 0; l < loop; l++) {
            nextGeneration(array2D);
        }

        System.out.println("After " + loop + " loop:");
        printArray(array2D);

    }


    private static char[][] generateArray2D() {
        char[][] live = new char[10][10];
        Random r = new Random();


        for (int i = 0; i < live.length; i++) {
            for (int j = 0; j < live[i].length; j++) {
                int randomInt = r.nextInt(2);
                if (randomInt == 0) {
                    live[i][j] = '-';
                } else {
                    live[i][j] = '*';
                }
            }
        }

        return live;
    }

    private static void nextGeneration(char[][] pr) {
        for (int i = 0; i < pr.length; i++) {
            for (int j = 0; j < pr[i].length; j++) {

                int left = 0;
                int right = pr[i].length - 1;
                int down = 0;
                int upp = pr.length - 1;


                int neighbors = 0;
                // pr [i][j] соседи = (i,j + 1) (i,j - 1) (i + 1, j) (i - 1, j) (i - 1, j + 1) (i + 1, j + 1) (i + 1, j - 1) (i - 1, j - 1)
                if (j + 1 <= right && pr[i][j + 1] == '*') {
                    neighbors++;
                }
                if (j - 1 >= left && pr[i][j - 1] == '*') {
                    neighbors++;
                }
                if (i + 1 <= upp && pr[i + 1][j] == '*') {
                    neighbors++;
                }
                if (i - 1 >= down && pr[i - 1][j] == '*') {
                    neighbors++;
                }
                if (i - 1 >= down && j + 1 <= right && pr[i - 1][j + 1] == '*') {
                    neighbors++;
                }
                if (i + 1 <= upp && j + 1 <= right && pr[i + 1][j + 1] == '*') {
                    neighbors++;
                }
                if (i + 1 <= upp && j - 1 >= left && pr[i + 1][j - 1] == '*') {
                    neighbors++;
                }
                if (i - 1 >= down && j - 1 >= left && pr[i - 1][j - 1] == '*') {
                    neighbors++;
                }

                if (pr[i][j] == '-' && neighbors == 3) {
                    pr[i][j] = '*';
                } else if (pr[i][j] == '*' && neighbors < 2 || neighbors > 3) {
                    pr[i][j] = '-';
                }
            }


        }

    }

    private static void printArray(char[][] array2D) {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n \n");
    }
}