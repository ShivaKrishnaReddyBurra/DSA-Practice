n = int(input())
arr = []
for i in range(n):
    val = int(input())
    arr.append(val)

def product_of_elements(arr, index):
    val = 1
    for i in range(len(arr)):
        if(i == index):
            continue
        else:
            val *= arr[i]
        
    return val
new_arr = []
for i in range(n):
    val = product_of_elements(arr,i)
    new_arr.append(val)

print(new_arr)