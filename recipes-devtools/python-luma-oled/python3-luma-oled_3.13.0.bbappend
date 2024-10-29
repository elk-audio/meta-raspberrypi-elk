# python3-luma append
# Install demo opts alongside luma oled

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://demo_opts.py"

do_install:append() {
    cp ${WORKDIR}/demo_opts.py ${D}${PYTHON_SITEPACKAGES_DIR}
}
