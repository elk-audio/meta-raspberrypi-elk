SUMMARY = "Recipe for SPI RTDM driver for bcm2836 SOCs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit module

SRC_URI = "git://github.com/shdrmr/spi-bcm283x-rtdm.git;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/"

SRCREV = "2435c3e9d20a857b87cfd60b9d02966562194caa"
SRCBRANCH = "master"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} = "kernel-module-spi-bcm283x-rtdm-${KERNEL_VERSION}"

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"