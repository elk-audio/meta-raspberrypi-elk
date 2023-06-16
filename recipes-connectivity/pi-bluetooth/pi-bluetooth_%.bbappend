# This is a fix to a race condition we found in Bluetooth hci uart initialization

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://0001-Added-requires-systemd-dependency-on-hciuart-service.patch \
"
