SUMMARY = "This is the Xenomai enabled kernel running in the Elk Audio OS"
DESCRIPTION = "This recipe is taken from https://github.com/s-vincent/meta-raspberrypi-rt-sv.git"
HOMEPAGE = "https://github.com/elk-audio/meta-raspberrypi-elk"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LINUX_VERSION = "4.14.85"

SRCREV = "802d8776632344a4354d8ef5f142611a4c878570"

SRC_URI = "\
    git://github.com/raspberrypi/linux.git;branch=rpi-4.14.y \
    http://xenomai.org/downloads/xenomai/stable/xenomai-3.0.8.tar.bz2;name=xeno \
    file://pre-ipipe-core-4.14.85-arm-6.patch \
    file://ipipe-core-4.14.85-arm-6.patch \
    file://post-ipipe-core-4.14.85-arm-6.patch \
    file://0002-fix-for-RT-safe-dma.patch \
    file://0003-disable-hdmi-audio.patch \
    file://0004-fix-for-lan7xx.patch \
    file://0001-Made-clk-bcm2835-aux-irqchip-ipipe-aware.patch \
    file://fragment.cfg \
    file://defconfig \
"

ARM_KEEP_OABI = "0"

require recipes-kernel/linux/linux-raspberrypi.inc

PV = "${LINUX_VERSION}"

# Fixes QA Error
FILES_kernel-base += "/lib/firmware"

SRC_URI[xeno.md5sum] = "eafe3b789651f0db9575599dffc60a19"
SRC_URI[xeno.sha256sum] = "c373261ddb8280d9d7078cdd9cd9646dfb7d70d8cd3aa9693d9148f03990d711"

do_prepare_kernel() {
    linux_src="${S}"
    xenomai_src="${WORKDIR}/xenomai-3.0.8/"
    ${xenomai_src}/scripts/prepare-kernel.sh --arch=arm --linux=${linux_src} --default
}

addtask prepare_kernel after do_patch before do_configure