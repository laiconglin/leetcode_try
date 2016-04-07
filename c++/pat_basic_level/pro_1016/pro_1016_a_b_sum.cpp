# include <iostream>
# include <string>
using namespace std;
int main() {
    string a_str, b_str;
    char a, b;
    cin>>a_str>>a>>b_str>>b;
    int p_a = 0, p_b = 0;
    int power_a = 1, power_b = 1;
    for(int i = 0; i < a_str.length(); i++) {
        if (a_str[i] == a) {
           p_a = p_a + (a - '0') * power_a;
           power_a = power_a * 10;
        }
    }
    for(int i = 0; i < b_str.length(); i++) {
        if (b_str[i] == b) {
           p_b = p_b + (b - '0') * power_b;
           power_b = power_b * 10;
        }
    }
    cout<<(p_a + p_b)<<endl;
    return 0;
}
