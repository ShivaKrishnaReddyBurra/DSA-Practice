n = int(input())

matrix = []
for i in range(n):
    row = list(map(int, input().split()))[:n]
    matrix.append(row)

left_diagonal_sum = 0
right_diagonal_sum = 0

for i in range(n):
    left_diagonal_sum += matrix[i][i]
    right_diagonal_sum += matrix[i][n-i-1]

absolute_val = abs(left_diagonal_sum - right_diagonal_sum)

print(absolute_val)
        

