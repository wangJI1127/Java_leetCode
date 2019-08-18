while 1:
    a=[]
    n = int(input())
    arr = list(map(int, input().split()))
    mi = abs(arr[0] - arr[1])
    l = arr[0]
    r = arr[1]
    for i in range(1, n):
        if mi > abs(arr[i] - arr[i-1]):
            mi = abs(arr[i] - arr[i-1])
            l = arr[i-1]
            r = arr[i]
    print(l, end=' ')
    print(r)

