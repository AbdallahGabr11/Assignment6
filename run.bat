@echo off
javac *.java
java Project autosar.arxml
java Project empty.arxml
java Project autosar.txt
pause