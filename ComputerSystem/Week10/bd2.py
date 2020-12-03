import numpy as np

ppl_num= 22
trials_no= 100 * 1000
same_count= 0

for _ in range(trials_no):
    birthdays= np.random.randint(low=1, high=366, size = ppl_num)
    my_birthday= np.random.randint(low=1, high=366)
    if my_birthday in birthdays:
        same_count+= 1

print(same_count / trials_no)

