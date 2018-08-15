#!/bin/sh
From="SampleProject"
To=$1
PKG="$(echo $To | tr '[A-Z]' '[a-z]')"
# keep sure that unecessary folder will be removed
cd SampleProject
rm build -rf
rm .idea -rf
rm .gradle -rf
cd ..
# end remove block
FROM=`echo $From | tr [:lower:] [:upper:]`
TO=`echo $To | tr [:lower:] [:upper:]`

from=`echo $From | tr [:upper:] [:lower:]`
to=`echo $To | tr [:upper:] [:lower:]`

DIR=$From

cp -r "SampleProject" "SampleProject_b499d90d493a9842"

echo "Replace/rename: $From -> $To | $from -> $to | $FROM -> $TO"
echo "In dir: `pwd`/$DIR"

if [ ! -e $DIR ]
then
echo $DIR is not exist!
exit;
fi

CUR_DIR=`pwd`
TMP_DIR=tmp
#create tmp
rm -rf $TMP_DIR
mkdir -p $TMP_DIR
cd $DIR/src/main/java/com/hoanld
mv sampleproject $PKG
cd ../../../../../..
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Init
echo Initializing ...
cd $DIR
gradle clean
rm -rf `find -name .svn`
rm -f `find -type l`
cd $CUR_DIR

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Rename
echo Renaming ...
. ./prjgen_rename.cmd

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Replace
echo Replacing ...
. ./prjgen_replace.cmd

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#Final
echo Finalizing ...
cd $CUR_DIR
#rename project dir
mv ./$DIR ./"$To".New
#remove tmp
rm -rf $TMP_DIR

mv "SampleProject_b499d90d493a9842" "SampleProject"
mv $To.New $To
echo Done.

