DESCRIPTION = "All custom systemd services for the RaspberryPi"
LICENSE = "CLOSED"
PR = "r0"
PN = "raspberrypi-systemd-services"
PV = "0.1"
S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit systemd

FILES_${PN} += "${systemd_system_unitdir}/*"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

SRC_URI = "file://load-drivers.service"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/load-drivers.service ${D}${systemd_system_unitdir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} += "load-drivers.service"
SYSTEMD_AUTO_ENABLE = "enable"
