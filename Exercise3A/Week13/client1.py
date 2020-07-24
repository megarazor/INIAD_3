from coapthon.client.helperclient import HelperClient

host = "127.0.0.1"
port = 5683
path ="controls"

def controlTCar(command):
    print("~"*15, command, "~"*15)
    if command == "start-running":
        print("*"*15, "Running", "*"*15)
    elif command == "stop-running":
        print("*"*15, "Stopping", "*"*15)
    elif command == "turn-red":
        print("*"*15, "Headlights turned red", "*"*15)
    elif command == "turn-green":
        print("*"*15, "Headlights turned green", "*"*15)
    elif command == "turn-blue":
        print("*"*15, "Headlights turned blue", "*"*15)
    elif command == "turn-white":
        print("*"*15, "Headlights turned white", "*"*15)
    elif command == "turn-off":
        print("*"*15, "Headlights turned off", "*"*15)
    else:
        print("*"*15, "Unknown status", "*"*15)

client = HelperClient(server=(host, port))

while True:
    try:
        response = client.get(path)
        controlTCar(response.payload)
    except KeyboardInterrupt:
        client.stop()
        print("Exiting...")
        break
