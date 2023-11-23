#!/bin/bash
# Build Program
# Yes this is a linux program to build a windows jar its fineeee

# Project security check
HASH_CHECK=`cat hash.txt`
FILES=`tree -if --noreport --gitignore src data lib`
HASH=""
## Get hash of each file
for FILE in $FILES; do
    # Skip directories
    if [[ -f $FILE ]]; then
        HASH=$HASH:`sha1sum $FILE`
    fi
done
## Get hash of all files
HASH=`echo $HASH | sha1sum`
## Save new hash
if [[ $1 == "--genhash" ]]; then
    echo "$HASH" > hash.txt
    cat hash.txt
    exit
fi
## Project warning
if [[ $HASH != $HASH_CHECK ]]; then
    echo "Project Structure has been tampered with"
    echo "Do you want to continue?"
    read -p "[y/N]: " CONTINUE
    if [[ $CONTINUE == "N" || $CONTINUE == "n" || -z $CONTINUE ]]; then
        exit
    fi
fi

# Clean build directory
echo "Cleaning build directory"
rm -rf out/*
wait

# Build variables
JAVA_SRC=`tree -if --noreport --gitignore src | grep ".java"`
JAR_DIR="lib/javafx-sdk-21/lib"
LIB_DIR_SRC="lib/javafx-sdk-21/bin"
LIB_DIR_DEST="bin"
LIB_FILE_EXT="dll"
JAR_FILE="EPIC.jar"
RM_DEPS="out/bin/jfxwebkit.dll"

# Alternate values for linux systems
if [[ $1 == "--linux" ]]; then
    JAR_DIR="lib/javafx-sdk-21_linux/lib"
    LIB_DIR_SRC="lib/javafx-sdk-21_linux/lib"
    LIB_DIR_DEST="lib"
    LIB_FILE_EXT="so"
    JAR_FILE="EPIC_linux.jar"
    RM_DEPS="out/lib/libjfxwebkit.so"
fi

# Unpack Jar files to create a Fat Jar
#for f in lib/javafx-sdk-21/lib/*.jar; do 
for f in $JAR_DIR/*.jar; do 
    echo "Adding $f to package";
    # -o Overwrites Manifest of each file, might cause problems
    unzip -qo $f -d out/;
done

# Copy LIB files into build directory
echo "Copying system libraries"
mkdir out/$LIB_DIR_DEST
cp $LIB_DIR_SRC/*.$LIB_FILE_EXT out/$LIB_DIR_DEST/

# Compile java source files
echo "Compiling Java source code"

# calc compile depth
# DEPTH=`find src | grep ".java" | sort -nr | head -n 1 | tr -cd "/" | wc -m`
# JAVA_SRC="src"
# for ((i = 0 ; i < $DEPTH; i++)); do
#     JAVA_SRC=$JAVA_SRC"/*"
# done
# JAVA_SRC=$JAVA_SRC".java"
# echo "JAVA_DEPTH: " $DEPTH
# echo "JAVA_SRC: " "$JAVA_SRC"
# javac -d out/ -sourcepath src $JAVA_SRC --module-path $JAR_DIR --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls

# for SRC_FILE in $JAVA_SRC; do
#     javac -d out/ -sourcepath src $SRC_FILE --module-path $JAR_DIR --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls
# done

javac -d out/ -sourcepath src src/*/*.java --module-path $JAR_DIR --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls
javac -d out/ -sourcepath src src/*/*/*.java --module-path $JAR_DIR --add-modules javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.controls

# File Work
echo "Completing file tree structure"
## Copy FMXL files
cp -r src/quizgame/resource out/quizgame/
## Copy Data Structures
cp -r data out/
## Remove Blank Manifest from Jar files
rm out/META-INF/MANIFEST.MF

rm $RM_DEPS

# Create Jar file
echo "Creating Jar File"
jar cfm $JAR_FILE META-INF/MANIFEST.MF -C out/ . || { echo "Build failed"; exit; }

# Done
echo "Jar built"