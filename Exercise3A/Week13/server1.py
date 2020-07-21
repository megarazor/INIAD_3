from coapthon.server.coap import CoAP
from coapthon.resources.resource import Resource
from coapthon import defines
import urllib.request
import urllib.error
SERVER_HOST_NAME = 'exercise-iiia-tcar.herokuapp.com'
NUM = 1
TIMEOUT = 10

class ControlResource(Resource):
    url = "https://{HOST}/api/v1/tcar/{NUM}/controls".format(HOST=SERVER_HOST_NAME, NUM=NUM)
    def __init__(self, name="control", coap_server=None):
        super().__init__(name, coap_server, visible=True,
                                            observable=True, allow_children=True)

    def render_GET(self, request):
        req = urllib.request.Request(self.url)
        try:
            with urllib.request.urlopen(req) as res:
                body = res.read().decode()
                self.payload = body
        except urllib.error.URLError as e:
            print(e.reason)
            self.payload = ""
        return self

class CoAPServer(CoAP):
    def __init__(self, host, port):
        CoAP.__init__(self, (host, port))
        self.add_resource('controls', ControlResource())

def main():
    print("Listenning on 0.0.0.0:5683")
    server = CoAPServer("0.0.0.0", 5683)
    try:
        server.listen(timeout=TIMEOUT)
    except KeyboardInterrupt:
        print("Server Shutdown")
        server.close()
        print("Exiting...")

if __name__ == '__main__':
    main()