/**
 *
 *when use "cout", will get time limit out, need use "printf"
 *
 */
# include <iostream>
# include <vector>
# include <algorithm>
# include <stdio.h>
using namespace std;
struct student {
    int number;
    int de;
    int cai;
    int total;
    int level;
};
typedef struct student stu;
bool myfunction (stu a, stu b) { 
    int a_total = a.total;
    int b_total = b.total;
    if (a.level != b.level) {
        return a.level < b.level;
    } else {
        if (a_total != b_total) {
            return a_total > b_total;
        } else {
            if (a.de != b.de) {
                return a.de > b.de;
            } else {
                return a.number < b.number;
            }
        }
    }
}

void show_student_list(vector<stu> stu_list) {
    for (int i = 0; i < stu_list.size(); i++) {
        if (stu_list[i].level == 5) {
            break;
        }
        printf("%d %d %d\n", stu_list[i].number, stu_list[i].de, stu_list[i].cai);
    }
}

int main() {
    int student_count, pass_score, good_score;
    cin>>student_count>>pass_score>>good_score;
    vector<stu> student_list;
    student_list.resize(student_count);
    int count = 0;
    for (int i = 0; i < student_count; i++) {
        cin>>student_list[i].number>>student_list[i].de>>student_list[i].cai;
        student_list[i].total = student_list[i].de + student_list[i].cai;
        if (student_list[i].de >= good_score && student_list[i].cai >= good_score) {
            student_list[i].level = 1;
            count++;
        } else if (student_list[i].de >= good_score && student_list[i].cai >= pass_score) {
            student_list[i].level = 2;
            count++;
        } else if (student_list[i].de >= pass_score && student_list[i].cai >= pass_score && student_list[i].de >= student_list[i].cai) {
            student_list[i].level = 3;
            count++;
        } else if (student_list[i].de >= pass_score && student_list[i].cai >= pass_score) {
            student_list[i].level = 4;
            count++;
        } else {
            student_list[i].level = 5;
        }
    }
    sort(student_list.begin(), student_list.end(), myfunction);
    cout<<count<<endl;
    show_student_list(student_list);
    return 0;
}
