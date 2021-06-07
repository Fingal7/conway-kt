# conway-kt
Kotlin application to learn how Conway's Game of life works.

# How it works
The application starts with 20 x 20 cells. Intially all cells are dead. With a mouse click you can flip a cell from dead to alive.

The next generation of cells is determined by the following rules:
- Any live cell with less than 2 live neighbors will die.
- Any live cell with 2 or 3 live neighbors survives.
- Any live cell with more than 3 neighbors dies.
- Any dead cell with 3 neighbors is resurrected.

You can, in every generation, change the state of a cell. There is also a reset button.

You can start with: 


![spaceship](https://user-images.githubusercontent.com/57390136/121036438-0c083200-c7af-11eb-83d2-813f5ace820a.PNG)

