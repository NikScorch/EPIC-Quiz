#!/bin/bash
# Build Program
# Yes this is a linux program to build a windows jar its fineeee

# Clean build directory
rm -rf out/* &&

# Unpack Jar files to create a Fat Jar
for f in lib/javafx-sdk-21/lib/*.jar; do 
    echo "Adding $f to ";
    # -o Overwrites Manifest of each file, might cause problems
    unzip -qo $f -d out/;
done

# Copy DLL files into build directory
mkdir out/bin
cp lib/javafx-sdk-21/bin/* out/bin/

# Compile java source files
echo "Compiling Java source code"
javac -d out/ -sourcepath src src/*/*.java --module-path lib/javafx-sdk-21/lib --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls

# File Work
echo "Completing file tree structure"
## Copy FMXL files
cp -r src/quizgame/resource out/quizgame/
## Copy Data Structures
cp -r data out/
## Remove Blank Manifest from Jar files
rm out/META-INF/MANIFEST.MF

rm out/bin/jfxwebkit.dll

# Create Jar file
echo "Creating Jar File"
jar cfm EPIC.jar META-INF/MANIFEST.MF -C out/ . || { echo "Build failed"; exit; }

# Done
echo "Jar built"