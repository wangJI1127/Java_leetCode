import sys

if __name__ == "__main__":
    n, m = map(int, input().split())
    arrs = []
    for i in range(n):
        arrs.append(list(map(int, input().split())))

    mianji = n * m * 2
    qian = 0
    for arr in arrs:
        qian += max(arr)
    mianji += qian * 2
    zuo = 0
    for j in range(m):
        ma = 0
        for i in range(n):
            ma = max(ma, arrs[i][j])
        zuo += ma
    mianji += zuo * 2
    print(mianji)