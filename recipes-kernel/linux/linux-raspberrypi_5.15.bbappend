DESCRIPTION = "Append recipe to use EVL enabled RPI kernel"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "5.15.78"
SRCREV_machine = "46937443a928d407705747a54f6533b013ddbc4d"

#unset config vars since we have a custom defconfig
KCONFIG_MODE = "--allnoconfig"

SRC_URI += "\
    file://linux-${LINUX_VERSION}/0001_merged_rpi_5_15_with_evl_5_15_y.patch \
    file://linux-${LINUX_VERSION}/elk-defconfig \
"

CMDLINE:append = " isolcpus=2-3 evl.oobcpus=2-3 "

do_configure:append() {
    cp ${WORKDIR}/linux-${LINUX_VERSION}/elk-defconfig ${B}/.config
}
