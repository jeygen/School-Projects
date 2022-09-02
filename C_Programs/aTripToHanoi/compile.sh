#!/bin/bash

make(){
	echo "Compiling towers.c and towersMain.c into object files."
	gcc -c towers.c towersMain.c -O2 -std=c11
	echo "Done"
	echo " "

	echo "Linking towers.c and towersMain.c into towers."
	gcc -o towers towers.o towersMain.o -O2 -std=c11
	echo "Done"
	echo " "
}

make
exit 1;
