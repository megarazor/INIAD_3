def meandelayMM1(pkt_per_sec, avg_pkt_len, lnk_cap):
    # pkt_per_sec: average number of arrival packets per unit time [pps]
    # avg_pkt_len: average packet length [bytes]
    # lnk_cap: link capacity [Mbps]
    # return: mean delay time [ms]
    one_on_u= avg_pkt_len * 8 / (lnk_cap * (10 ** 6))
    p= pkt_per_sec * one_on_u
    T= one_on_u / (1 - p)
    return T * 1000

# Find mean delay time:
pkt_per_sec= 800
avg_pkt_len= 500
lnk_cap= 6
T= meandelayMM1(pkt_per_sec, avg_pkt_len, lnk_cap)
print("T in [ms]:", T)

# Find the right link capacity for a desired mean delay time
pkt_per_sec= 800
avg_pkt_len= 500
lnk_cap_lst= [1, 2, 3, 4, 5]
for n in lnk_cap_lst:
    print("With C =", n, "[Mbps], T =", meandelayMM1(pkt_per_sec, avg_pkt_len, n), "[ms]")

