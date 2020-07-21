from scipy.stats import binom

# Even E has prob. of "p".
# Find prob. it happens EXACTLY "t" times out of "n" tries.

p= 0.15
N= 10
t= 2
print(binom.pmf(t, N, p))
