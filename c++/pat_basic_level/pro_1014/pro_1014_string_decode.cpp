# include <iostream>
# include <string>
using namespace std;
int main() {
    string first, second, third, forth;
    cin>>first>>second>>third>>forth;
    string week[7] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    string cur_week_day = "MON";
    int hour = 0;
    int is_day = 1;
    for (int i = 0; i < first.length(); i++) {
        char tmp_a = first[i];
        if (i < second.length()) {
            char tmp_b = second[i];
            if (is_day == 1 && tmp_a == tmp_b && ('A' <= tmp_a && tmp_a <= 'G')) {
                int offset = tmp_a - 'A';
                cur_week_day = week[offset];
                is_day = 0;
            } else if (is_day == 0 && tmp_a == tmp_b) {
                if ('A' <= tmp_a && tmp_a <= 'N') {
                    hour = 10 + tmp_a - 'A';
                    break;
                } else if ('0' <= tmp_a && tmp_a <= '9') {
                    hour = tmp_a - '0';
                    break;
                }
            }
        }
    }
    int minute = 0;
    for (int i = 0; i < third.length(); i++) {
        char tmp_a = third[i];
        if (i < forth.length()) {
            char tmp_b = forth[i];
            if (tmp_a == tmp_b && (('a' <= tmp_a && tmp_a <= 'z') || ('A' <= tmp_a && tmp_a <= 'Z'))) {
                minute = i;
            }
        }
    }
    cout<<cur_week_day<<" ";
    if (hour < 10) {
        cout<<"0"<<hour<<":";
    } else {
        cout<<hour<<":";
    }
    if (minute < 10) {
        cout<<"0"<<minute<<endl;
    } else {
        cout<<minute<<endl;
    }
}
