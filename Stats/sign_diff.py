import numpy as np
from scipy import stats
from scipy.stats import norm

# Check if there's any significant difference between 2 groups
# Example: group1 with 20 samples, group2 with 10 samples
#          group1 is fed with food1, group2 with food2
#          any significant difference between 2 groups? 

X1= np.array([53.1, 50.3, 59.5, 62.0, 58.6, 56.5, 53.5])
X2= np.array([51.3, 48.8, 53.6, 56.2, 52.5, 53.0, 53.4])

stat_t, p= stats.ttest_ind(X1, X2, equal_var=False)
print(p)
if p < 0.05:
    print("Reject H0, there's a significant difference")
else:
    print("Cannot reject H0, there's no significant difference")
