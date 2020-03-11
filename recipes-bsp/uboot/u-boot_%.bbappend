FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

DEPENDS_append_rpi = " rpi-u-boot-scr"

SRC_URI_append_raspberrypi3 += "file://0001-patch-for-custom-defconfig.patch"
SRC_URI_append_raspberrypi4-64 = "file://0001-Fix-for-video-device-setup-error.patch"