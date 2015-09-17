__author__ = 'laiconglin'
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        str_x = str(x)
        return str_x == str_x[::-1]

    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        str_x = str(x)
        return str_x == str_x[::-1]
    def isPalindromeSecond(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        if x < 10:
            return True
        reverse_x = 0
        old_x = x
        if x % 10 is 0:
            return False

        while x > 0:
            reverse_x = (10 * reverse_x) + (x % 10)
            x /= 10

        return reverse_x == old_x

a = Solution()

print a.isPalindrome(12321)
print a.isPalindrome(10)
print a.isPalindrome(123)
