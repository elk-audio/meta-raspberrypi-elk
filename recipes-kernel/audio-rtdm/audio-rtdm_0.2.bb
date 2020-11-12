SUMMARY = "Recipe for SPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ddecf3dbe612644d42605ad83584d7bb"

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/audio_rtdm.git;protocol=ssh;nobranch=1"
S = "${WORKDIR}/git/rpi"
SRCREV = "6b7a0669bc0b2adc51de30cd8c8af3a0551d88ff"

inherit module

S = "${WORKDIR}/git/rpi"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES_${PN} += "kernel-module-spi-audio-rtdm-${KERNEL_VERSION}"

