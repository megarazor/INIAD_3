def exp_var(xs, pos):
    exp= 0
    var= 0
    for i in range(len(xs)):
        exp+= xs[i] * pos[i]
    for i in range(len(xs)):
        var+= (xs[i] - exp) ** 2 * pos[i]
    return exp, var

xs= [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
pos= [1/10] * 10
exp, var= exp_var(xs, pos)
print("Expected value:", exp, "\nVariance:", var)
