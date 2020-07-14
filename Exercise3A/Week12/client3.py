from coapthon.client.helperclient import HelperClient
from coapthon import defines
import time

host = "127.0.0.1"
port = 5683

# Speed GET test

path ="speed_get"

client = HelperClient(server=(host, port))
response = client.get(path)
print(response.pretty_print())
client.stop()
time.sleep(2)

# Speed PUT test

path ="speed_put"

is_success = True

for speed in ["20.2", "50.1", "60", "-14.6", "errorcase"]:
    client = HelperClient(server=(host, port))
    response = client.put(path, speed)
    print(response.pretty_print())
    if (speed != "errorcase" and speed != "-14.6" and response.code != defines.Codes.CHANGED.number):
        is_success = False
    elif ((speed == "errorcase" or speed == "-14.6") and response.code != defines.Codes.BAD_REQUEST.number):
        is_success = False

    client.stop()
    time.sleep(1)

if(is_success):
    print("It passed all the test cases.")
else:
    print("There seems to be a failed test case.")
time.sleep(2)

# Speed GET test again

path ="speed_get"

client = HelperClient(server=(host, port))
response = client.get(path)
print(response.pretty_print())
client.stop()