#!/bin/bash

for i in $(seq 1 5); do
    for e in $(seq $i 5); do
        echo -n $e" "
    done
    echo
done


for u in $(seq 1 5); do
    for ((i = 1; i <= $u; i++)); do
        echo -n $i" "
    done
    echo
done


exit 0