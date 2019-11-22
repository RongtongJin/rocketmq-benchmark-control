#!/bin/sh

nohup bin/benchmark-worker >> worker.log 2>&1 &
