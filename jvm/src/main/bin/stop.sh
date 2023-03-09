#!/bin/sh

datapath='com.dragon.main.JVMParam'
PIDPROC=$(ps -ef | grep ${datapath} | grep -v 'grep'| awk '{print $2}')

if [ -z "$PIDPROC" ];then
 echo "${datapath} is not running"
 exit 0
fi

echo "PIDPROC: "$PIDPROC
for PID in $PIDPROC
do
if kill -9 $PID
   then echo "process ${datapath}(Pid:$PID) was force stopped at " `date`
fi
done
echo stop finished.