from coapthon.server.coap import CoAP
from coapthon.resources.resource import Resource
from coapthon import defines

class SampleGETResource(Resource):
    def __init__(self, name="name", coap_server=None):
        super().__init__(name, coap_server, visible=True,
                                            observable=True, allow_children=True)
        self.payload = "T-Car Model Name: T-LAMBOGHINI"

    def render_GET(self, request):
        return self

class SpeedGETResource(Resource):
    def __init__(self, name="speed_get", coap_server=None):
        super().__init__(name, coap_server, visible=True,
                                            observable=True, allow_children=True)
        self.payload = "0.0" # km/h

    def render_GET(self, request):
        return self

class SpeedPUTResource(Resource):
    def __init__(self, name="speed_put", coap_server=None):
        super().__init__(name, coap_server, visible=True,
                                            observable=True, allow_children=True)
        self.status = "0.0" # km/h

    def render_PUT_advanced(self, request,response):
        response.payload = ""
        response.code = defines.Codes.CHANGED.number
        try: # Speed has to be float or int
            speed= float(request.payload)
        except :
            response.code = defines.Codes.BAD_REQUEST.number
            return self, response

        if (speed >= 0): # Speed can't be < 0
            self.status = str(speed)
        else:
            response.code = defines.Codes.BAD_REQUEST.number


        print("***********************", self.status,"***********************")

       
        return self, response   

class SamplePUTResource(Resource):
    def __init__(self, name="light", coap_server=None):
        super().__init__(name, coap_server, visible=True,
                                            observable=True, allow_children=True)
        self.status = "sample-status"

    def render_PUT_advanced(self, request,response):
        response.payload = ""
        response.code = defines.Codes.CHANGED.number
 
        if (request.payload == "green"):
            self.status = "green"
        elif (request.payload == "white"):
            self.status = "white"
        elif (request.payload == "blue"):
            self.status = "blue"
        elif (request.payload == "red"):
            self.status = "red"
        elif (request.payload == "off"):
            self.status = "off"
        else:
            response.code = defines.Codes.BAD_REQUEST.number


        print("***********************", self.status,"***********************")

       
        return self, response   

class CoAPServer(CoAP):
    def __init__(self, host, port):
        CoAP.__init__(self, (host, port))
        self.add_resource('name/', SampleGETResource())
        self.add_resource('light/', SamplePUTResource())
        self.add_resource('speed_get/', SpeedGETResource())
        self.add_resource('speed_put/', SpeedPUTResource())

def main():
    server = CoAPServer("0.0.0.0", 5683)
    try:
        server.listen(10)
    except KeyboardInterrupt:
        print("Server Shutdown")
        server.close()
        print("Exiting...")

if __name__ == '__main__':
    main()