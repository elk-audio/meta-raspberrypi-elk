# disable vc4-kms-v3d since we only use framebuffer
VC4GRAPHICS = "0"

do_deploy_append() {
    # disable BT for Pi3/Pi0W if any
    if [ "${DISABLE_BT}" = "1" ]; then
        echo "# Disable Bluetooth" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=pi3-disable-bt" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi
    echo "dtparam=i2s=on" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    echo "enable_uart=1" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    echo "dtparam=i2c_arm=on" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    echo "dtparam=i2c_vc=on" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
