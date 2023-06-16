# rpi-config append
# Setup some machine related configuration in /boot/config.txt:
# - UART baud rate
# - Minimum and maximum CPU frequency
# - Enable I2S
# - Disable vc4-fkms-v3d
# - force_eeprom_read=0

def get_baudrate(d):
    return d.getVar('SERIAL_CONSOLES').split(";")[0]

do_deploy:append() {
    sed -i '/init_uart_baud=/c\init_uart_baud=${@get_baudrate(d)}' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    sed -i '/arm_freq=/c\arm_freq=1200' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    sed -i '/arm_freq_min=/c\arm_freq_min=800' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    sed -i '/dtparam=i2s=/c\dtparam=i2s=on' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    sed -i '/dtparam=vc4-fkms-v3d=/c\#dtoverlay=vc4-fkms-v3d' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "force_eeprom_read=0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
