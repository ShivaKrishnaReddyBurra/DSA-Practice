import time
start = time.time()
input_time = '12:45:30am'
arr = input_time.split(':')
am_or_pm = arr[-1]
if('pm' in am_or_pm.lower()):
    arr[0] = int(arr[0])+12
elif('12' and 'am' in am_or_pm.lower()):
    arr[0] = '00'
arr[0] = str(arr[0])
arr = ":".join(arr)
print(arr)
end = time.time()
print(end-start)