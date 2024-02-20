from concurrent import futures

import grpc
import autenticador_pb2
import autenticador_pb2_grpc

class Autenticador(autenticador_pb2_grpc.AutenticadorServicer):

    def autenticar(self, request, context):
        if not request.contrasena=='distribuidos':
            # context.set_code(grpc.StatusCode.INVALID_ARGUMENT)
            # context.set_details('Contra incorrecta')
            return autenticador_pb2.HelloReply(message='contra equivocada', status=False)
        return autenticador_pb2.HelloReply(message="¡Hola %s!" % request.name, status=True)


def ofrece_servicios():
    puerto = "50051"    
    servidor = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    autenticador_pb2_grpc.add_AutenticadorServicer_to_server(Autenticador(), servidor)
    servidor.add_insecure_port("[::]:" + puerto)
    servidor.start()
    print("Servidor escuchando en " + puerto)
    servidor.wait_for_termination()

if __name__ == "__main__":
    ofrece_servicios()