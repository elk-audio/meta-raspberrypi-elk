#!/bin/sh

do_preinst()
{
    rootfs=`mount | grep "on / type" | cut -d':' -f 2 | cut -d' ' -f 1`

    if [ $rootfs == '/dev/mmcblk0p2' ];then
	clean_disk = "/dev/mmcblk0p3 -y"
    else
	clean_disk = "/dev/mmcblk0p2 -y"
    fi
    fsck /dev/mmcblk0p1 -y
    fsck ${clean_disk}
    #tc qdisc add dev wlan0 root tbf rate 1mbit burst 32kbit latency 50ms
    mount /dev/mmcblk0p1 /boot
    exit 0
}

do_postinst()
{
    echo "do_postinst"
    #tc qdisc del root dev wlan0
    exit 0
}

case "$1" in

preinst)
    echo "call do_preinst"
    do_preinst
    ;;

postinst)
    echo "call do_postinst"
    do_postinst
    ;;    

*)
    echo "default"
    exit 1
    ;;

esac
