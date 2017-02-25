JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
%.class: %.java
	$(JC) $(JFLAGS) $^

CLASSES = \
	randmst.java \
	Prims.java \
	randomGen.java

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) *.class