import numpy as np
from scipy import stats
from scipy.stats import norm

# Check if there's any significant difference between 2 groups
# Specific samples are provided (not just mean and std)

X1= np.array([253, 224, 258, 246, 294, 265, 242, 300, 276, 262, 233, 212, 273, 228, 308])
X2= np.array([194, 154, 176, 176, 180, 160, 174, 193, 207, 170, 158, 206, 184, 182, 165, 172, 184, 205, 176, 180])

avg_1= X1.mean()
avg_2= X2.mean()
# avg_1= 
# avg_2=
std_1= 30.3
std_2= 25.8
N1= X1.size
N2= X2.size
# N1= 
# N2= 

stat_t= (avg_1 - avg_2) / np.sqrt(std_1 * std_1 / N1 + std_2 * std_2 / N2)
print(stat_t)
p= norm.cdf(-np.abs(stat_t), 0, 1) * 2
print(p)
if p < 0.05:
    print("Reject H0")
else:
    print("Cannot reject H0")
