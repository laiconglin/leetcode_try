# include <iostream>
# include <cmath>
using namespace std;
int main() {
    int first, second;
    cin>>first>>second;
    int count = 105773;
    int * nums = new int[count];
    for (int i = 0; i < count; i++) {
        nums[i] = i;
    }
    int i_range = (int)sqrt(count) + 1;
    for (int i = 2; i < i_range; i++) {
        for(int j = i; j < count; j++) {
            int tmp_index = i * j;
            if (tmp_index >= count) {
                break;
            }
            nums[tmp_index] = 0;
        }
    }
    int prime_count = 0;
    int print_count = 0;
    for (int i = 2; i < count; i++) {
        if (nums[i] > 0) {
            prime_count++;
            if (prime_count < first) {
                continue;
            }
            if (prime_count > second) {
                break;
            }
            cout<<nums[i];
            print_count++;
            if (prime_count == second) {
                cout<<endl;
            } else if (print_count % 10 == 0) {
                cout<<endl;
            } else {
                cout<<" ";
            }
        }
    }
    return 0;
}
