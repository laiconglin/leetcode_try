# include <iostream>
# include <cmath>
using namespace std;
int is_primer(int num) {
    int range = (int)sqrt(num);
    if (num == 2 || num == 3) {
        return 1;
    }
    int is_primer_num = 1;
    for (int i = 2; i <= range; i++) {
        if (num % i == 0) {
            is_primer_num = 0;
            break;
        }
    }
    return is_primer_num;
}
int main() {
    int first, second;
    cin>>first>>second;
    int prime_count = 0;
    int print_count = 0;
    int cur_num = 1;
    while (prime_count <= second) {
        cur_num++;
        if (is_primer(cur_num)) {
            prime_count++;
            if (prime_count < first) {
                continue;
            }
            if (prime_count > second) {
                break;
            }
            cout<<cur_num;;
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
