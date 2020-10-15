from scipy.stats import binom

# Even E has prob. of "p".
# Find prob. it happens EXACTLY "t" times out of "n" tries.

p= 1/500
N= 20
t= 1
print(binom.pmf(t, N, p))
