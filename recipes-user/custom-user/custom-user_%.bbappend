DESCRIPTION = "Adds mind also to kmem group, required for user space access to shared memory"

FILESEXTRAPATHS:append := "${THISDIR}/files/:"

SRC_URI += "\
    file://status-check-drivers.sh \
"

#override base recipe's USERADD_PARAM:${PN}
USERADD_PARAM:${PN} = "-g xenomai -G audio,kmem,sudo -p '${MIND_PASSWD}' -m -d ${HOME_DIR} -s /bin/bash mind"

do_install:append () {
    install -m 0755 ${WORKDIR}/status-check-drivers.sh ${D}${sysconfdir}/profile.d/.
}

