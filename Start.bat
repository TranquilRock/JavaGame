del /f /q out\*
javac -sourcepath src -d out src\Main.java 
java -cp out Main