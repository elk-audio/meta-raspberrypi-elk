SUMMARY = "Recipe for shiftregister rtdm driver for bcm2836 SOCs"
HOMEPAGE = "https://github.com/elk-audio/rpi-shiftreg-rtdm-driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://${WORKDIR}/git/COPYING;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2 \
    "

SRC_URI = "gitsm://github.com/elk-audio/rpi-shiftreg-rtdm-driver.git;protocol=https;nobranch=1"
SRCREV = "cb546b38a2a5ba6403b00fa45641f92f93c78d47"

S = "${WORKDIR}/git/boards/elk_pi/"

inherit module

MODULE_INSTALL_DIR = "/lib/modules/${KERNEL_VERSION}"

do_install() {
    #install the kernel module to standard location on rootfs
    install -d ${D}${MODULE_INSTALL_DIR}
    install -m 0644 ${S}/*.ko ${D}${MODULE_INSTALL_DIR}
}

FILES_${PN} += "${MODULE_INSTALL_DIR}/*"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
RPROVIDES_${PN} = "kernel-module-shiftreg-rtdm-${KERNEL_VERSION}"