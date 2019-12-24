# armv7l specific installation for mda vst3.

RPI_MDA_VST3_FOLDER = "armv7l-linux"

do_install() {
    install -d ${D}${MDA_PLUGIN_DIR}/mda.vst3/Contents/${RPI_MDA_VST3_FOLDER}
    cp "${WORKDIR}/build/VST3/Release/mda.vst3/Contents/x86_64-linux/mda.so" "${D}${MDA_PLUGIN_DIR}/mda.vst3/Contents/${RPI_MDA_VST3_FOLDER}/"
}