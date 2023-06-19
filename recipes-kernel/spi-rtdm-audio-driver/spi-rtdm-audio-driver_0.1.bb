SUMMARY = "Recipe for SPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

SRCREV = "997e003e234e0cf4f9e45c5b70d0d976b5c0b59d"
SRC_URI = "gitsm://github.com/elk-audio/spi-rtdm-audio-driver;protocol=https;nobranch=1"
S = "${WORKDIR}/git"

inherit module

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES:${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES:${PN} += "kernel-module-spi-audio-rtdm-${KERNEL_VERSION}"
