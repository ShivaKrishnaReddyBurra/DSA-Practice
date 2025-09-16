a = list(map(int, input().split())) # [x,y]
b = list(map(int, input().split()))
c = list(map(int, input().split()))

'''
d = a+b-c
or
d = a+c-b
or 
d = b+c-a
'''

d = [[(a[0]+b[0]-c[0]),(a[1]+b[1]-c[1])],[(a[0]+c[0]-b[0]),(a[1]+c[1]-b[1])],[(b[0]+c[0]-a[0]),(b[1]+c[1]-a[1])]]

d.sort()

print(d[0])