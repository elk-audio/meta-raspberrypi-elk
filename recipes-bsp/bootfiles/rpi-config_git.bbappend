do_deploy:append() {
    # disable BT for Pi3/Pi0W if any
    if [ "${DISABLE_BT}" = "1" ]; then
        echo "# Disable Bluetooth" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
        echo "dtoverlay=pi3-disable-bt" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    fi
    echo "dtparam=i2s=on" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "enable_uart=1" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "dtparam=i2c_arm=on" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "dtparam=i2c_vc=on" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "force_eeprom_read=0" >>${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}

