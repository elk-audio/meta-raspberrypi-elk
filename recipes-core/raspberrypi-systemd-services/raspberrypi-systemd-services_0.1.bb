SUMMARY = "All custom systemd services related to the machine Raspberrypi"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://load-drivers.service \
    file://rfkill-atboot.service \
    file://udata-perms.service \
"

S = "${WORKDIR}"

inherit systemd

PN = "raspberrypi-systemd-services"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/load-drivers.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/rfkill-atboot.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/udata-perms.service ${D}${systemd_system_unitdir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} += " \
    load-drivers.service \
    rfkill-atboot.service \
    udata-perms.service \
    "
SYSTEMD_AUTO_ENABLE = "enable"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += "${systemd_system_unitdir}/*"