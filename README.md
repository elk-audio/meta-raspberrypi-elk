# meta-raspberrypi-elk

This is an added layer on top of the [meta-raspberrypi](https://github.com/agherzan/meta-raspberrypi) layer maintained by Andrei Gherzan.

# Dependencies

All the necessary layers needed by `meta-raspberrypi` are also required by this layer.
Additionally, this layer also depends on [meta-elk](https://github.com/elk-audio/meta-elk) and [meta-swupdate](https://github.com/sbabic/meta-swupdate) for the Elk swupdate feature.

Any new recipe that is common for products built with Elk Pi as a platform should be in this layer.

Customizations done through bbappend recipes for meta-raspberrypi or OE recipes which are
common to products built with Elk Pi as a platform shall also be in this layer.

# Main components

The key contributions of this layer to Elk PI Audio OS image are:

  * Custom Linux kernel with I-Pipe and Xenomai enabled.
  * U-boot configuration and boot scripts for Elk Pi.
  * Elk System configurations.
  * SWUpdate configuration and swupdate client for Elk Pi.
  * Other system-related modifications.

# Important notes
Starting from ELK Audio OS 1.0 release we have moved from Xenomai 3 to Xenomai 4.

As part of this migration only the audio driver has been updated, so the following drivers are now deprecated:

  * `rpi-rtdm-audio-driver` (it is replaced by `rpi-evl-audio-driver`)
  * `rpi-shiftreg-rtdm-driver`
  * `spi-rtdm-audio-driver`

As a consequence:

  * `elk-pi` and `elkpi-stereo` hats are not supported
  * `sensei` application will not work

---
Copyright 2017-2023 ELK Audio AB, Stockholm, Sweden.
