# 5.15 kernel append
# Use EVL enabled RPI kernel

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.6.47"
# TODO Change
#LINUX_RPI_BRANCH = "vendor/rpi/v6.6.47"
LINUX_RPI_BRANCH = "elk/rpi/v6.6.47"

# TODO
# Taken from https://github.com/agherzan/meta-raspberrypi/blob/scarthgap/recipes-kernel/linux/linux-raspberrypi_6.6.bb
# replace with: https://source.denx.de/Xenomai/xenomai4/linux-evl/-/tree/v6.6.22?ref_type=tags
#git://source.denx.de/Xenomai/xenomai4/linux-evl.git;name=machine;branch=v${LINUX_VERSION};protocol=https 
#ssh://git@bitbucket.org/mindswteam/linux-evl-fork.git;name=machine;branch=${LINUX_RPI_BRANCH} 
SRC_URI = " \
    git:///yocto-hdd/linux-evl;branch=elk/rpi/v6.6.47;name=machine \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://powersave.cfg \
    file://android-drivers.cfg \
    "

SRCREV_machine = "e404ed313d5f5cef179a419cf635c0d3749ff4e8"

#unset config vars since we have a custom defconfig
#KCONFIG_MODE = "--allnoconfig"

#SRC_URI += "\
#    file://linux-${LINUX_VERSION}/elk-defconfig \
#"

#do_configure:append() {
#    cp ${WORKDIR}/linux-${LINUX_VERSION}/elk-defconfig ${B}/.config
#}


