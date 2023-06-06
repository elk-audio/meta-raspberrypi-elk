#!/bin/bash

if [ -f /tmp/hat-not-supported ]; then
    AUDIO_HAT=$(cat /tmp/audio_hat)
    echo "Sorry, ${AUDIO_HAT} hat is not currently supported."
    echo ""
fi

if [ -f /tmp/audio-driver-load-failed ]; then
    echo "Audio driver load failed."
    echo ""
fi
