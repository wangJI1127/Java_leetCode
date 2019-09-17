
def josephus(n, k, m):
    people = list(range(1,n+1))
    i = k-1
    for num in range(n, 0, -1):
        i = (i+m-1)%num
        print(people.pop(i))
    return
josephus(10,2,7)