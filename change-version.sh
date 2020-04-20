#!/bin/sh

OLD=0.3.3-SNAPSHOT
NEW=0.3.3

for f in `find . -not -path "./.git/*" -not -path "./.gradle/*" \( ! -name change-version.sh \) -type f -exec grep -l $OLD {} \;`
do
    echo "changing version in " $f
    sed "s/$OLD/$NEW/g" < $f > f 
    mv f $f
done
