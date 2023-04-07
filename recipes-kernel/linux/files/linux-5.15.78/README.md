## Kernel config modifications
Below are the list of modifications done to the default bcm2711 defconfig

- CONFIG_EVL = y
- CONFIG_IKCONFIG = y (which also enables CONFIG_IKCONFIG_PROC)
- CONFIG_DMA_BCM2835_OOB = y (which also enables CONFIG_DMA_VIRTUAL_CHANNELS_OOB)