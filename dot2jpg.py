#!/usr/bin/python3

from subprocess import call
from os import listdir

basedir = 'graphs/'

files = listdir(basedir)
names = []

for f in files:
    names.append(f[:-4])
    
for n in names:
    out = open('jpegs/' + n + '.jpg', 'w')
    call(['dot', '-Tjpg', basedir + n + '.dot'], stdout=out)