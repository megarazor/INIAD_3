import numpy as np
from scipy import stats
from scipy.stats import t

# ONE SIDED
# Differences between after/before taking meds
X = np.array([96, 94,96,97,98,99,100,95,95,94]) # Example: blood pressure after taking meds

# H0: meds are un-affective
mu_0= 95 # Example: blood pressure before taking meds. Effective or not?

avg= X.mean()
# avg= 98.6

# If std is unknown: std= np.std(X, ddof=1)
std= np.std(X, ddof=1)
# std= np.sqrt(144)

N= X.size
# N= 70

stats_t= (avg - mu_0) / (std / np.sqrt(N))

# If this < 5% -> reject H0 (meds are actually affective)
# If this > 5% -> not reject H0 (meds are un-affective)
p= t.cdf(-np.abs(stats_t), df=N-1)
print(p)
if p < 0.05:
    print("Reject H0")
else:
    print("Cannot reject H0")

# A certain drink is said to be effective for reducing the blood pressure. Mr.A likes to try that. After drinking it one month, he measure his blood pressure 5 times, to observe the result: 

# {127,128, 130,131, 129}.

# The original average value of Mr.A's  blood pressure was 130. Then, we like to test whether 

# his blood pressure has certainly reduced or not. The significance level is 5%.
