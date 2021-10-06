DESCRIPTION = "Recipe for installing Swupdate-client which starts the swupdate"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "swupdate"

FILESEXTRAPATHS_prepend := "${THISDIR}/swupdate-rpi-client:"

SRC_URI = "file://get-latest-swu"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 0755 ${WORKDIR}/get-latest-swu ${D}${bindir}
}

FILES_${PN} = "${bindir}/*"
FILES_${PN} += "${sysconfdir}/*"

INSANE_SKIP_${PN} = "file-rdeps"
