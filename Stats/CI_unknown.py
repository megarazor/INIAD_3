import numpy as np
import scipy.stats as st

x= np.array([5,6,7,8,9])

#Sample size
n= x.size

#Sample mean
x_mean= x.mean()

#Unknown SD
x_sd= np.std(x, ddof=1)

#Find 95-CI
print(st.t.interval(alpha=0.95, df=n-1, loc=x_mean, scale=x_sd/np.sqrt(n)))