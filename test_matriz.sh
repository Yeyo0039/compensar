#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

build_dir=$(mktemp -d)
trap 'rm -rf "$build_dir"' EXIT

javac -d "$build_dir" MATRIS.java

output=$(printf '1\n2\n3\n4\n5\n6\n7\n8\n9\n' | java -cp "$build_dir" MATRIS)
negative_output=$(printf '%s\n' -9 -8 -7 -6 -5 -4 -3 -2 -1 | java -cp "$build_dir" MATRIS)
repeated_max_output=$(printf '9\n2\n3\n4\n9\n6\n7\n8\n9\n' | java -cp "$build_dir" MATRIS)

grep -q "El número mayor de la matriz es: 9" <<< "$output"
grep -q "La ubicación del número mayor es: \[2\]\[2\]" <<< "$output"
grep -q "La suma de los elementos de la matriz es: 45" <<< "$output"
grep -q "El número mayor de la matriz es: -1" <<< "$negative_output"
grep -q "La ubicación del número mayor es: \[2\]\[2\]" <<< "$negative_output"
grep -q "La suma de los elementos de la matriz es: -45" <<< "$negative_output"
grep -q "La ubicación del número mayor es: \[0\]\[0\]" <<< "$repeated_max_output"

echo "Prueba de MATRIS.java exitosa."
