Creei a clase contadorTotal que usei para rexistrar os incrementos no numero total de vogais

Tras iso creei a clase FioContadorVogal que utiliza distintos fios para 
ir contando por separado cada unha das vogais, para evitar problemas con 
mayúsculas o texto é convertido a minúsculas

Para comprobar se é o non vogal, usei primeiro un switch para que as vogais
con acentos e con diéresis no caso da ü. 

Tras establecer as condicións os fíos recorren o texto simultáneamente, e no caso de 
atopar unha vogai, o fio encargado desa vogai a detectará e sumará 1 ao
contador propio e sumará tamén 1 ao contador global.

por último a clase ContadorVogaisConcorrente encargarase de executar o programa, xestionar a entrada
introducida polo usuario e mostrar o resultado final