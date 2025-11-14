# Tarefa 29: Calculadora Cliente-Servidor 

##  Funcionamento 

Creei unha calculadora cliente-servidor. O Servidor acepta conexións e pasa cada petición de cálculo nun Fío Xestor, atendendo a
varios clientes á vez. O Cliente envía a operación e recibe o resultado do cálculo.

<img width="7000" height="500" alt="image" src="https://github.com/user-attachments/assets/99360b5b-f709-429e-9d32-ef457e6d8fe0" />



``` mermaid
sequenceDiagram
    participant Cliente
    participant Servidor
    participant Xestor

    Cliente->>Servidor: Solicita conexión
    Servidor->>Cliente: Conexión aceptada

    Servidor->>Xestor: Crear novo fío para cliente
    Xestor->>Cliente: Fío asignado

    loop Peticións
        Cliente->>Xestor: OPERACION NUM1 NUM2
        Xestor->>Xestor: Procesar operación
        Xestor->>Cliente: OK RESULTADO / ERROR MENSAXE
    end

    Cliente->>Xestor: ADIOS
    Xestor->>Cliente: Pechando conexión
    Xestor->>Xestor: Finalizar fío
