SUMMARY = "Package group for elk related system packages for raspberrypi"

inherit packagegroup

RDEPENDS_packagegroup-elk-raspberrypi-system-pkgs = " \
    raspberrypi-systemd-services \
    iw \
    "