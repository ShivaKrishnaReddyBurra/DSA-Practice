string = input()
count = 0
for i in range(len(string)):
    if(string.count(str(i)) != int(string[i])):
        count = 0
        break
    else:
        if(int(string[i]) != 0):
            count += 1

print(count)
    