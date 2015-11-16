#!/bin/bash

# find current script dir
SOURCE="${BASH_SOURCE[0]}"

while [ -h "$SOURCE" ]; do
  DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
  SOURCE="$(readlink "$SOURCE")"
  [[ $SOURCE != /* ]] && SOURCE="$DIR/$SOURCE"
done

SCRIPT_NAME=$0
COMMAND=$1
SERVICE=$2

DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
BASE_PATH="/tmp/$SCRIPT_NAME-services"
APPDIR="$BASE_PATH/$SERVICE"
PIDFILE="$APPDIR/application.pid"
LOGFILE="$APPDIR/application.log"

cd $DIR
mkdir -p "$APPDIR"

pid_file_exists() {
    return $([ -f $PIDFILE ])
}

print_process() {
    echo $(<"$PIDFILE")
}

print_running() {
    RUNNING=$(find $BASE_PATH -name "*.pid" -print | \
        sed "s:$BASE_PATH/:- :" | \
        sed 's:/[^/]*$::')
    
    if [ -n "$RUNNING" ]; then 
        echo "running services:"
        echo "$RUNNING"
    fi
}

case "$COMMAND" in
    status)
        if pid_file_exists; then
            echo "$SERVICE is running"
        else
            echo "$SERVICE is stopped."
        fi
    ;;
    
    stop)
        if ! pid_file_exists; then
            echo "$SERVICE already stopped"
            exit 0
        fi
        
        kill $(print_process)
        
        NOT_KILLED=1
        
        for i in {1..20}; do
            if pid_file_exists; then
                sleep 1
            else
                NOT_KILLED=0
            fi
        done

        if [ $NOT_KILLED = 1 ]; then
            echo "cannot kill $SERVICE"
            exit 1
        fi
    ;;
    
    start)
        if pid_file_exists; then
            echo "$SERVICE already running"
            exit 1
        fi
        
        NOT_STARTED=1
        
        mvn --projects $SERVICE spring-boot:run \
            -Drun.arguments="--spring.pidfile=$PIDFILE" \
            > $LOGFILE 2>&1 &

        for i in {1..60}; do
            if ! pid_file_exists; then
                sleep 1
            else
                NOT_STARTED=0
            fi
        done
        
        if [ $NOT_STARTED = 1 ]; then
            echo ""
            echo "starting $SERVICE failed"
            echo "see '$LOGFILE' for more information"
            exit 1
        fi
    ;;
    
    restart)
        $SCRIPT_NAME stop
        if [ $? = 1 ]; then
            exit 1
        fi
        $SCRIPT_NAME start
    ;;
    
    *)
        echo "usage: $SCRIPT_NAME {start|stop|restart|status} relative-path"
        print_running
        exit 1

esac
exit 0