SUMMARY = "Recipe for RPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

SRC_URI = "git://github.com/elk-audio/rpi-rtdm-audio-driver.git;protocol=https;nobranch=1"
SRCREV = "378cdfe277e6042709dbfb8ed408fd0d9c3325c0"

inherit module

S = "${WORKDIR}/git"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES:${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES:${PN} += "kernel-module-rpi-audio-rtdm-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-bcm2835-i2s-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm3168a-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm1863-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm5122-elk-${KERNEL_VERSION}"
