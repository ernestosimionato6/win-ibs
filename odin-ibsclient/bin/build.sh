#! /bin/bash

# clear;
printf '\n\n building ... \n\n';
printf ' > compiling';
javac -Xlint:unchecked -cp .:./libs/*:./target/dependency/*:./target/dependency/table/* -d ./target/classes -sourcepath src $(find src/ -name "*.java")
cp -R src/main/resources/* target/classes/
cd target/classes
# jar cf ../odin-ibsddclient.jar sdn
printf ' > packaging';
rm ../odin-ibsddclient.jar; 
jar cfm ../odin-ibsddclient.jar ./MANIFEST.MF sdn

cd ../../;
printf '\n\n done. \n\n';

