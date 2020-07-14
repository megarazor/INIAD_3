import numpy as np
from scipy import stats
from scipy.stats import norm

X= np.array([1.53, 1.57, 1.54, 1.57, 1.53, 1.55, 1.56, 1.53])
mu_0= 1.54
avg= X.mean()
std= 0.01 # Varinace = 0.0001
N= X.size

print(avg)
z= (avg - mu_0) / (std / np.sqrt(N))

print(z)
p= norm.cdf(- np.abs(z), 0, 1) * 2 # x2 because of two-sided test
print(p) # p-value < 5% in the rejection region?
# Yes -> reject mu_0

# In a certain maker of a part (named as “M”) of computer,
# its diameter is described as 1.54[cm] in its product specification. In a
# certain sample survey, they extracted 8 samples randomly, and observed
# the following data of measured diameter [cm]:
# 1.53 1.57 1.54 1.57 1.53 1.55 1.56 1.53

# It’s known that the population variance is σ2=0.0001.
# Then, can you say that this part follow its product specification? Test with
# the significance level of 5%.
