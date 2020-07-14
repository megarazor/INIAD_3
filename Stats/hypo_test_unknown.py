import numpy as np
from scipy import stats
from scipy.stats import t

mu_0= 7.0
avg= 7.2
std= 0.2 # Variance = 0.04
N= 10

stat_t= (avg - mu_0) / (std / np.sqrt(N))

print(stat_t)
p= t.cdf(-np.abs(stat_t), df=N-1) * 2 # x2 because of two-sided
print(p) # p-value < 5% in the rejection region?
# Yes -> reject mu_0

# In a certain factory, they make a component of a compter, named A. After we measured the length of 10 samples of this A, the mean and unbiased variance were 7.2[cm] and 0.04, respectively.

# If the length of A follows the normal distribution, can we state that the length of A is 7.0cm on average? Conduct the hypothesis test with the significance level of 5%.
