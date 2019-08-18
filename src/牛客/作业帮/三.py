import sys

if __name__ == "__main__":
    str = sys.stdin.readline().strip()
    li_str = str[1:-1].split(',')
    li = list()
    for i in li_str:
        li.append(int(i.strip()))
    li.sort()
    r = 0
    m = 1
    for i in range(1, len(li)):
        if li[i] - li[i-1] == 1:
            m += 1
            r = max(r, m)
        else:
            m = 0
    print(r)