#! /bin/bash

sh ./build.sh;

# java -cp .:./target/dependency/*:./target/odin-ibsddclient.jar sdn.piano.ibs.dd.IBSDDMain
java -cp .:./target/dependency/*:./target/odin-ibsddclient.jar sdn.piano.ibs.dd.IBSDDSamples
