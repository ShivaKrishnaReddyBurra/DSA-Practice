'''
n = 3 
    ** **
    *   *

    *   *
    ** **

n = 4 
    *** ***
    **   **
    *     *

    *     *
    **   **
    *** ***
'''

n = int(input())

for i in range(n-1):
    for j in range(n-1-i):
        print('*',end = "")
    for s in range(2*i+1):
        print(' ',end = "")
    for j in range(n-1-i):
        print('*',end = "")
    print()

print()
for i in range(n-1,0,-1):
    for j in range(n-i):
        print('*',end = "")
    for s in range(2*i-1):
        print(' ',end = "")
    for j in range(n-i):
        print('*',end = "")
    print()