#include <cstdlib>
#include <stdio.h>

using namespace std;

int fib(int n) {
    int f[n + 1];
    int i;

    f[0] = 0;
    f[1] = 1;

    for (i = 2; i <= n; i++) {
        f[i] = f[i - 1] + f[i - 2];
    }

    return f[n];
}

int main(int argc, char** argv) {
    int n = 60;
    for(int i=0; i<n; i++) {
        printf("[fib: %d] ==> %d\n", i, fib(i));
    }
    
    return 0;
}

