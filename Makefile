run:
	rm -r out/
	javac -sourcepath src -d out src/Main.java 
	java -cp out Main
