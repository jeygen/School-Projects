#!/bin/bash

echo "Insertion Sort with 5000 ascending sorted numbers"
time  ./insertionSort < bestInsert.txt
echo " "
echo "Insertion Sort with 5000 descending numbers"
time ./insertionSort < worstInsert.txt
echo " "
echo "Insertion Sort with 5000 random numbers"
time ./insertionSort < avgInsert.txt
echo " "