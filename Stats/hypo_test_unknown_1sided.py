import numpy as np
from scipy import stats
from scipy.stats import t

mu_0= 2000
avg= 1900
std= 150 # Variance = 0.04
N= 15

stat_t= (avg - mu_0) / (std / np.sqrt(N))

print(stat_t)
p= t.cdf(-np.abs(stat_t), df=N-1) * 1 # x1 because of 1-sided
print(p) # p-value < 5% in the rejection region?
# Yes -> reject mu_0

# A certain maker states that the lifetime of their light bulb is 2000 hours. To validate this statement, we bought 15 samples and tested their lifetime.

# Then, the mean and unbiased S.D. were 1900 and 150 hours, respectively.

# If the lifetime follows the normal distribution, can we say that the statement of this maker is correct?

# Conduct the hypothesis test with the significance level of 5%.
