# Signal Flow Graph
## Description
Signal flow graph is a graphical representation of algebraic equations. It is used to analyze the control Systems. It is also called Mason's Graph after Samuel Jefferson Mason. This graph consists of some nodes which represent the system variables and some branches which represent functional connections between pairs of nodes.
## How to install and the Run the program
- Initialize a new Java project on your preferred IDE.
- Replace the generated src folder with the our src folder
- Configure the IDE to run the class named Main
- Run the main function in the Main Class using the IDE
## How to use
- After running the program, The user is asked to enter the number of node of the graph(n).
- The program initialize n nodes which are numbered from 0 to n - 1.
- The user starts entering the edges in the following format:
    - source node,destination node,weight
    - For Example: 0,1,3
        This means that the edge is directed from the node(0) to node(1) and this edge has a weight 3.
- After entering all the edges, The user chose the calculate option to start calculating the overall gain.
## Features
- All the forward Paths from the node(0) to the node(n - 1).
- All the gains and delta(i) for each forward path.
- All the Loops either the normal loops or self loops and their gains.
- All the non-touching loops.
- The Delta and the overall gain.
## Features to be Added
- UnitTest
- GUI
## Contributes
@nada-086
@TokaAshraf12
@rowannasser