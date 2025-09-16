'''
s = house starting point 
t = house ending point
a = location point of apple tree
b = location point of orange tree
m = no of apples
n = no of orange
'''

s,t,a,b,m,n = map(int, input().split())

apples_distance_from_tree = list(map(int, input().split()))[:m]


orange_distance_from_tree = list(map(int, input().split()))[:n]

points_where_apples_fell = [] 
count_of_apples_and_oranges_on_houses = 0

for i in range(m):
    location = a - apples_distance_from_tree[i]
    if (location >= s and location <= t):
        count_of_apples_and_oranges_on_houses += 1
    points_where_apples_fell.append(location)

points_where_oranges_fell = []

for i in range(n):
    location = b + orange_distance_from_tree[i]
    if (location >= s and location <= t):
        count_of_apples_and_oranges_on_houses += 1
    points_where_oranges_fell.append(location)


print(points_where_apples_fell)
print(points_where_oranges_fell)
print(count_of_apples_and_oranges_on_houses)


    
