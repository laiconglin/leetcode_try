class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index1 = -1
        index2 = -1
        index_dict = dict()
        for i in range(0, len(nums)):
            expected_num = target - nums[i]
            if expected_num not in index_dict.keys():
                index_dict[nums[i]] = i + 1
            else:
                index1 = index_dict[expected_num]
                index2 = i + 1

            if index1 != -1 and index2 != -1:
                break
        index_list = [index1, index2]
        return index_list

a = Solution()
nums = [3, 3, 5]
target = 6
two_sum = a.twoSum(nums, target)
print two_sum
