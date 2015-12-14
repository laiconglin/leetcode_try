__author__ = 'laiconglin'

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        #print "s:%s, p:%s" % (s, p)
        s_len = len(s)
        p_len = len(p)
        if p_len == 0:
            return s_len == 0
        elif p_len == 1:
            if s_len == 1:
                if p == '.' or s == p:
                    return True
                else:
                    return False
            else:
                return False
        elif p_len == 2:
            if p == '.*':
                return True
            elif p[1] == "*":
                return s.count(p[0]) == s_len or s_len == 0

        if s_len == 0:
            if p_len >= 2 and p[1] == '*':
                return self.isMatch(s, p[2:])
            else:
                return p_len == 0

        is_match = False

        i = 0
        cur_reg_char = p[i]
        next_reg_char = p[i+1]
        cur_reg_pair = p[i:i+2]
        if cur_reg_pair == ".*":
            for j in range(0, s_len + 1, 1):
                tmp_match = self.isMatch(s[j:], p[2:])
                if tmp_match is True:
                    is_match = True
                    break
        elif cur_reg_pair != ".*" and next_reg_char == "*":
            j = 0
            if s[j] == cur_reg_char:
                if p_len >= 4 and p[2:4] == cur_reg_pair:
                    tmp_match = self.isMatch(s[j:], p[2:])
                else:
                    tmp_match = self.isMatch(s[j+1:], p[0:]) or self.isMatch(s[j:], p[2:])
            else:
                tmp_match = self.isMatch(s[j:], p[2:])

            if tmp_match is True:
                is_match = True

        elif cur_reg_char == "." or cur_reg_char == s[0]:
            tmp_match = self.isMatch(s[1:], p[1:])
            if tmp_match is True:
                is_match = True
        else:
            is_match = False

        return is_match

a = Solution()
#print(a.isMatch("aaa", "a*a"))

#print(a.isMatch("aa", "a"))
#print(a.isMatch("aa", "aa"))
#print(a.isMatch("aaa", "aa"))
#print(a.isMatch("aa", "a*"))
#print(a.isMatch("baa", "ba.*"))
#print(a.isMatch("aab", "c*a*b*"))
#print(a.isMatch("a", "ab*"))

#print(a.isMatch("bbbba", ".*a*a"))

#print(a.isMatch("a", "a*a"))

#print(a.isMatch("aaaaaaaaaaaaab", ".*.*.*.*.*.*.*.*.*.*b"))
#print(a.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"))


#print(a.isMatch("", "a*c*"))

print(a.isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"))
