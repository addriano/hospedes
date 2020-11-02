# API CHECK-IN
# Importação
```
Importe o projeto para o eclipce:
File > Import > Maven > Existing Maven Projects.
```
# Configure a conexão com o banco
```
Configure o Banco de dados:
src/main/resources/application.properties.
```
# Rode a aplicação
```
Rum as -> Java Application.

Lincks:

Crudl para Check-in:

Trazer  todos os check-ins get: /api/checkin.
Trazer check-in especifico get: /api/checkin/{id}
Novo check-in Post: /api/checkin/ 
Editar check-in put: /api/checkin/
Deletar check-in Delete: /api/checkin
Buscar check-in Hóspede Get: /api/checkin/buscar/?hospedeId={id}&inCheckIn={boolean}

Crudl para Hóspedes:

Trazer  todos os hospedes get: /api/hospedes.
Trazer hospede especifico get: /api/hospedes/{id}
Novo hospede Post: /api/hospedes/ 
Editar hospede put: /api/hospedes/
Deletar hospede Delete: /api/hospedes
Buscar hospedes por nome documento ou telefone Get: /api/hospedes/{campo}



