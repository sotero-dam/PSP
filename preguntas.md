# Examen 2 PSP - Sofía Otero Gil
## Exercicio 3
Non obterás sempre o mesmo resultado, xa que as prioridades son orientativas. As saídas poderían ser:

Hilo-Lento en iteracion 1;
...
Hilo-Rápido en iteración 1;
...

ou
Hilo-Rápido en iteración 1;
...
Hilo-Lento en iteracion 1;
...

O realemente efectivo sería xestionar os fios con start e join para así poder efectuar un control real. Deste xeito asegurarémonos de ter sempre a mesma orde de execución, xa que en Windows a prioirdade respétase mínimamente e en Linux e MACOS non se ten en conta.

## Exercicio 4
Non logrará executar o pedido xa que hay problemas de sincronización, precisa un bloque sincronizado.