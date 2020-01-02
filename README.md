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

---
Copyright 2017-2019 Modern Ancient Instruments Networked AB, dba Elk, Stockholm, Sweden.
