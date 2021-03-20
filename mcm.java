public class mcmSimple
{
    public static int matrixChainMultiplication(int[] dims, int i, int j, int[][] T)
    {
        if (j <= i + 1) {return 0;}
        int min = Integer.MAX_VALUE;
 
        if (T[i][j] == 0)
        {
            for (int k = i + 1; k <= j - 1; k++)
            {
                int cost = matrixChainMultiplication(dims, i, k, T);
                cost    += matrixChainMultiplication(dims, k, j, T);
                cost    += dims[i] * dims[k] * dims[j];
                if (cost < min) { min = cost; }
            }
            T[i][j] = min;
        }
        return T[i][j];
    }
 
    public static void main(String[] args)
    {
        int[] dims = { 10, 30, 5, 60 };
        int[][] T = new int[dims.length][dims.length];
        System.out.print("The minimum cost is " + matrixChainMultiplication(dims, 0, dims.length - 1, T));
 
    }
}
