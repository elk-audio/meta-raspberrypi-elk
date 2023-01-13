DESCRIPTION = "Append recipe to use xenomai-enabled kernel for 64 \
               bit version of Elk, but this is not used/supported currently"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LINUX_VERSION = "5.4.83"
SRCREV_machine = "ec0dcf3064b8ba99f226438214407fcea9870f76"

#unset config vars since we have a custom defconfig
KCONFIG_MODE = "--allnoconfig"

SRC_URI += " \
    file://0001-ipipe-5.4.83.patch \
    file://0002-RT-DMA-patch-for-spi-and-i2s-drivers.patch \
    file://0005-Patch-for-rt-safe-spi_bcm2835.patch \
    file://elk-defconfig \
    "

CMDLINE:append = " xenomai.allowed_group=2004 "

do_configure:append() {
    cp ${WORKDIR}/elk-defconfig ${B}/.config
}

do_prepare_kernel () {
    linux_src="${S}"
    xenomai_src="${WORKDIR}/xenomai-src"

    rm -rf ${xenomai_src}
    git clone https://source.denx.de/Xenomai/xenomai.git -b v3.2.2 ${xenomai_src}

    ${xenomai_src}/scripts/prepare-kernel.sh --arch=arm64 --linux=${linux_src} --default
}

addtask do_prepare_kernel after do_patch before do_configure
