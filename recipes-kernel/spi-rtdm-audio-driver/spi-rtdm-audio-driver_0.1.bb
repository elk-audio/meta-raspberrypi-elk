SUMMARY = "Recipe for SPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

SRCREV = "334894d2a766ff8bcd2feaefa431a536eb57d9c0"
SRC_URI = "gitsm://github.com/elk-audio/spi-rtdm-audio-driver;protocol=https;nobranch=1"
S = "${WORKDIR}/git"

inherit module

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES_${PN} += "kernel-module-spi-audio-rtdm-${KERNEL_VERSION}"

