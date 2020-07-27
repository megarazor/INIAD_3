# In a certain store, 4 customers arrive every one hour in
# average. Under the assumption that the arrival of customers is
# subject to the Poisson distribution, find the probability that 3
# customers will arrive in one hour

# λ = 4[customers/hour] is known.
# Thereby, ｆ（3）＝ｅ -4・ 43／3！ = 0.195

from scipy.stats import poisson
lamb= 4
x= 3
p = poisson.pmf(x, lamb)

pc = 0
# for i in range(x, 10000):
#     # print(i)
#     pc+= poisson.pmf(i, lamb)


print(p)
print(pc)
