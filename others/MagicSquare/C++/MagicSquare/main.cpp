#include <iostream>
#include <cstdlib>
#include <vector>
#include <cmath>

using namespace std;



bool isValidMSquare(vector<vector<int>> vec) {
    int firstRowSum = 0;
    int temp;
    for(int i=0; i<vec.size(); i++) {
        firstRowSum += vec[0][i];
    }
    
    // 2nd & 3rd row
    for(int i=1; i<3; i++) {
        temp = 0;
        for(int v=0; v<3; v++) {
            temp += vec[i][v];
        }
        if(temp != firstRowSum) {
            return 0;
        }
    }
    
    // 1st, 2nd and 3rd col
    for(int i=0; i<3; i++) {
        temp = 0;
        for(int v=0; v<3; v++) {
            temp += vec[v][i];
        }
        if(temp != firstRowSum) {
            return 0;
        }
    }
    
    // left to right diagonal 
    temp = 0;
    for(int i=0; i<3; i++) {
        temp += vec[i][i];
    }
    if(temp != firstRowSum) {
        return 0;
    }
    
    // right to left diagonal 
    temp = 0;
    for(int i=0; i<3; i++) {
        temp += vec[i][2-i];
    }
    if(temp != firstRowSum) {
        return 0;
    }
    
    // the given square is 3x3 magic square
    return 1;
}
int findLowCost(vector<vector<int>> vec) {
    
    vector<vector<int>> allMSquares = {
        {8, 3, 4, 1, 5, 9, 6, 7, 2},
        {4, 3, 8, 9, 5, 1, 2, 7, 6},
        {8, 1, 6, 3, 5, 7, 4, 9, 2},
        {6, 1, 8, 7, 5, 3, 2, 9, 4},
        {2, 9, 4, 7, 5, 3, 6, 1, 8},
        {4, 9, 2, 3, 5, 7, 8, 1, 6},
        {2, 7, 6, 9, 5, 1, 4, 3, 8},
        {6, 7, 2, 1, 5, 9, 8, 3, 4}
    };   
    
    int lesserCost = 10000;
    int total = 0;
    
    for(int i=0; i<allMSquares.size(); i++) {
        total = 0;
        for(int v=0; v<allMSquares[0].size(); v++) {
            int one = vec[v/3][v%3];
            int two = allMSquares[i][v];
            total += abs(one - two);
        }
        if(total < lesserCost) {
            lesserCost = total;
        }
    }
    return lesserCost;
}

int main(int argc, char** argv) {
    vector<int> vec1 = {4, 9, 2};
    vector<int> vec2 = {3, 5, 7};
    vector<int> vec3 = {8, 1, 5};
    vector<vector<int>> vec = {vec1, vec2, vec3};
    
    cout << findLowCost(vec);

    return 0;
}

