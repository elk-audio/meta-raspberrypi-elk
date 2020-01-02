FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

DEPENDS_append_rpi = " rpi-u-boot-scr"

SRC_URI += "file://0001-patch-for-custom-defconfig.patch"