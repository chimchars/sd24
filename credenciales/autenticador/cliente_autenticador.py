import grpc
import autenticador_pb2
import autenticador_pb2_grpc

def run():
    print("Holahola")
    with grpc.insecure_channel("localhost:50051") as channel:
        stub = autenticador_pb2_grpc.AutenticadorStub(channel)
        resp = stub.autenticar(autenticador_pb2.HelloRequest(name="Octavio", lugarNacimiento="jalisco", anoNacimiento=1990, contrasena="distribuid1os"))
        print("Cliente recibio:", resp.message)

if __name__ == "__main__":
    run()


