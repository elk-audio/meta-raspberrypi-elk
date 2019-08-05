# AARCH 64 is only supported in xenomai-next branch.
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://gitlab.denx.de/Xenomai/xenomai.git;name=xenolib;protocol=https;branch=next"
SRCREV = "bb2f7871985905ec875bd0cb01f2392085242c58"
SRC_URI[xenolib.md5sum] = "9ae6d0b8579e45797c303220921731ea"
SRC_URI[xenolib.sha256sum] = "a6dbda5a6f04dc7705ca6a002d3e95284bad4bbb372fac61455e2ab2b20bf652"

# redifine rtdm rules as a src file
SRC_URI += "file://rtdm.rules"

S = "${WORKDIR}/git"