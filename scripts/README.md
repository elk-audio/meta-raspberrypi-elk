# Generating the update file
To generate a SWUpdate file (.swu) you can use the generate-swu script.
Its just a script which takes list of files that need to be in the update and archives it into a CPIO archive

# Usage example:
./generate-swu sw-description <rootfs.ext.gz (from tmp/deploy/images)> uImage0 uImage1 <boot-mount-script.sh>