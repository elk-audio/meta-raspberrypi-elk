# rpi-cmdline append
# Setup machine related cmdline settings

def get_baudrate(d):
    return d.getVar('SERIAL_CONSOLES').split(";")[0]

def get_tty(d):
    return d.getVar('SERIAL_CONSOLES').split(";")[1]

CMDLINE_SERIAL_IF_ENABLED = "console=${@get_tty(d)},${@get_baudrate(d)}"
CMDLINE_SERIAL = "${@oe.utils.conditional("ENABLE_UART", "1", "${CMDLINE_SERIAL_IF_ENABLED}", "", d)}"

CMDLINE_KGDB_IF_ENABLED = "kgdboc=${@get_tty(d)},${@get_baudrate(d)}"
CMDLINE_KGDB = "${@oe.utils.conditional("ENABLE_KGDB", "1", "${CMDLINE_KGDB_IF_ENABLED}", "", d)}"

CMDLINE:append = " quiet"
