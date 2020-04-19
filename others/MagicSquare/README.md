## Magic Square
    * the same number of row and column is considered to be N.
    * the sum of row, column, and both diagonal needs to be Constant = N(N^2+1)/2

    1. 1 is stored at position (N/2, N-1);
    1. (i, j) => (i-1, j+1)
        * if(i == -1) => i = N-1
        * if(j == N) => j = 0
        * if(i == -1, j == N) => (0, N-2)
    1. and if(position is already occupied) => (i += 1, j -= 2) and go to the next iteration