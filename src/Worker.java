public class Worker implements Runnable{

    private int[][] matrixA;
    private int[][] matrixB;
    private int index;
    private int[][] result;
    public Worker(int[][] matrixA, int[][] matrixB, int index){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.index = index;
        this.result = new int[10][100];
    }

    public int[][] getResult() {
        return result;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int x = 0; x < 10; x++){
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sum += matrixA[x + index][j] * matrixB[j][i];
                }
                result[x][i] = sum;
                sum = 0;
            }
        }
    }
}
