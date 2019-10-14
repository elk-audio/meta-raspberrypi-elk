LINUX_VERSION = "4.14.78"

PV = "${LINUX_VERSION}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

#unset config vars since we have a custom defconfig
KCONFIG_MODE = "--allnoconfig"
KBUILD_DEFCONFIG_raspberrypi3-64 = ""

# rpi-4.14-78
SRCREV = "af3ff2aed7d3d8991296d882febff75418ab6f83"
SRC_URI += " \
    file://0001-Rpi-ipipe-patch-for-4.14.78.patch \
    file://0002-fix-for-RT-safe-dma.patch \
    file://defconfig \
    "

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