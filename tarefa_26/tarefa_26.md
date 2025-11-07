# TAREFA 27- MENSAXES ECO CLIENTE

**Desenvolvido por**: Sofía Otero

**Asignatura**: Programación de Servizos e Procesos (PSP)

**Versión**: 1.0

## 📋 Descrición
Deseñei unha aplicacion de dous programas que falan de forma continua, o Servidor escoita e un Cliente que fala. 
Busco empregar un protocolo Eco.

<img width="641" height="542" alt="image" src="https://github.com/user-attachments/assets/2998b54d-f884-4981-bd15-208edcfa09b2" />


## ✅ Funcionalidades Implementadas
### Clase do Server
<img width="887" height="113" alt="image" src="https://github.com/user-attachments/assets/d5f4bfad-ec50-40c0-935a-ad888d1368de" />

Inicio o servidor e este quedar agardando a qeu o cliente se conecte 

<img width="1119" height="72" alt="image" src="https://github.com/user-attachments/assets/2b733628-dab5-498e-acb0-3c598df4aa24" />

Cando se conecte, configuro as ferramentas pra ler ,BufferedReader para a entrada, e escritura ,PrintWriter para a saída, dentro do 
try-with-resources para facer cierre automático.

<img width="1100" height="253" alt="image" src="https://github.com/user-attachments/assets/78ba4156-2e57-468e-9921-4e4ba5d3a30a" />

O server entra nun bucle infinito onde le a liña que o cliente lle envía
  Se e null ou escribe a palabra 'adios' o servidor remata.
  Se non se dan os casos anteriores, devolve o escrito ao cliente.

### Clase do Cliente

<img width="1135" height="175" alt="image" src="https://github.com/user-attachments/assets/0a84ecad-56af-4401-94b2-8f1a50e027fc" />

O cliente tenta conectarse ao HOST:PORTO usando a clase Socket. Se non está activo o server, mostra unha mensaxe.
Configuro tamén os streams ,PrintWriter, e a lectura ,BufferedReader, da resposta.

<img width="694" height="337" alt="image" src="https://github.com/user-attachments/assets/81bee3ae-bff0-44c0-95ab-c08face9e424" />

Igual co server o cliente tamén entra nun bucle infinito. Le o texto que o usuario escribe e envíao ó servidor.

 * Se escribe adiós remata a conexion
  
 * Noutro caso, espera a resposta do server.
  
Empreguei try-with-resources porque garantiza o peche automático e eficiencia dos Socket, ServerSocket, BufferedReader e PrintWriter.
Xa que vin que era unha boa práctica.
  

