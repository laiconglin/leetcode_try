# coding=utf-8
__author__ = 'laiconglin'
class Solution(object):
    def myAtoi(self, str):
        """
        这道题感觉没啥意义啊。。。测试例子大部分比较奇葩
        :type str: str
        :rtype: int
        """
        str = str.strip()
        if str == '':
            return 0

        start_index = 0
        str_len = len(str)
        is_negative = 1
        if str[0] == '+' or str[0] == '-':
            if str_len == 1:
                return 0
            else:
                if str[0] == '-':
                    is_negative = -1
                start_index = 1
                if str[1] == '+' or str[1] == '-':
                    return 0

        end_index = -1
        for i in xrange(start_index, str_len):
            if str[i] < '0' or str[i] > '9':
                end_index = i
                break

        if start_index == end_index:
            return 0
        result = 0
        if end_index == -1:
            result = is_negative * int(str[start_index:])
        else:
            result = is_negative * int(str[start_index:end_index])

        if result >= 2147483648:
            return 2147483647
        elif result < -2147483648:
            return -2147483648
        else:
            return result

a = Solution()
#print a.myAtoi("")
#print a.myAtoi("+-2")
#print a.myAtoi("    010")
#print a.myAtoi("  -0012a42")
print a.myAtoi("abc")
print a.myAtoi("2147483648")
