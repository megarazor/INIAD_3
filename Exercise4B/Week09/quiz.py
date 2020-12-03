import random
import math


def create_prime( n ):
    """
        Create a list of prime numbers.
        (Don't change)
    """
    prime = list(range(2, 4))
    for i in range(4, n+1):
        flag = True
        for j in range(2,i):
            if i%j == 0:
                flag = False
                break
        if flag:
            prime.append(i)
    return prime    

        

def create_pq( prime ):
    """
    Create integers p and q
    p and q are random prime in prime list.
    Note that p is not equal q.
    """
    my_primes = []
    for pr in range(2, number):
        isPrime = True
    for i in range(2, pr):
        if pr % i == 0:
            isPrime = False
        if isPrime:
            my_primes.append(pr)

    p = random.choice(primes)
    q = p
    while(q == p):
        q = random.choice(primes)
    # Hint: random.choice

    return (p, q)


def calc_nz(p, q):
    """
        Create integers n and z
    """
    n = q * p
    z = (p - 1) * (q - 1)

    return (n, z)



def find_e(z):
    """
        Find integer e relatively prime to z
    """
    # Hint: math.gcd
    e= z + 1
    while(math.gcd(e, z) != 1):
            e+= 1

    return e

def find_d( z, e):
    """
        Find integer d such that e*d≡1(mod z)
    """
    d= 2
    while ((e * d) % z != 1 % z):
        d+= 1

    return d

def encrypt( P, public_key ):
    """
        P: Plane text (positive integer)
        public_key: Tuple(e, n)
    """
    e, n= public_key
    C= P ** e % n

    return C

def decrypt( C, secret_key ):
    """
        C: Crypt text (positive integer)
        secret_key: Tuple(d, n)
    """
    d, n= secret_key
    P= C ** d % n
    return DecP


# main problem (Don't change)
if __name__ == '__main__':
    prime = create_prime( 100 )
    p, q = create_pq( prime )
    n, z = calc_nz( p, q )
    e = find_e( z )
    d = find_d( z, e )
    del p, q

    public_key = (e, n)
    secret_key = (d, n)
    del n, z, e, d

    P = 5
    print("Plane text: ", P)
    C = encrypt( P, public_key )
    print("Encryption text: ", C)
    DecP = decrypt( C, secret_key )
    print("Decryption text: ", DecP)
 