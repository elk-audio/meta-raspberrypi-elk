DESCRIPTION = "Append recipe to use xenomai- enabled kernel for 64 bit version of Elk, but this is not used/supported currently"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#unset config vars since we have a custom defconfig
KCONFIG_MODE = "--allnoconfig"

SRC_URI += " \
    file://0001-Ipipe-patch-for-4.19.88.patch \
    file://0002-RT-DMA-fix.patch \
    file://0003-PCIe-irq-chip-ipipe-safe.patch \
    file://defconfig \
"

do_configure_append() {
    cp ${WORKDIR}/defconfig ${B}/.config
}

do_prepare_kernel () {
    linux_src="${S}"
    xenomai_src="${WORKDIR}/xenomai-src"
    XENOMAI_REV="0cc363fc7ac65717bb29cfc7303b3b88ffc1f559"

    rm -rf ${xenomai_src}
    git clone https://gitlab.denx.de/Xenomai/xenomai.git -b next ${xenomai_src}
    git -C ${xenomai_src} checkout ${XENOMAI_REV}

    ${xenomai_src}/scripts/prepare-kernel.sh --arch=arm64 --linux=${linux_src} --default
}

addtask prepare_kernel after do_patch before do_configure
