#!/bin/sh

find $DIR/ -type f | xargs  sed -i "s/`echo $From`/`echo $To`/g"
find $DIR/ -type f | xargs  sed -i "s/`echo $from`/`echo $to`/g"
find $DIR/ -type f | xargs  sed -i "s/`echo $FROM`/`echo $TO`/g"

