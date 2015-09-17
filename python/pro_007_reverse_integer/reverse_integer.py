__author__ = 'laiconglin'
import math
import sys
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return x

        if x < 0:
            x = -x
            is_negative = 1
        else:
            is_negative = 0

        tmp_str = str(x)
        tmp_str = tmp_str[::-1]
        tmp_str_len = len(tmp_str)
        start_index = 0
        for i in xrange(0, tmp_str_len):
            if tmp_str[i] is '0':
                start_index = i
            else:
                break
        tmp_str = tmp_str[start_index:]
        max_int = (1 << 31) - 1
        min_int = (1 << 31)
        tmp_str_int_val = int(tmp_str)
        if tmp_str_int_val > min_int:
            return 0

        if tmp_str_int_val == min_int and is_negative == 0:
            return 0

        if is_negative is 1:
            tmp_str_int_val = -1 * tmp_str_int_val

        return tmp_str_int_val

a = Solution()
print a.reverse(123)
print a.reverse(-123)
print a.reverse(100)
print a.reverse(1000000003)
