__author__ = 'laiconglin'
"""
最好不要陷入抖机灵仅仅只为了实现获取median的函数，
比如这道题还可以扩展为获取两个排序数组的第K个数的问题，
所以为了得到更加通用的程序，需要好好思考一下之间的关系
"""

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l = len(nums1) + len(nums2)
        if l % 2 == 1:
            return self.findKth(nums1, nums2, l / 2)
        else:
            return (self.findKth(nums1, nums2, l / 2 - 1) + self.findKth(nums1, nums2, l / 2)) / 2.0

    def findKth(self, nums1, nums2, k):
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        if not nums1:
            return nums2[k]
        if k == len(nums1) + len(nums2) - 1:
            return max(nums1[-1], nums2[-1])
        i = len(nums1) / 2
        j = k - i
        #print "nums1:", nums1
        #print "nums2:", nums2
        if nums1[i] > nums2[j]:
            # Here I assume it is O(1) to get A[:i] and B[j:]. In python, it's not but in cpp it is.
            return self.findKth(nums1[:i], nums2[j:], i)
        else:
            return self.findKth(nums1[i:], nums2[:j], j)


a = Solution()
test_nums1 = [2, 4, 6, 8]
test_nums2 = [1, 3, 5, 7, 9]
print a.findMedianSortedArrays(test_nums1, test_nums2)


