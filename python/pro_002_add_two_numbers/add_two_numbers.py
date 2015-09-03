__author__ = 'laiconglin'


class ListNode(object):
    # Definition for singly-linked list.
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l1_cur = l1
        l2_cur = l2
        carry = 0
        sum_head = None
        cur_sum = None
        while l1_cur is not None and l2_cur is not None:
            tmp_sum = l1_cur.val + l2_cur.val + carry
            carry = tmp_sum / 10
            remainder = tmp_sum % 10
            tmp_cur_sum_list_node = ListNode(remainder)
            if sum_head is None:
                sum_head = tmp_cur_sum_list_node
                cur_sum = tmp_cur_sum_list_node
            else:
                cur_sum.next = tmp_cur_sum_list_node
                cur_sum = cur_sum.next

            l1_cur = l1_cur.next
            l2_cur = l2_cur.next

        while l1_cur is not None:
            tmp_sum = l1_cur.val + carry
            carry = tmp_sum / 10
            remainder = tmp_sum % 10
            tmp_cur_sum_list_node = ListNode(remainder)
            if sum_head is None:
                sum_head = tmp_cur_sum_list_node
                cur_sum = tmp_cur_sum_list_node
            else:
                cur_sum.next = tmp_cur_sum_list_node
                cur_sum = cur_sum.next

            l1_cur = l1_cur.next

        while l2_cur is not None:
            tmp_sum = l2_cur.val + carry
            carry = tmp_sum / 10
            remainder = tmp_sum % 10
            tmp_cur_sum_list_node = ListNode(remainder)
            if sum_head is None:
                sum_head = tmp_cur_sum_list_node
                cur_sum = tmp_cur_sum_list_node
            else:
                cur_sum.next = tmp_cur_sum_list_node
                cur_sum = cur_sum.next

            l2_cur = l2_cur.next

        if carry != 0:
            tmp_cur_sum_list_node = ListNode(carry)
            cur_sum.next = tmp_cur_sum_list_node

        return sum_head


def get_list_node(list_numbers):
    """
    :type list_numbers: ListNode
    :rtype: ListNode
    """
    if len(list_numbers) == 0:
        return None
    list_head = ListNode(list_numbers[0])
    cur = list_head
    for i in range(1, len(list_numbers)):
        cur.next = ListNode(list_numbers[i])
        cur = cur.next

    return list_head


def get_list_node_length(list_node):
    """
    :type list_node: ListNode
    :rtype: list_node_len: int
    """
    list_node_len = 0
    cur = list_node
    while cur is not None:
        list_node_len += 1
        cur = cur.next

    return list_node_len


def get_test_list1():
    l1 = [2, 4, 3]
    return get_list_node(l1)


def get_test_list2():
    l2 = [5, 6, 4]
    return get_list_node(l2)


def print_list_node(list_node):
    cur = list_node
    while cur is not None:
        print cur.val,
        if cur.next is not None:
            print '->',
        else:
            print ''
        cur = cur.next

list1 = get_test_list1()
list2 = get_test_list2()
print_list_node(list1)
print_list_node(list2)
solution = Solution()

print_list_node(solution.addTwoNumbers(list1, list2))
