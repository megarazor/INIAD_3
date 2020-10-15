import csv, time
import socket, struct # For converting IP address

def ip_str_to_int(addr):
    return struct.unpack("!I", socket.inet_aton(addr))[0]

def get_mask(subn_mask):
    mask= 0xFFFFFFFF
    for i in range(subn_mask):
        mask= mask & ~(1 << i)
    return mask

# INPUT:  
#   IP condition, (string, example: "192.168.45.24")
#   Subnet_mask, (int, example: 16)
#   Additional condition label in CSV file, (string, example: "Destination port")
#   Additional condition value, (string, example: "8080")
#   CSV filename (string, example: "captured.csv")
#   Hard timeout (int, example: 60)

def get_pkt_stat(ip_cond, subn_mask, addl_cond_label, addl_cond, csv_name, t_out):
    pkt_no= 0
    byte_no= 0
    start= time.time()

    with open(csv_name) as f:
        reader = csv.DictReader(f)
        # Convert IP address condition to integer
        ip_cond_int= ip_str_to_int(ip_cond) & get_mask(subn_mask)

        for row in reader:
            # Get IP address of this row
            row_ip_int= ip_str_to_int(row["Destination"])
            # Get additional field of this row
            row_addl_value= row[addl_cond_label]
            # Get subnet mask
            mask= get_mask(subn_mask)
            # Apply subnet mask to row's IP address and compare it with IP condition
            if ( (row_ip_int & mask) == ip_cond_int ):
                if ( addl_cond == row_addl_value ):
                    pkt_no+= 1
                    byte_no+= int(row["Length"])
    
    # Get waiting time
    wait_time= t_out - (time.time() - start)
    if wait_time > 0:
        time.sleep(wait_time)
    return pkt_no, byte_no        

print(get_pkt_stat("107.167.110.216", 16, "Destination port", "443", "captured.csv", 3))
print(get_pkt_stat("172.16.230.99", 16, "Protocol", "TCP", "captured.csv", 3))
