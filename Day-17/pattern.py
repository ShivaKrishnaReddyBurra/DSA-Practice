'''
    pattern : 
        1
        12
        123
        12
        1
            
'''

def patttern(n):
    # increasing part
    for i in range(n):
        for j in range(i+1):
            print(j+1, end = "")
        print()
    # decreasing part
    for i in range(n-1, 0, -1):
        for j in range(i):
            print(j+1, end = "")
        print()
patttern(3)
