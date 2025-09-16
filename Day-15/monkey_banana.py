'''
n = total monkeys 
k = no of bananas each monkey can eat
j = no of peanuts each monkey can eat 
m = total no of bananas
p = total no of peanuts
'''
n,k,j,m,p = map(int, input().split())
monkeys_that_ate_banana = m//k
monkeys_that_ate_peanuts = p//j
leftover_of_bananas = m % k
leftover_of_peanuts = p % j
total_monkeys_ate= monkeys_that_ate_banana + monkeys_that_ate_peanuts
if(leftover_of_bananas > 0  or leftover_of_peanuts > 0):
    total_monkeys_ate += 1
remaining_monkeys_on_tree = n - total_monkeys_ate  
print(remaining_monkeys_on_tree)  