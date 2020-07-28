def ip_to_bin(ips):
    res= []
    for ip in ips:
        res.append(' ' .join(format(int(x), '08b') for x in ip.split('.')))
    return res

ips = ["192.168.2.0",
    "192.168.2.1",
    "192.168.2.15",
    "192.168.2.25"]

ips2 = ["192.168.3.155",
    "192.168.0.0",
    "192.168.2.0",
    "192.168.4.0",
    "192.168.8.0"
]

for ip in ip_to_bin(ips):
    print(ip)
