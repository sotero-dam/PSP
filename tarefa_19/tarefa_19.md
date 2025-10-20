# TAREFA OPTATIVA 19 - CONTADOR VOGAIS

**Desenvolvido por**: Sofía Otero

**Asignatura**: Programación de Servizos e Procesos (PSP)

**Versión**: 1.0

## 📋 Descrición
Creei un programa de contaxe concorrente de vogais nun texto de entrada, utilizando varios fíos en Java para facer a operación á vez.

<img width="300" height="300" alt="image" src="https://github.com/user-attachments/assets/16888500-14d7-47d2-b25a-eec1dab7b0f3" />


## ✅ Funcionalidades Implementadas

<img width="990" height="145" alt="image" src="https://github.com/user-attachments/assets/7fe59ade-1cdb-4cf6-a64e-abc19b5d448b" />

Creei a clase contadorTotal que usei para rexistrar os incrementos no numero total de vogais

<img width="1061" height="431" alt="image" src="https://github.com/user-attachments/assets/e529bf68-9695-422f-b3da-9dc10993be7d" />

Tras iso creei a clase FioContadorVogal que utiliza distintos fios para 
ir contando por separado cada unha das vogais, para evitar problemas con 
mayúsculas o texto é convertido a minúsculas

Para comprobar se é o non vogal, usei primeiro un switch para que as vogais
con acentos e con diéresis no caso da ü. 

<img width="738" height="214" alt="image" src="https://github.com/user-attachments/assets/49ecf6ff-8a1c-4262-81cc-b5db6999a073" />


Tras establecer as condicións os fíos recorren o texto simultáneamente, e no caso de 
atopar unha vogal, o fio encargado desa vogal a detectará e sumará 1 ao
contador propio e sumará tamén 1 ao contador global.

<img width="892" height="319" alt="image" src="https://github.com/user-attachments/assets/eb5234a8-0899-4399-b3f2-363f3dd3d188" />

Por último a clase ContadorVogaisConcorrente encargarase de executar o programa, xestionar a entrada introducida polo usuario e mostrar o resultado final
