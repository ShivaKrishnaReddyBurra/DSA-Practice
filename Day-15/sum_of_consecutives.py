def sum_of_numbers(start, target):
    sum = start
    while sum < target:
        start +=1
        sum += start
        if(target == sum):
            return 1
    return 0

target = int(input())
count = 0
for i in range(1,target):
    val = sum_of_numbers(i,target)
    count += val

print(count) 

    