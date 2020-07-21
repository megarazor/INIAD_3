import numpy as np
from scipy import stats
from scipy.stats import norm

# Check if group2 is significantly better than group1
# When specific group samples are provided
# Example: group1 with 20 samples, group2 with 10 samples
#          group1 is fed with food1, group2 with food2
#          group2 > group1 ??

X1= np.array([6, 5, 10])
X2= np.array([12, 16, 22, 8, 17])

stat_t, p= stats.ttest_ind(X1, X2, equal_var=False)
p= p/2
print(p)
if p < 0.05:
    print("Reject H0, there's a significant difference")
else:
    print("Cannot reject H0, there's no significant difference")
