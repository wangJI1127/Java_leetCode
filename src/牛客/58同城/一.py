import sys
if __name__ == "__main__":
    line = sys.stdin.readline().strip()
    # 把每一行的数字分隔后转化成int列表
    values = list(map(int, line.split(',')))
    print(len(set(values)))