UMMARY = "Recipe for RPI rtdm audio driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

inherit module

SRC_URI = "git://git@bitbucket.org/mindswteam/rpi-rtdm-audio-driver.git;protocol=ssh;nobranch=1"

S = "${WORKDIR}/git"

SRCREV = "24da69bff692bbf20c997bc270c4591ad7438d8c"

RPROVIDES_${PN} += "kernel-module-audio-rtdm-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"
