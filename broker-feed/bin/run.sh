#!/bin/bash

SERVICE_NAME=broker-feed
PATH_TO_JAR=~/broker-feed/broker-feed-0.0.1-SNAPSHOT.jar
PID_PATH_NAME=~/broker-feed/application.pid
JVM_OPTS="-Xmx1g"
SPRING_OPTS="--logging.file=broker-feed-0.0.1-SNAPSHOT.jar.log"

case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            nohup java $JVM_OPTS -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null $SPRING_OPTS &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
           
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            nohup java $JVM_OPTS -jar $PATH_TO_JAR  /tmp 2>> /dev/null >> /dev/null $SPRING_OPTS &
			
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac 
