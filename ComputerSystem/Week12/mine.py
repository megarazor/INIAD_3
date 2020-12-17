import time
from hashlib import sha256

target= 0x0000001000000000000000000000000000000000000000000000000000000000

start_time= time.time()

prefix= "I am Satoshi Nakamoto"
nonce_int= 0

while True:
    nonce= str(nonce_int)
    string= prefix + nonce
    h= int( sha256(string.encode('utf-8')).hexdigest(), 16 )
    if h < target:
        print("Nonce satisfying the condition:", nonce)
        break
    nonce_int+= 1

end_time= time.time()
print("Execution time:", end_time - start_time)
