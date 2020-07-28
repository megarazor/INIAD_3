import numpy as np
from scipy import stats
from scipy.stats import norm

# Check if group2 is significantly better than group1
# When specific group samples are NOT provided (only means and stds)
# Example: group1 with 20 samples, group2 with 10 samples
#          group1 is fed with food1, group2 with food2
#          group2 > group1 ??

avg_1= 222.4
avg_2= 173.3
std_1= 41.0
std_2= 24.0
N1= 5
N2= 6

stat_t= (avg_1 - avg_2) / np.sqrt(std_1 * std_1 / N1 + std_2 * std_2 / N2)
m11= pow(std_1, 2) / N1 + pow(std_2, 2) / N2
m1= pow(m11, 2)
m2= pow(std_1, 4) / (pow(N1, 2) * (N1 - 1)) + pow(std_2, 4) / (pow(N2, 2) * (N2 - 1))
df_val= m1 / m2

p= stats.t.cdf(-np.abs(stat_t), df=df_val) 
print(p)
if p < 0.05:
    print("Reject H0")
else:
    print("Cannot reject H0")

