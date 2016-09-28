#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

typedef pair<string, string> name;

int N;
vector<name> names;
int best_of_length[50004];
int max_lis;

int main() {
    int T;
    cin >> T;
    while (T-- > 0) {
        names.clear();
        cin >> N;
        string first, last;
        for (int i = 0; i < N; ++i) {
            cin >> first >> last;
            // Change the first letter to lowercase
            first[0] += 'a' - 'A';
            last[0] += 'a' - 'A';
            names.push_back(make_pair(last, first));
        }

        best_of_length[1] = 0;
        max_lis = 1;

        for (int i = 1; i < N; ++i) {
            // binary search to find the longest sequence this can be a part of
            if (names[i] < names[best_of_length[1]]) {
                best_of_length[1] = i;
            } else if (names[i] > names[best_of_length[max_lis]]) {
                ++max_lis;
                best_of_length[max_lis] = i;
            } else {
                int lo = 1;
                int hi = max_lis;
                while (lo + 1 < hi) {
                    int mid = (lo + hi) >> 1;
                    if (names[i] > names[best_of_length[mid]]) {
                        lo = mid;
                    } else {
                        hi = mid;
                    }
                }

                best_of_length[hi] = i;
            }
        }

        cout << (N - max_lis) << '\n';
    }
    return 0;
}
