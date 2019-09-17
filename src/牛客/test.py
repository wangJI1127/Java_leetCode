

str = "asdf:20ms,asfas:30ms,"
s = str.split('ms')
sum = 0
for i in range(len(s) - 1):
    num = int(s[i][-2:])
    sum += num
print(sum/(len(s)-1))
