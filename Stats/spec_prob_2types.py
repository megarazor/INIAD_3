from scipy.stats import hypergeom

m= 5
N= 11
k= 4
print(hypergeom.pmf(2, N, m, k))
