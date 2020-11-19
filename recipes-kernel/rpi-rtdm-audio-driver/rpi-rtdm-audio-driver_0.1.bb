SUMMARY = "Recipe for RPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

SRC_URI = "git://github.com/elk-audio/rpi-rtdm-audio-driver.git;protocol=https;nobranch=1"
SRCREV = "7b2132341c4d2ca42fb156c28b65427aac38c57a"

inherit module

S = "${WORKDIR}/git"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES_${PN} += "kernel-module-audio-rtdm-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-bcm2835-i2s-elk-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-pcm3168a-elk-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-pcm1863-elk-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-pcm5122-elk-${KERNEL_VERSION}"

