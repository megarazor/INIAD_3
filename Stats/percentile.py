from scipy.stats import t
from scipy.stats import norm

# Find the upper ...-percentile of z-dist.
print("Simple pecentile: ", end="")
print(norm.ppf(0.90))

# Expected value = "loc", STD = "scale"
# Find upper ...-pecentile of the pdf of this dist?
print("N(..., ...^2) pecentile: ", end="")
print(norm.ppf(0.90, loc=5, scale=2))

