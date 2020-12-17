# Results:
# Case 1: 34.9782 %
# Case 2: 10.004399999999999 %

import random

# Same popularity case
contents= []
for i in range(1, 101): # Contents are numbers from 1 to 100
    contents.append(i)

cache= [-1] * 10 # Initial cache stores nothing
LRU= [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] # Last used information of values in cache. 0 is most recent, 9 is last recent

trial_count= 1000000
hit_count= 0

for _ in range(trial_count):
    n= random.randint(1, 100)
    if n in cache:
        hit_count+= 1
    else:
        LRU_i= LRU.index(9)
        cache[LRU_i]= n
        for i in range(10):
            LRU[i]+= 1
        LRU[LRU_i]= 0

print("Cache hit rate when popularty of all contents is the same: ", hit_count / trial_count * 100, "%")

# Zipf's law case
trial_count= 1000000
hit_count= 0
alpha= 1
frequencies= []
contents= []

# Get frequencies
for k in range(1, 101):
    E= 0
    for n in range(1, 101):
        E+= 1 / (n ** alpha)
    frequencies.append( int((1 / k * alpha) / E  * trial_count))

for i in range(100):
    for _ in range(frequencies[i]):
        contents.append(i + 1)
    
cache= [-1] * 10 # Initial cache stores nothing
LRU= [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] # Last used information of values in cache. 0 is most recent, 9 is last recent

for _ in range(trial_count):
    n= random.sample(contents, 1)[0]
    if n in cache:
        hit_count+= 1
    else:
        LRU_i= LRU.index(9)
        cache[LRU_i]= n
        for i in range(10):
            LRU[i]+= 1
        LRU[LRU_i]= 0

print("Cache hit rate, Zipf's law with alpha=1: ", hit_count / trial_count * 100, "%")
