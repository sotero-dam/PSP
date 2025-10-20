# TAREFA OPTATIVA 20 - BUZÓN DE CARTAS

**Desenvolvido por**: Sofía Otero

**Asignatura**: Programación de Servizos e Procesos (PSP)

**Versión**: 1.0



## 📋 Descrición

Tentei simular o envío de cartas usando fíos, varias tarefas á vez en Java. A miña idea era crear un Buzon que só poida gardar unha carta cada vez. Dous fíos Escritor ,poñen cartas, e dous fíos Lector ,que as sacan, teñen que poñerse de acordo para usalo. Se o buzón está cheo, o escritor espera; se está baleiro, o lector espera.

<img width="1000" height="1000" alt="image" src="https://github.com/user-attachments/assets/e0b43fbe-b9b8-4ef7-91e4-2f234eaf446d" />


## ✅ Funcionalidades Implementadas

### Clase Buzón
Aquí desenvolvo a lóxica de sincronización, fundamentalmente, céntrome en que o lector e o escritor non poidan modificar á vez. Estes ,se non poden realizar á operación, deben agardar.

<img width="709" height="279" alt="image" src="https://github.com/user-attachments/assets/17592d40-86df-487d-9599-eed08be5ea76" />

Cando o Escritor tenta poñer a carta e o Buzón xa está cheo (!baleiro), o fío para e usa wait() ata que o esperten. CAndo xa escribe a carta, pon o interruptor en cheo (baleiro = false) e avisa a todos os demais fíos con notifyAll.

<img width="678" height="343" alt="image" src="https://github.com/user-attachments/assets/adbd6a1c-857f-49fc-93f7-ecbffd5340d4" />

Tamén, se un Lector tenta sacar a carta e o Buzón está vacío (baleiro), o fío para e agarda (wait()). Cando pode lela, pon o interruptor en baleiro de novo (baleiro = true), borra o contido da carta do Buzón, e tamén avisa aos demais fíos (notifyAll()) deixando que os Escritores poidan volver.

### Clase Lector/Escritor
#### Escritora

<img width="636" height="204" alt="image" src="https://github.com/user-attachments/assets/214f7c9a-5d5a-4777-aec8-9af54e24a944" />

As escritoras tentan por 3 cartas cada unha. Devolvendo unha mensaxe concreta, que indica o número de carta e quen a envía. Despois de cada intento de por unha carta, a escritora descansa 500 milisegundos.

#### Lectora

<img width="473" height="239" alt="image" src="https://github.com/user-attachments/assets/a07a72ed-774f-400a-b0d5-8077f0b23174" />

Os fíos lectoras sacan 3 cartas cada unha. Entre cada intento de lectura, esperan un pouco máis, 700 milisegundos.

### Clase Estructura

<img width="519" height="249" alt="image" src="https://github.com/user-attachments/assets/d3bd1027-d34d-4691-bd7e-b330fec151ef" />

Nela recollo os meus fíos. Ahí creo un único Buzón que todos van compartir entre eles. Logo, pon en marcha os dous Escritoras e os dous Lectoras á vez, usando o método start() en cada un para que comecen a traballar de forma concorrente e sincrona.





