#ifdef WINDOWS
#include <direct.h>
#define GetCurrentDir _getcwd
#else
#include <unistd.h>
#define GetCurrentDir getcwd
#endif

#include <cstdlib>
#include <iostream>
#include <fstream>


using namespace std;

int findPath(int i, int j);
void recording();
string get_current_dir();

int maze[4][4] = {
    1, 1, 0, 1,
    1, 0, 1, 0,
    1, 1, 1, 0,
    0, 0, 1, 1,
};

int path[4][4] = {
    0, 0, 0, 0,
    0, 0, 0, 0,
    0, 0, 0, 0,
    0, 0, 0, 0,
};

int array_size = 4;

int main(int argc, char** argv) {

    findPath(0, 0);
    
    for(int i =0; i<array_size; i++) {
        for(int s=0; s<array_size; s++) {
            printf("%d ", path[i][s]);
        }
        cout << "\n";
    }
    return 0;
}

int findPath(int i, int j) {
    recording();
    if (i == array_size - 1 && j == array_size - 1) {
        path[i][j] = 7;
        // reach the destination. right bottom corner
        return 1;
    }

    if (maze[i][j] == 1) {
        // keep a path record in path matrix
        path[i][j] = 1;
                
        if(findPath(i, j + 1) == 1) {
            // there is a path going to right
            return 1;
        }
        
        if(findPath(i+1, j) == 1) {
            // there is a path going down
            return 1;
        }
        
        // backtracking
        path[i][j] = 0;
    }
    return 0;
}

void recording() {
    string current_dir = get_current_dir();
    
    ofstream file;
    
    file.open(current_dir + "/path_records.txt", ios_base::app);
   
    for(int i=0; i<array_size; i++) {
        for(int s=0; s<array_size; s++) {
            file << path[i][s] << " ";
        }
        file << "\n";
    }
    file << "\n\n========================================\n\n\n";
    file.close();
}

string get_current_dir() {
   char buff[FILENAME_MAX]; //create string buffer to hold path
   GetCurrentDir( buff, FILENAME_MAX );
   string current_working_dir(buff);
   return current_working_dir;
}
// https://www.tutorialspoint.com/find-out-the-current-working-directory-in-c-cplusplus