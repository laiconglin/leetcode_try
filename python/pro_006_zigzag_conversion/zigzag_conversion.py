__author__ = 'laiconglin'
import math
class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        #有很多边界条件需要考虑
        s_len = len(s)
        if s_len <= numRows or numRows == 1:
            return s
        col_num = int(math.ceil(s_len / (numRows - 1))) + 1
        matrix = [([''] * col_num) for i in xrange(0, numRows)]

        for i in xrange(0, s_len):
            cur_char = s[i]
            tmp_col = int(math.ceil(i / (numRows - 1)))
            if tmp_col % 2 is 0:
                if tmp_col is 0:
                    remain = i
                else:
                    remain = i - (numRows - 1) * tmp_col
                matrix[remain][tmp_col] = cur_char
            else:
                remain = int((numRows - 1 - (i - (numRows - 1) * tmp_col)))
                matrix[remain][tmp_col] = cur_char

        res = []
        for i in xrange(0, numRows):
            for j in xrange(0, col_num):
                if matrix[i][j] is not '':
                    res.append(matrix[i][j])

        return ''.join(res)


a = Solution()
print a.convert("PAYPALISHIRING", 3)
