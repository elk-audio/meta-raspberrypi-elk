DESCRIPTION = "Recipe for installing Swupdate-client which starts the swupdate"
SECTION = "misc"
LICENSE = "CLOSED"

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
