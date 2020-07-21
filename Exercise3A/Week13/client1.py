from coapthon.client.helperclient import HelperClient

host = "127.0.0.1"
port = 5683
path ="controls"

def controlTCar(command):
    print("~"*15, command, "~"*15)
    if command == "start-running":
        print("*"*15, "running", "*"*15)


client = HelperClient(server=(host, port))

while True:
    try:
        response = client.get(path)
        controlTCar(response.payload)
    except KeyboardInterrupt:
        client.stop()
        print("Exiting...")
        break
