#!/bin/bash

echo "Insertion Sort with 1000 unsorted numbers"
time  ./insertionSort < numList1000.txt
echo " "
echo "Merge Sort with 1000 unsorted numbers"
time ./mergeSort < numList1000.txt
echo " "

