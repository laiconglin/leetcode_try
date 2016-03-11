class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        nums_size = len(nums)
        if nums_size < 2:
            return
        for i in xrange(1, nums_size):
            if i % 2 is 1:
                if nums[i] < nums[i - 1]:
                    tmp = nums[i]
                    nums[i] = nums[i - 1]
                    nums[i - 1] = tmp
                elif nums[i] == nums[i - 1]:
                    next_bigger_index = self.find_next_bigger_number_index(nums, nums_size, i + 1, nums[i])
                    if next_bigger_index is not -1:
                        tmp = nums[next_bigger_index]
                        nums[next_bigger_index] = nums[i]
                        nums[i] = tmp
            else:
                if nums[i] > nums[i - 1]:
                    tmp = nums[i]
                    nums[i] = nums[i - 1]
                    nums[i - 1] = tmp
                elif nums[i] == nums[i - 1]:
                    next_smaller_index = self.find_next_smaller_number_index(nums, nums_size, i + 1, nums[i])
                    if next_smaller_index is not -1:
                        tmp = nums[next_smaller_index]
                        nums[next_smaller_index] = nums[i]
                        nums[i] = tmp


    def find_next_bigger_number_index(self, nums, nums_size, start_index, target_number):
        if start_index >= nums_size:
            return -1
        bigger_number_index = -1
        for i in xrange(start_index, nums_size):
            if nums[i] > target_number:
                bigger_number_index = i

        return bigger_number_index

    def find_next_smaller_number_index(self, nums, nums_size, start_index, target_number):
        if start_index >= nums_size:
            return -1
        smaller_number_index = -1
        for i in xrange(start_index, nums_size):
            if nums[i] < target_number:
                smaller_number_index = i

        return smaller_number_index


solution = Solution()
nums = [1,2,2,1,2,1,1,1,1,2,2,2]
print len(nums)
solution.wiggleSort(nums)
