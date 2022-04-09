:loop
@echo on
javac TFPmain.java
java TFPmain
@echo off
DEL /s /q *.class >nul
set /p asd=""
goto loop