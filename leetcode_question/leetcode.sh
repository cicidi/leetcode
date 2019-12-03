#!/bin/ksh
# Tested with ksh version JM 93t+ 2010-03-05
for i in {1..1300}
do
 # your-unix-command-here
 echo $i
 leetcode show $i -gx -l golang
done
