def ip_to_bin(ips):
    res= []
    for ip in ips:
        res.append(' ' .join(format(int(x), '08b') for x in ip.split('.')))
    return res

ips = ["192.168.7.115",
    "192.168.0.0",
    "192.168.4.0",
    "192.168.6.0",
    "192.168.12.0"]

for ip in ip_to_bin(ips):
    print(ip)
