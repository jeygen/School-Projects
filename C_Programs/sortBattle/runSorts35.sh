#!/bin/bash

echo "Insertion Sort with 35 unsorted numbers"
time  ./insertionSort < numList35.txt
echo " "
echo "Merge Sort with 35 unsorted numbers"
time ./mergeSort < numList35.txt
echo " "

