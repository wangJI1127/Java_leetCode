import sys

if __name__ == "__main__":
    # n, m = map(int, input().split())
    # li1 = list(map(int, input().split()))
    # li2 = list(map(int, input().split()))

    n, m = 5, 5
    li1 = [4,4,1,1,1]
    li2 = [4,3,1,2,0]
    res = []
    temp1 = []
    for i in li1:
        temp2 = [(j+i) % m for j in li2]
        for ii in temp1:
            temp2[ii] = -1
        index = temp2.index(max(temp2))
        temp1.append(index)
        res.append(max(temp2))
    res.sort(reverse=True)
    for i in res:
        print(i)