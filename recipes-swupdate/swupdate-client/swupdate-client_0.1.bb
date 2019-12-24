DESCRIPTION = "Recipe for installing Swupdate-client which starts the swupdate"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
    file://get-latest-swu \
    file://elk_system_utils \
    "

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/get-latest-swu ${D}${bindir}
    install -m 0755 ${WORKDIR}/elk_system_utils ${D}${bindir}
}

FILES_${PN} = "${bindir}/*"
FILES_${PN} += "${sysconfdir}/*"

INSANE_SKIP_${PN} = "file-rdeps"