#!/bin/bash

echo "Merge Sort with 5000 ascending sorted numbers"
time  ./mergeSort < bestInsert.txt
echo " "
echo "Merge Sort with 5000 descending numbers"
time ./mergeSort < worstInsert.txt
echo " "
echo "Merge Sort with 5000 random numbers"
time ./mergeSort < avgInsert.txt
echo " "