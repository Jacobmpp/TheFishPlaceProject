:loop
@echo on
javac TFPmain.java
java TFPmain
@echo off
DEL /s /q *.class
set /p asd=""
goto loop