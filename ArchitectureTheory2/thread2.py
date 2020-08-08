import threading

def f(a, N):
	for i in range(N):
		a[i%3] += i

a1= [1, 2, 3]
a2= [4, 5, 6]
N= 20*1000*1000

t1= threading.Thread(target=f, args=(a1, N))
t2= threading.Thread(target=f, args=(a2, N))

t1.start()
t1.join()

t2.start()
t2.join()
print(sum(a1) + sum(a2))