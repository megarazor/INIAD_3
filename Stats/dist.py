from scipy.stats import norm

l= 0
s= 1

# Percentile calc
print(norm.ppf(0.85, loc=l, scale=s))

# ... < ... < ... dist calc
print(norm.cdf(2.5 , loc=l, scale=s) - norm.cdf(-0.3 , loc=l, scale=s))