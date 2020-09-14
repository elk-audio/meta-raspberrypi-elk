SUMMARY = "Recipe for Audio RTDM driver for the ucm i.mx8m mini"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ddecf3dbe612644d42605ad83584d7bb"

inherit module

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/audio_rtdm.git;protocol=ssh;nobranch=1"

S = "${WORKDIR}/git/rpi"

SRCREV = "0874a1ac0d93845ec889e709f0025bbea7968b02"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} += "kernel-module-audio-rtdm-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"
