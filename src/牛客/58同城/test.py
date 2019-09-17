import sys
if __name__ == "__main__":
    # 读取第一行的n
    values = [2,4,2,6,1,7,8,9,2,1]
    n = 10
    l = list(1 for i in range(n))
    for i in range(1,n):
        if values[i] < values[i-1]:
            if l[i-1] == 1:
                l[i] = l[i-1]
                l[i-1] = l[i-1] + 1
            else:
                l[i] = 1
        else:
            l[i] = l[i-1] + 1
    print(sum(l))