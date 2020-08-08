import time
import threading
import dis

def f(a, N):
	for i in range(N):
		a[i%3]+= i

def main():
	a1= [1, 2, 3]
	a2= [4, 5, 6]
	m= 1000*1000
	N= 50

	for i in range(5, N + 1, 5):
		start_time = time.time()
		
		f(a1, i * m)
		f(a2, i * m)
		
		end_time = time.time()
		print(2 * i * m, end_time - start_time)
main()
# dis.dis(main)
