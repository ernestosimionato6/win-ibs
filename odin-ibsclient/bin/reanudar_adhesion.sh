#! /bin/bash


java -cp -Xlint:unchecked -cp .:./libs/*:./target/dependency/*:./target/dependency/table/*:./target/odin-ibsddclient.jar sdn.piano.ibs.dd.commands.IBSDDReanudarDebitoAdheridoCommand $1 $2 $3
