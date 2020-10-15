import numpy as np
x= np.array([56,67,78,89,95])
y= np.array([47,53,63,82,89])

print(np.corrcoef(x, y)[0, 1])
