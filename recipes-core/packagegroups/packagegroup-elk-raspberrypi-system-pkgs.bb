SUMMARY = "Package group for elk related system packages for raspberrypi"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-raspberrypi-system-pkgs = "\
    raspberrypi-systemd-services \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    bluez-firmware-rpidistro-bcm43430a1-hcd \
    bluez-firmware-rpidistro-bcm4345c0-hcd \
    iw \
    wireless-regdb \
    libubootenv \
    u-boot-fw-utils \
    wpa-supplicant \
    udev-rules-rpi \
    htpdate \
    rpi-rtdm-audio-driver \
    spi-rtdm-audio-driver \
    rpi-shiftreg-rtdm-driver \
    elk-system-conf \
    userland \
    kernel-devicetree \
    kernel-image \
"

