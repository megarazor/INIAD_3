def sum_between(x, y):
    if x > y:
        tmp= x
        x= y
        y= tmp
    sum= 0
    for i in range(x, (y + 1)):
        sum+= i
    return sum

print(sum_between(10, 12))
