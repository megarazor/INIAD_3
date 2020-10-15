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
		t1= threading.Thread(target=f, args=(a1, i * m))
		t2= threading.Thread(target=f, args=(a2, i * m))

		start_time = time.time()

		t1.start()
		t2.start()
		t1.join()
		t2.join()

		end_time = time.time()
		print(2 * i * m, end_time - start_time)

main()
# dis.dis(main)
