FILESEXTRAPATHS:prepend := "${THISDIR}/u-boot:"

DEPENDS:append_rpi = " rpi-u-boot-scr"

SRC_URI:append:raspberrypi4-64 = "\
    file://defconfig_elk \
"

do_configure:append() {
    cp ${WORKDIR}/defconfig_elk ${B}/.config
}
