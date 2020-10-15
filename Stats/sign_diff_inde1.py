import numpy as np
from scipy import stats
from scipy.stats import norm

# Check if there's any significant difference between 2 groups
# Specific samples are provided (not just mean and std)

X1= np.array([253, 224, 258, 186, 191])
X2= np.array([194, 154, 176, 176, 180, 160])

avg_1= X1.mean()
avg_2= X2.mean()
# avg_1= 
# avg_2=
std_1= 41
std_2= 24
N1= X1.size
N2= X2.size
# N1= 
# N2= 

stat_t= (avg_1 - avg_2) / np.sqrt(std_1 * std_1 / N1 + std_2 * std_2 / N2)
# print(stat_t)
p= norm.cdf(-np.abs(stat_t), 0, 1) * 2
print(p)
if p < 0.05:
    print("Reject H0")
else:
    print("Cannot reject H0")
