SUMMARY = "Package group for elk related system packages for raspberrypi"

inherit packagegroup

RDEPENDS_packagegroup-elk-raspberrypi-system-pkgs = " \
    raspberrypi-systemd-services \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    bluez-firmware-rpidistro-bcm43430a1-hcd \
    bluez-firmware-rpidistro-bcm4345c0-hcd \
    iw \
    wireless-regdb \
    fw_utils \
    wpa-supplicant \
    udev-rules-rpi \
    crda \
    rpi-rtdm-audio-driver \
    rpi-shiftreg-rtdm-driver \
    elk-system-conf \
    "
