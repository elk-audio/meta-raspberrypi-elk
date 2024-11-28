# 6.6 kernel append
# Use EVL enabled RPI kernel

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LINUX_VERSION = "6.6.47"
LINUX_RPI_BRANCH = "vendor/rpi/v6.6.47"

SRC_URI = " \
    git://source.denx.de/Xenomai/xenomai4/linux-evl.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://linux-${LINUX_VERSION}/evl.cfg \
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl-debug', 'file://linux-${LINUX_VERSION}/evl-debug.cfg', '', d)} \
"

SRCREV_machine = "e404ed313d5f5cef179a419cf635c0d3749ff4e8"
