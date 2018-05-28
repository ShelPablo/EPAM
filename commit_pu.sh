#!/bin/bash
git add ./
git commit -m $1 -a
git remote add origin https://github.com/ShelPablo/EPAM
#git remote set-url origin https://github.com/ShelPablo/EPAM
git push origin master
