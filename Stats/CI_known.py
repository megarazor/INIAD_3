import numpy as np
import scipy.stats as st

x= np.array([16, 23, 24, 26, 27, 29])

#Sample size
n= x.size
# n= 16

#Sample mean
x_mean= x.mean()
# x_mean= 12

#Known SD
x_sd= 7

#Find 95-CI
print(st.norm.interval(alpha=0.95, loc=x_mean, scale=x_sd/np.sqrt(n)))
