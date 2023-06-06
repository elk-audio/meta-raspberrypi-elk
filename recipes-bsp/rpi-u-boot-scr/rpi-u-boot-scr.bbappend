# rpi-u-boot-scr append
# Replace meta-raspberrypy boot script with custom elk boot script

FILESEXTRAPATHS:prepend := "${THISDIR}/${MACHINE}:"

COMPATIBLE = "${MACHINE}"

SRC_URI = "file://elk-boot.cmd.in"

# rename elk-boot.cmd.in to boot.cmd.in so that do_compile in rpi-u-boot-scr.bb
# compiles this file
do_compile:prepend () {
    cp ${WORKDIR}/elk-boot.cmd.in ${WORKDIR}/boot.cmd.in
}
