import numpy as np

ppl_num= 23
trials_no= 1000 * 1000
same_count= 0

for _ in range(trials_no):
    birthdays= np.random.randint(low = 1, high = 366, size = ppl_num)
    if len(np.unique(birthdays)) != len(birthdays):
        same_count+= 1

print(same_count / trials_no)

