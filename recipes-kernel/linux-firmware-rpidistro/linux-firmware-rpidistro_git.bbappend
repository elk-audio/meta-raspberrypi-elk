# linux-firmware-rpidistro append
# Set specific version for raspberrypi3

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LIC_FILES_CHKSUM_raspberrypi3 = "\
    file://LICENCE.broadcom_bcm43xx;md5=3160c14df7228891b868060e1951dfbc \
    file://WHENCE;md5=a9c2c217f513c20e1d16b384b3e2c12d \
"

SRC_URI_raspberrypi3 = " \
    git://github.com/RPi-Distro/firmware-nonfree;branch=master;protocol=https \
    file://0001-brcmfmac43455-sdio.txt-Follow-raspbian-change-for-bo.patch \
    "
SRCREV_raspberrypi3 = "b518de45ced519e8f7a499f4778100173402ae43"

do_unpack:append_raspberrypi3() {
    bb.build.exec_func('do_clean_pc', d)
}

do_clean_pc() {
    rm -rf ${S}/.pc
}
