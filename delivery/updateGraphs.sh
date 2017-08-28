#!/bin/bash

# Cleanup old graphs
rm pixy/graphs/*
rm jpegs/*

# Run taint analysis
./pixy/run-all.pl -a -A -g -y xss schoolmate/index.php

# Cleanup useless graphs
rm pixy/graphs/sql*
rm pixy/graphs/*_dep.dot

# Cleanup TXTs
rm pixy/graphs/*.txt

# Convert graphs to JPGs
./dot2jpg.py
