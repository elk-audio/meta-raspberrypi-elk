SUMMARY = "This recipe is taken from https://github.com/s-vincent/meta-raspberrypi-rt-sv.git"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.55"

SRCREV = "78878cd46bcf68d8ae94e02c4e1cbba6841314bb"

SRC_URI = "git://github.com/raspberrypi/linux.git;branch=rpi-4.19.y"

ARM_KEEP_OABI = "0"

require recipes-kernel/linux/linux-raspberrypi.inc

PV = "${LINUX_VERSION}"

# Fixes QA Error
FILES_kernel-base += "/lib/firmware"

CMDLINE_prepend = 'dwc_otg.fiq_enable=0 dwc_otg.fiq_fsm_enable=0 dwc_otg.nak_holdoff=0 '

CMDLINE_append = ' xenomai.allowed_group=2004 xenomai.sysheap_size=256 xenomai.state=enabled xenomai.smi=detect xenomai.smi_mask=1' 

do_prepare_kernel () {
    linux_src="${S}"
    xenomai_src="${WORKDIR}/xenomai-next"
    XENOMAI_REV="bb2f7871985905ec875bd0cb01f2392085242c58"

    rm -rf ${xenomai_src}
    git clone https://gitlab.denx.de/Xenomai/xenomai.git -b next ${xenomai_src}
    git -C ${xenomai_src} checkout ${XENOMAI_REV}

    ${xenomai_src}/scripts/prepare-kernel.sh --arch=arm64 --linux=${linux_src} --default
}

addtask prepare_kernel after do_patch before do_configure