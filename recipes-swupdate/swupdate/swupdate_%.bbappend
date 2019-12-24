# Append recipe for swupdate, for custom changes for Elk Pi
FILESEXTRAPATHS_prepend := "${THISDIR}/swupdate:"

SRC_URI += "\
            file://swupdate-usb@.service \
            file://swupdate-usb.rules \
            file://defconfig \
            file://background.jpg \
            file://logo.png \
            file://index.html \
            file://swupdate.service \
            file://swupdate-ota \
            "

do_install_append() {
    install -m 0655 ${WORKDIR}/swupdate-ota ${D}${bindir}
    cp ${WORKDIR}/index.html ${D}/www/
    cp ${WORKDIR}/logo.png ${D}/www/images/
    cp ${WORKDIR}/background.jpg ${D}/www/images/
}