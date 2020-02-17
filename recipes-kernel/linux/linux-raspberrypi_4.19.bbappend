DESCRIPTION = "Append recipe to use xenomai- enabled kernel for 64 bit version of Elk, but this is not used/supported currently"
LINUX_VERSION = "4.19.57"
PV = "${LINUX_VERSION}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

#unset config vars since we have a custom defconfig
KCONFIG_MODE = "--allnoconfig"

SRCREV = "6e787b87ace9f945f17a9022288e2758ed281cf7"

SRC_URI += " \
    file://0001-Ipipe-patch-for-4.19.55.patch \
    file://0002-RT-DMA-fix.patch \
    file://0003-PCIe-irq-chip-ipipe-safe.patch \
    file://defconfig \
"

do_configure_append() {
    cp ${WORKDIR}/defconfig ${B}/.config
}

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
