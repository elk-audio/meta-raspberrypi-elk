SUMMARY = "Recipe for shiftregister rtdm driver for bcm2836 SOCs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit module

SRC_URI = "git://git@bitbucket.org/mindswteam/rpi_shiftreg_rtdm_driver.git;protocol=ssh;nobranch=1"

S = "${WORKDIR}/git/rpi/sika/"

SRCREV = "5950236b650eebb0996189c58d7f1e481a70397d"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} = "kernel-module-shiftreg-rtdm-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"
