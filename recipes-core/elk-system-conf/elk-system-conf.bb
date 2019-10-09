DESCRIPTION = "Recipe for installing system wide Upcore specific conf files"
SECTION = "misc"
LICENSE = "CLOSED"

SRC_URI = "file://blacklist.conf"

MODPROBE_CONF_DIR = "/etc/modprobe.d/"

do_install() {

  install -d ${D}${MODPROBE_CONF_DIR}
  install -m 0644 ${WORKDIR}/blacklist.conf ${D}${MODPROBE_CONF_DIR}
}

FILES_${PN} = "${MODPROBE_CONF_DIR}*"
