#!/bin/sh

fnRename() {
  Type_=$1
  MinDepth_=$2
  MaxDepth_=$3
  From_=$4
  To_=$5
  depth_=$MinDepth_
  while [ $depth_ -le $MaxDepth_ ]
  do
    if [ "$Type_" = "any" ]
    then
    Files_=`find $DIR/ -mindepth $depth_ -maxdepth $depth_`
    else
    Files_=`find $DIR/ -mindepth $depth_ -maxdepth $depth_ -type $Type_`
    fi

    if [ -n "$Files_" ]
    then
    rename "s/`echo $From_`/`echo $To_`/" $Files_
    fi
    depth_=`expr $depth_ + 1`
  done
}

fnRename d 0 20 "\/$From" "\/$To"
fnRename d 0 20 "\/$from" "\/$to"

fnRename d 0 20 "\/J$From" "\/J$To"
fnRename d 0 20 "\/j$from" "\/j$to"

fnRename f 0 20 "\/$From" "\/$To"
fnRename f 0 20 "\/$from" "\/$to"

fnRename f 0 20 _$From  _$To
fnRename f 0 20 _$from  _$to

