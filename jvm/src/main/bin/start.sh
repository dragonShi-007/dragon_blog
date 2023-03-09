#!/bin/sh
BASEDIR=`dirname $0`/..
BASEDIR=`(cd "$BASEDIR"; pwd)`

if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD=`which java`
  fi
fi


CLASSPATH="$BASEDIR"/conf:"$BASEDIR"/lib/*
LOGDIR="$BASEDIR/log/"

echo "$CLASSPATH"

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly."
  echo "  We cannot execute $JAVACMD"
  exit 1
fi

if [ -z "$JAVA_OPTS" ] ; then
    JAVA_OPTS="-Xms4G -Xmx4G -Xss512K -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/export/Logs/dragon_blog/java_pid.hprof
    -Dpinpoint.applicationName=dragon_blog"
fi
nohup "$JAVACMD" $JAVA_OPTS \
  -classpath "$CLASSPATH" \
  -Dbasedir="$BASEDIR" \
  -Dfile.encoding="UTF-8" \
  com.dragon.main.JVMParam \
  "$@" >/export/Logs/start_up.log 2>&1 &