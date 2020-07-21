import numpy as np
from scipy import stats
from scipy.stats import norm

X= np.array([10.8, 11.2, 9.7, 9.9, 12.0, 9.6, 10.5, 10.7, 10.1])
mu_0= 10
avg= X.mean()
std= 0.7 # sqrt of varinace 
N= X.size

z= (avg - mu_0) / (std / np.sqrt(N))
p= norm.cdf(- np.abs(z), 0, 1) * 2 # x2 because of two-sided test
print(p) # p-value < 5% in the rejection region?
# Yes -> reject mu_0
if p < 0.05:
    print("H0 is rejected")
else:
    print("H0 is NOT rejected")

# In a certain maker of a part (named as “M”) of computer,
# its diameter is described as 1.54[cm] in its product specification. In a
# certain sample survey, they extracted 8 samples randomly, and observed
# the following data of measured diameter [cm]:
# 1.53 1.57 1.54 1.57 1.53 1.55 1.56 1.53

# It’s known that the population variance is σ2=0.0001.
# Then, can you say that this part follow its product specification? Test with
# the significance level of 5%.
