#! /bin/bash

java -cp -Xlint:unchecked -cp .:./libs/*:./target/dependency/*:./target/odin-ibsddclient.jar sdn.piano.ibs.dd.IBSDDSamples
