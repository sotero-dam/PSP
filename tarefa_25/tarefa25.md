# TAREFA 25 - RASTREXADOR DE PORTOS

**Desenvolvido por**: Sofía Otero

**Asignatura**: Programación de Servizos e Procesos (PSP)

**Versión**: 1.0

## 📋 Descrición
Deseñei un programa cuxo obxetivo principal é mirar se certos portos están abertos ou pechados.

<img width="615" height="409" alt="image" src="https://github.com/user-attachments/assets/b3efb21d-b497-448c-9edd-80868f1d1366" />

## ✅ Funcionalidades Implementadas

<img width="437" height="40" alt="image" src="https://github.com/user-attachments/assets/07a9976b-0b01-4a6c-a45c-612c296d3b74" />

### Empezo pendíndolle ao usuario que introduza a sua dirección IP ou o localhost.

<img width="697" height="45" alt="image" src="https://github.com/user-attachments/assets/c3e7d384-ad97-4fc5-b660-5d39b505abca" />

### Defino unha lista de portos que se indican no enunciado, os máis famosos.

<img width="758" height="154" alt="image" src="https://github.com/user-attachments/assets/292181f2-6efb-4f46-a885-965a2c0a4cd8" />

### Fago unha proba usando a clase socket, para verificar o porto.
Se a miña conexión funciona, é dicir try. Quere dicir que hai un servizo escoitando ese porto e o programa di que está aberto.
Doutra banda se falla, catch, non hai ninguén escoitando ese porto ou o acceso está bloqueado. Indico pechado ao usuario.
### O proceso repetirase unha tras outra grazas ao while ata que o user escriba sair.

<img width="664" height="59" alt="image" src="https://github.com/user-attachments/assets/c388d3e1-e496-4494-b260-a860dfa04a9f" />

### Despois de cada intento pecho o socket para aforrar recursos.

