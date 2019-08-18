def isbisai(mi, ma):
    if mi >= (ma * 0.9):
        return True
    else:
        return False

def jiecheng(n):
    res = 0
    for i in range(1, n):
        res += i
    return res

def m(n, arr):
    if isbisai(arr[0], arr[-1]):
        return jiecheng(n)
    res = 0
    r = n-1
    while(not isbisai(arr[0], arr[r])):
        r -= 1
    res += jiecheng(r)
    l = 0
    while(not isbisai(arr[l], arr[-1])):
        l += 1
    res += jiecheng(n-l)
    return res

while 1:
    a=[]
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    res = 0
    for i in range(n-1):
        for j in range(i+1, n):
            if arr[i] >= (arr[j] * 0.9):
                res += 1
    print(res)
