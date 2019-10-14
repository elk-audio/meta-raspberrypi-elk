SUMMARY = "Package group for elk related system packages for raspberrypi"

inherit packagegroup

RDEPENDS_packagegroup-elk-raspberrypi-system-pkgs = " \
    raspberrypi-systemd-services \
    linux-firmware-bcm43430 \
    iw \
    rpi-rtdm-audio-driver \
    rpi-shiftreg-rtdm-driver \
    elk-system-conf \
    "