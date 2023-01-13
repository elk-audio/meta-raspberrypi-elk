SUMMARY = "Kernel recipe 5.4 taken from meta-raspberrypi hardknott"
DESCRIPTION = "Recipe from linux-raspberrypi_5.4.bb along with Elk modifications"

LINUX_VERSION ?= "5.4.83"
LINUX_RPI_BRANCH ?= "rpi-5.4.y"
LINUX_RPI_KMETA_BRANCH ?= "yocto-5.4"

SRCREV_machine = "08ae2dd9e7dc89c20bff823a3ef045de09bfd090"
SRCREV_meta = "d676bf5ff7b7071e14f44498d2482c0a596f14cd"

KMETA = "kernel-meta"

SRC_URI = " \
    git://github.com/raspberrypi/linux.git;name=machine;branch=${LINUX_RPI_BRANCH};protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://0001-Revert-selftests-bpf-Skip-perf-hw-events-test-if-the.patch \
    file://0002-Revert-selftests-bpf-Fix-perf_buffer-test-on-systems.patch \
    file://powersave.cfg \
    file://android-drivers.cfg \
    "

require linux-raspberrypi-elk.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_DTC_FLAGS += "-@ -H epapr"
