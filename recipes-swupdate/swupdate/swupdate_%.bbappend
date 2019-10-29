# Append recipe for swupdate, for custom changes
FILESEXTRAPATHS_prepend := "${THISDIR}/swupdate:"

SRC_URI += "file://swupdate-usb@.service \
            file://swupdate-usb.rules \
	    file://defconfig"

do_install_append() {
	rm ${D}${systemd_unitdir}/system/swupdate.service
	rm ${D}${systemd_unitdir}/system/swupdate-progress.service
}

SYSTEMD_SERVICE_${PN} = "swupdate-usb@.service"
