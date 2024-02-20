from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class HelloRequest(_message.Message):
    __slots__ = ("name", "lugarNacimiento", "anoNacimiento", "contrasena")
    NAME_FIELD_NUMBER: _ClassVar[int]
    LUGARNACIMIENTO_FIELD_NUMBER: _ClassVar[int]
    ANONACIMIENTO_FIELD_NUMBER: _ClassVar[int]
    CONTRASENA_FIELD_NUMBER: _ClassVar[int]
    name: str
    lugarNacimiento: str
    anoNacimiento: int
    contrasena: str
    def __init__(self, name: _Optional[str] = ..., lugarNacimiento: _Optional[str] = ..., anoNacimiento: _Optional[int] = ..., contrasena: _Optional[str] = ...) -> None: ...

class HelloReply(_message.Message):
    __slots__ = ("message", "status")
    MESSAGE_FIELD_NUMBER: _ClassVar[int]
    STATUS_FIELD_NUMBER: _ClassVar[int]
    message: str
    status: bool
    def __init__(self, message: _Optional[str] = ..., status: bool = ...) -> None: ...
