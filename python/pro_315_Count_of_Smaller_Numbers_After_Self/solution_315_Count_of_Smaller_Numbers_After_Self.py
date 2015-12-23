__author__ = 'laiconglin'


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.count = 1


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums_size = len(nums)
        if nums_size == 0:
            return []

        root = TreeNode(nums[nums_size - 1])
        result = list()
        result.append(0)
        for i in xrange(nums_size - 2, -1, -1):
            tmp_count = self.insertNode(root, nums[i])
            result.append(tmp_count)

        return result.reverse()
    def insertNode(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: count: int
        """
        tmp_count = 0
        cur = root
        while True:
            if val <= cur.val:
                cur.count += 1
                if cur.left is None:
                    cur.left = TreeNode(val)
                    break
                else:
                    cur = cur.left
            else:
                tmp_count += cur.count
                if cur.right is None:
                    cur.right = TreeNode(val)
                    break
                else:
                    cur = cur.right

        return tmp_count