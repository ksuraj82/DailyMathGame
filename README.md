About:

# Daily Math Game

A Java-based math game built in Eclipse. 

Version : 1.0.0
Date: 12-03-2026
Feature: 
1. Portable - ready to run app with no configuration change is required.
2. Math Games: Addtion, Subtraction , division and multiplication with endless attempt.

## 🚀 Download Executable
You can download the latest version of the game here:


Windows executable file:


## 🛠️ How to Build the Package
If you want to create the executable (`.jar` file) manually, use the following command in your terminal:
2. Download the above code in eclipse and export as Java Runnable Jar file.
3. Once the Jar file is created , then download the postgresql driver from official website and place as below format:
--EclipseWorkspace
  |__Project_DailyGame
    |__pnput
    | |__DailyMathGame.jar
    | |__Postgresql.xxx.jar(driver file)
    |__output

4. once the jar file is placed/created in the above Input folder with postgresql driver, then execute the below command in windows command line to create the windows executable file:
>>jpackage.exe --type app-image --dest "D:/EclipseWorkspace/output" --input "D:/EclipseWorkspace/input" --name "DailyMathGame" 
--main-jar "DailyMath.jar" --win-console --main-class arithmetic.MainAppGUI --icon "D:/CodingFiles/Calculator/favicon.ico" --vendor "Yout_name" 
--app-version "1.0.0"



