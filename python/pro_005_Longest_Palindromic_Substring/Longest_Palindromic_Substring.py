__author__ = 'laiconglin'

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        str_len = len(s)
        max_pal_len = 0
        max_pal = ''
        if str_len <= 1:
            return s

        alphabet_hash = dict()
        for i in range(0, str_len):
            if s[i] not in alphabet_hash.keys():
                alphabet_hash[s[i]] = [i]
            else:
                tmp_index_list = alphabet_hash[s[i]]
                tmp_index_list.append(i)
                alphabet_hash[s[i]] = tmp_index_list

        next_start_index = 0
        max_pal_start_index = -1
        max_pal_end_index = -1
        for i in range(0, str_len):
            cur_char_index_list = alphabet_hash[s[i]]
            cur_char_max_index = cur_char_index_list[len(cur_char_index_list) - 1]
            if max_pal_start_index != -1 and max_pal_end_index != -1:
                if max_pal_start_index <= i and cur_char_max_index < max_pal_end_index:
                    continue
            for j in range(len(cur_char_index_list) - 1, -1, -1):
                stop_index = cur_char_index_list[j] + 1
                #print "%i, %i" % (i, stop_index)
                if stop_index <= i or cur_char_index_list[j] < next_start_index:
                    break
                tmp_str = s[i:stop_index]
                if self.is_palindrome_second(tmp_str):
                    next_start_index = i + len(tmp_str)
                    if len(tmp_str) > max_pal_len:
                        max_pal = tmp_str
                        max_pal_len = len(tmp_str)
                        max_pal_start_index = i
                        max_pal_end_index = stop_index
                        break

        return max_pal

    def is_palindrome_first(self, s):
        """
        :type s: str
        :rtype: bool
        """
        str_len = len(s)
        is_pal = True
        for i in range(0, str_len/2):
            if s[i] != s[str_len - i - 1]:
                is_pal = False
                break
        return is_pal

    def is_palindrome_second(self, s):
        """
        :type s: str
        :rtype: bool
        """
        reverse_str = s[::-1]
        return s == reverse_str


a = Solution()
#print a.longestPalindrome("ab")
#print a.longestPalindrome("mabcbaxxn")
#print a.longestPalindrome("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg")
#print a.longestPalindrome("aaaabbaaa")
print a.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
