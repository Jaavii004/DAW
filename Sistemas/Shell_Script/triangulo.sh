#!/bin/bash

for i in $(seq 1 5); do
    for e in $(seq $i 5); do
        echo -n "*"
    done
    echo
done

echo
for u in $(seq 1 5); do
    for ((i = 1; i <= $u; i++)); do
        echo -n "*"
    done
    echo
done

echo 
for j in $(seq 1 5); do
    for ((i = 5; i >= $j; i--)); do
        echo -n " "
    done
    for ((i = 1; i <= $j; i++)); do
        echo -n "*"
    done
    for ((i = 2; i <= $j; i++)); do
        echo -n "*"
    done
    echo
done

exit 0