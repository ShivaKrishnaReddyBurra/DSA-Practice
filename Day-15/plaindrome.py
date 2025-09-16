string = input()
dist = {}
for i in string:
    if i in dist :
        dist[i] +=1
    else:
        dist[i] = 1
arr = []
count = 0
for i in dist:
    if(dist[i]%2 != 0):
        count += 1

if(count > 1):
    print('No')
else :   
    print('Yes')
