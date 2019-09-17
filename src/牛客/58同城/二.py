import sys
if __name__ == "__main__":
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())
    values = list()
    while(n > 0):
        m = int(sys.stdin.readline().strip())
        values.append(m)
        n = n - 1
    l = list(1 for i in range(3))
    for i in range(1,n):
        if values[i] < values[i-1]:
            l[i] = l[i-1]
            l[i-1] = l[i-1] + 1
        else:
            l[i] = l[i-1] + 1
    print(sum(l))