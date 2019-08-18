import sys

def find(li, n):
    l = 0
    r = len(li)-1
    while l < r:
        if li[l] + li[r] == n:
            print((li[l]+','+li[r]))
            l += 1
            r -= 1
        elif li[l] + li[r] > n:
            r -= 1
        else:
            l += 1


if __name__ == "__main__":
    """
    设置两个指针，分别从数组的左右两边分别向中间移动，没移动一步都进行对比，当指针指向的两个数的和为目标值，则输出
    所以时间复杂度为O(n), n为数组的长度
    """
    str = sys.stdin.readline().strip()
    li_str = str[1:-1].split(',')
    li = list()
    for i in li_str:
        li.append(int(i.strip()))
    n = int(sys.stdin.readline().strip())
    if n >= 2:
        find(li, n)



