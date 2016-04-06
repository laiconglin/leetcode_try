# include <iostream>
# include <cmath>
using namespace std;
int main() {
    int first, second;
    int count = 115773;
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
    cout<<"int nums[10000] = {";
    for (int i = 2; i < count; i++) {
        if (nums[i] > 0) {
            prime_count++;
            if (prime_count > 10000) {
                break;
            }
            cout<<nums[i];
            if (prime_count != 10000) {
                cout<<", ";
            } else {
                cout<<"};"<<endl;
            }
        }
    }
    return 0;
}
