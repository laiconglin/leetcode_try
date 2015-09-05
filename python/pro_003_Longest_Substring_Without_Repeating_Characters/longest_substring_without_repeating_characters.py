__author__ = 'laiconglin'
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_index = dict()
        if len(s) == 0:
            return 0

        max_len = 1
        uniq_len = 0
        start_unset_index = 0
        for i in range(0, len(s)):
            if s[i] not in char_index.keys():
                char_index[s[i]] = i
                uniq_len += 1
            else:
                tmp_len = i - char_index[s[i]]
                end_unset_index = char_index[s[i]]
                for unset_index in range(start_unset_index, end_unset_index + 1):
                    char_index.pop(s[unset_index])
                start_unset_index = end_unset_index + 1
                if tmp_len > max_len:
                    max_len = tmp_len
                if uniq_len > max_len:
                    max_len = uniq_len
                char_index[s[i]] = i
                uniq_len = len(char_index)

        if uniq_len > max_len:
            max_len = uniq_len

        return max_len

solution = Solution()

print solution.lengthOfLongestSubstring("aadvdvf")
print solution.lengthOfLongestSubstring("a")
print solution.lengthOfLongestSubstring("au")
print solution.lengthOfLongestSubstring("abcabcbb")
