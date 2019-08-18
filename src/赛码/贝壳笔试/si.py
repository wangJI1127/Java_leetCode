def isdizeng(arr):
    for i in range(1, len(arr)):
        if arr[i] <= arr[i-1]:
            return False
    return True

def isdijian(arr):
    for i in range(1, len(arr)):
        if arr[i] >= arr[i-1]:
            return False
    return True

def isdizengdijian(arr):
    max_index = arr.index(max(arr))
    return isdizeng(arr[0:max_index+1]) and isdijian(arr[max_index:])

def panduan(n, arr, res):
    if isdijian(arr) or isdizeng(arr) or isdizengdijian(arr):
        return res
    for i in range(1, n+1):
        if not isdizengdijian(arr[:i]) and not isdizeng(arr[:i]) and not isdizeng(arr[:i]):
            if isdizeng(arr[:i-1]):
                arr[i] += 1
                return panduan(n, arr, res+1)
            else:
                arr[i-1] += 1
                return panduan(n, arr, res+1)
while 1:
    a=[]
    n = int(input())
    arr = list(map(int, input().split()))
    if n == 1:
        print(0)
    elif n == 2:
        if arr[0] == arr[1]:
            print(1)
        else:
            print(0)
    else:
        print(panduan(n, arr))


