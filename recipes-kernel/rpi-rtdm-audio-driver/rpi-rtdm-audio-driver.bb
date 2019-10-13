UMMARY = "Recipe for RPI rtdm audio driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4a0f8ad6a793571b331b0e19e3dd925c"

inherit module

SRC_URI = "git://git@bitbucket.org/mindswteam/rpi-rtdm-audio-driver.git;protocol=ssh;nobranch=1"

S = "${WORKDIR}/git"

SRCREV = "c8e4203bb5315ffd7e2a0cae181ca98f407fba19"

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
