import sys
if __name__ == "__main__":
    # 读取第一行的n
    n = int(sys.stdin.readline().strip())
    m = int(sys.stdin.readline().strip())
    l = list(list(0 for i in range(m)) for j in range(n))
    for i in range(n):
        for j in range(m):
            l[i][j] = int(sys.stdin.readline().strip())
    dp = list(list(0 for i in range(m)) for j in range(n))
    dp[0][0] = l[0][0]
    for i in range(1, n):
        dp[i][0] = l[i][0] + dp[i-1][0]
    for i in range(1, m):
        dp[0][i] = l[0][i] + dp[0][i-1]
    for i in range(1, n):
        for j in range(1, m):
            dp[i][j] = min(l[i][j] + dp[i-1][j], l[i][j] + dp[i][j-1])
    print(dp[n-1][m-1])
