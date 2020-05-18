import numpy as np
x= np.array([60, 72, 91, 51, 45, 88, 67, 26])
y= np.array([84, 75, 52, 60, 33, 97, 69, 72])

print(np.corrcoef(x, y)[0, 1])
