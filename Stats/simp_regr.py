import numpy as np
import pandas as pd
import statsmodels.api as sm

df= pd.read_csv('sample4.csv', sep=',')
df.head(20)

y= df[['Score']]
X= df[['Time']]

mod= sm.OLS(y, sm.add_constant(X))
res= mod.fit()
print(res.summary())
