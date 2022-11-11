## Changes to u-boot 2022_10 defualt rpi defconfig

1. CONFIG_BOOTDELAY set to 0 seconds in order to speed up boot
2. CONFIG_USE_PREBOOT was switched off since the default pre boot command is not whats needed.
