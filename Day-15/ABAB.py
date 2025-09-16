s = input("Enter a string: ")

result = s[0]           # keep the first character
for ch in s[1:]:
    if ch != result[-1]:   # append only if different from last kept char
        result += ch

print(result)
