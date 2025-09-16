string = input()
n = int(input())
output = ""

while len(output) < n:
    output += string

print(output[:n])
print(output[:n].count('a'))