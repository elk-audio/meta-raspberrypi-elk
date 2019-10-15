FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://dot.profile \
            file://dot.zshrc \
           "

do_install_append() {
    install -m 0755 ${WORKDIR}/dot.profile ${D}${sysconfdir}/skel/.profile
    install -m 0755 ${WORKDIR}/dot.zshrc ${D}${sysconfdir}/skel/.zshrc
}