SUMMARY = "Recipe for SPI rtdm audio driver"
HOMEPAGE = "https://github.com/elk-audio/rpi-rtdm-audio-driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ddecf3dbe612644d42605ad83584d7bb"

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/audio_rtdm.git;protocol=ssh;nobranch=1"
S = "${WORKDIR}/git/rpi"
SRCREV = "09eb9c48aa789d75267dd868326a4a808c23cd45"

inherit module

S = "${WORKDIR}/git/rpi"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"

RPROVIDES_${PN} += "kernel-module-audio-rtdm-${KERNEL_VERSION}"

