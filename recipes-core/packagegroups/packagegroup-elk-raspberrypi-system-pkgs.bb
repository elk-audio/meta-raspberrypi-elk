SUMMARY = "Package group for elk related system packages for raspberrypi"

inherit packagegroup

RDEPENDS_packagegroup-elk-raspberrypi-system-pkgs = " \
    spi-rtdm-driver \
    raspberrypi-systemd-services \
    iw \
    "