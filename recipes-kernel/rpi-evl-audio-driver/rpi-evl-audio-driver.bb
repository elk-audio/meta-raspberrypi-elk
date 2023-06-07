SUMMARY = "Recipe for Audio EVL driver for RPI devices"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/rpi-rtdm-audio-driver;protocol=ssh;nobranch=1"
PV = "1.1.0"
SRCREV = "34da41eecee1e16211233664af3dafb6d6e575c4"

S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES:${PN} += "kernel-module-rpi-audio-evl-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-bcm2835-i2s-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm3168a-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm1863-elk-${KERNEL_VERSION}"
RPROVIDES:${PN} += "kernel-module-pcm5122-elk-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES:${PN} += "${MODULE_INSTALL_DIR}/*"

COMPATIBLE_MACHINE = "^rpi$"
