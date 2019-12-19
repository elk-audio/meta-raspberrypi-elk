UMMARY = "Recipe for RPI rtdm audio driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

inherit module

SRC_URI = "git://git@bitbucket.org/mindswteam/rpi-rtdm-audio-driver.git;protocol=ssh;nobranch=1"

S = "${WORKDIR}/git"

SRCREV = "a0e328c85b7ab20e32545505cfbc8fca0a7fdcc7"

RPROVIDES_${PN} += "kernel-module-audio-rtdm-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-bcm2835-i2s-elk-${KERNEL_VERSION}"
RPROVIDES_${PN} += "kernel-module-pcm3168a-elk-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"
