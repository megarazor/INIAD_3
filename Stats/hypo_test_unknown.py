import numpy as np
from scipy import stats
from scipy.stats import t

# Test if population mean is mu_0 or not under the significance level of 5%
# Std/Var is unknown

X= np.array([4.7, 4.8, 4.9, 5.3, 5.5, 5.9, 6.0])
X_mean= X.mean()
N= X.size

mu_0= 5

X_sd= np.std(X, ddof=1)

stat_t= (X_mean - mu_0) / (X_sd / np.sqrt(N))
p= t.cdf(-np.abs(stat_t), df=N-1) * 2 # x2 because of two-sided
print(p) # p-value < 5% in the rejection region?
# Yes -> reject mu_0
if p < 0.05:
    print("H0 is rejected")
else:
    print("H0 is NOT rejected")

# In a certain factory, they make a component of a compter, named A. After we measured the length of 10 samples of this A, the mean and unbiased variance were 7.2[cm] and 0.04, respectively.

# If the length of A follows the normal distribution, can we state that the length of A is 7.0cm on average? Conduct the hypothesis test with the significance level of 5%.
