SUMMARY = "Recipe for installing system-wide configuration files"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
SECTION = "misc"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://blacklist.conf \
"
MODPROBE_CONF_DIR = "/etc/modprobe.d/"

do_install() {
    install -d ${D}${MODPROBE_CONF_DIR}
    install -m 0644 ${WORKDIR}/blacklist.conf ${D}${MODPROBE_CONF_DIR}
}

FILES_${PN} = "${MODPROBE_CONF_DIR}*"
