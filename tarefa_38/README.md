# TAREFA 38 - SISTEMA DE LOGIN CON HASHING

**Desenvolvido por**: Sofía Otero
**Asignatura**: Programación de Servizos e Procesos (PSP)
**Versión**: 1.0

## Descrición
Este programa implementa unha simulación segura dun sistema de **Rexistro e Inicio de Sesión** (Login). O obxectivo principal é cumprir coa regra de ouro da ciberseguridade: **"Nunca se gardan os contrasinais en texto plano"**.

A aplicación utiliza o algoritmo **SHA-256** para transformar os contrasinais en cadeas hexadecimais irreversibles. Deste xeito, verifícanse as credenciais comparando os seus resumos (hashes) sen necesidade de expoñer os datos orixinais.

## Funcionamento
O fluxo de execución divídese en dúas fases:

**Fase de Rexistro**:
    * Solicita ao usuario crear un contrasinal.
    * Xera o hash SHA-256 do texto introducido.
    * Garda o hash nunha variable (simulando o almacenamento nunha Base de Datos).

**Fase de Login**:
    * Solicita ao usuario que introduza o seu contrasinal para entrar.
    * Calcula o hash do texto que acaba de escribir.
    * Compara o novo hash co hash gardado na fase de rexistro.

* **ACCESO CONCEDIDO**: Se os hashes coinciden matematicamente.
* **ERROR**: Se os hashes son diferentes (o contrasinal é incorrecto).
