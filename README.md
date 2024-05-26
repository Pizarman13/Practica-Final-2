# Practica-Final-2
https://github.com/Pizarman13/Practica-Final-2.git

Aplicación para gestionar cultivos de bacterias II

Para esta segunda parte lo primero que he hecho es cambiar el valor de maximo de comida de 300 a 300000 y cambiar el valor fijo de dias de los experimentos .
Luego creé los otros tres metodos para selecionar la comida, los cuales seran elegidos en el menu.
Tambien he implementado en el menu diferentes opciones para selecionar la ordenación del listado de poblacion de bacterias.

Para la simulacion de Montecarlo he creado un nuevo paquete, conteniendo las clases, PlatoCultivo, Celda y Bacteria.
Dentro del constructor de PlatoCultivo se inicializa el plato y se reparten las bacterias en el centro de este.
La funcion simulaDia simula todo lo que le ocurre en el plato cada dia, esta funcion primero reparte la comida a partes iguales por todo el plato, luego recorrera el plato y se llamara a la funcion comerYmoverse, si la bacteria sigue viva y se mueve se llamara a la funcion moverBacteria, en caso que la bacteria muera sera borrada del linkedList de bacterias. (Esto se repite 10 veces por día)
Tras esto se llamara a la funcion de reproducirse la cual segun el numero de comida consumida que consuma la bacteria esta tendra n hijos.

Errores a tener en cuenta:
No he podido conectar la simulacion de montecarlo con el resto del experimento.
A la hora de visualizar no se porque pero el numero de bacterias por celda siempre es 0.
