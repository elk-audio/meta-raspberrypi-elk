FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://dot.profile \
    file://dot.zshrc \
    file://fstab \
    file://90-i2c.rules \
"

UDEV_RULES_DIR = "/etc/udev/rules.d"
UDATA_DIR = "/udata"

do_install_append() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/dot.profile ${D}${sysconfdir}/profile.d/elk_profile.sh
    install -m 0644 ${WORKDIR}/dot.profile ${D}${sysconfdir}/skel/.profile
    install -m 0644 ${WORKDIR}/dot.zshrc ${D}${sysconfdir}/skel/.zshrc
    install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}/fstab
    install -d ${D}${UDEV_RULES_DIR}
    install -m 0644 ${WORKDIR}/90-i2c.rules ${D}${UDEV_RULES_DIR}

    # install udata directory
    install -d ${D}${UDATA_DIR}
}

FILES_PN += "${UDEV_RULES_DIR}"
FILES_PN += "${UDEV_RULES_DIR}/90-i2c.rules"
FILES_PN += "${sysconfdir}/profile.d/*"

