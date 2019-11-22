#!/bin/sh

pid=`ps ax | grep -i 'BenchmarkWorker' |grep java | grep -v grep | awk '{print $1}'`
if [ -z "$pid" ] ; then
        echo "No worker running."
        exit 0;
fi

echo "The worker(${pid}) is running..."

kill -9 ${pid}

echo "Send shutdown request to worker(${pid}) OK"
