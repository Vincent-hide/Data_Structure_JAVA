#include <cstdlib>
#include <string>
#include <stdio.h>


int countFrequency(std::string &pattern, std::string &txt);

int main(int argc, char** argv) {

    std::string txt = "Hi, Hide";
    std::string pattern = "Hi";
    printf("There is %d occurrences", countFrequency(pattern, txt));

    return 0;
}

int countFrequency(std::string &pattern, std::string &txt) {
    int patternSize = pattern.length();
    int textSize = txt.length();
    int count = 0;

    for (int i = 0; i <= textSize - patternSize; i++) {
        int k;
        for (k = 0; k < patternSize; k++) {
            if (txt[i + k] != pattern[k]) {
                break;
            }
        }

        if (k == patternSize) {
            count++;
            k = 0;
        }

    }

    return count;
}