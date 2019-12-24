FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://dot.profile \
            file://dot.zshrc \
            file://fstab \
            file://90-i2c.rules \
           "

UDEV_RULES_DIR = "/etc/udev/rules.d"

do_install_append() {
    install -m 0644 ${WORKDIR}/dot.profile ${D}${sysconfdir}/skel/.profile
    install -m 0644 ${WORKDIR}/dot.zshrc ${D}${sysconfdir}/skel/.zshrc
    install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}/fstab
    install -d ${D}${UDEV_RULES_DIR}
    install -m 0644 ${WORKDIR}/90-i2c.rules ${D}${UDEV_RULES_DIR}
}

FILES_PN += "${UDEV_RULES_DIR}"
FILES_PN += "${UDEV_RULES_DIR}/90-i2c.rules"