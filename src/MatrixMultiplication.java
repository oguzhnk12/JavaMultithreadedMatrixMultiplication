import java.util.Arrays;
import java.util.Random;

public class MatrixMultiplication {

    final static int WIDTH = 100;
    final static int HEIGHT = 100;

    final static int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) {
        int[][] matrixA = arrangeMatrix();
        int[][] matrixB = arrangeMatrix();
        int[][] result = new int[HEIGHT][WIDTH];
        int[][][] originalArrays = new int[NUMBER_OF_THREADS][10][WIDTH];
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        Worker[] workers = new Worker[NUMBER_OF_THREADS];


        for (int index = 0; index < NUMBER_OF_THREADS; index++) {
            workers[index] = new Worker(matrixA, matrixB, index * 10);
            threads[index] = new Thread(workers[index]);
            threads[index].start();
        }
        try {
            for (int index = 0; index < NUMBER_OF_THREADS; index++) {
                threads[index].join();
                originalArrays[index] = workers[index].getResult();
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.arraycopy(originalArrays[i][j], 0, result[i * 10 + j], 0, WIDTH);
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] arrangeMatrix() {
        Random random = new Random();
        int randomNumber = 0;
        int[][] matrix = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                randomNumber = random.nextInt() % 10;
                if (randomNumber < 0) {
                    randomNumber = -randomNumber;
                }
                matrix[i][j] = randomNumber;
            }
        }
        return matrix;
    }

    public static int[][] concatArrays(int[][] array1, int[][] array2) {
        int[][] result = new int[array1.length + array2.length][];
        for (int i = 0; i < array1.length; i++) {
            result[i] = Arrays.copyOf(array1[i], array1[i].length);
        }
        for (int i = 0; i < array2.length; i++) {
            result[i + array1.length] = Arrays.copyOf(array2[i], array2[i].length);
        }
        return result;
    }

}