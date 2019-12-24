# meta-raspberrypi-elk

This README decribes the dependencies of this layer and
layer's role in building  Elk Audio OS.

# Dependencies

This is an added layer on top of the [meta-raspberrypi](https://github.com/agherzan/meta-raspberrypi) maintained by Andrei Gherzan.


All the necessary layers needed by "meta-raspberrypi" are valid for this layer too.
Additionally, this layer also depends on [meta-elk](https://github.com/elk-audio/meta-elk) and [meta-swupdate](https://github.com/sbabic/meta-swupdate) for the Elk swupdate feature.

Any new recipe that is common for products built with Elk Pi as a platform should be in this layer.

Customizations done through bbappend recipes for meta-raspberrypi or OE recipes which are
common to products built with Elk Pi as a platform shall also be
in this layer.

# What meta-raspberrypi-elk consists of ?

The key contributions of this layer to Elk PI Audio OS image are:
- Custom Linux kernel with I-pipe and xenomai enabled.
- U-boot configuration and boot scripts for Elk Pi.
- Elk System configurations.
- SWUpdate configuration and swupdate client for Elk Pi.
- Other system related modifications.