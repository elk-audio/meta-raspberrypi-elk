FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

DEPENDS_append_rpi = " rpi-u-boot-scr"

SRC_URI_append_raspberrypi4-64 = " file://defconfig_elk \
"

do_configure_append() {
    cp ${WORKDIR}/defconfig_elk ${B}/.config
}
