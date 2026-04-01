# Restore kernel-devsrc dependency removed in meta-elk d08a338.
# Ensures kernel sources are fully staged under pseudo before libevl builds.
DEPENDS += "kernel-devsrc"

# Prevent pseudo path mismatch errors caused by hardlinks between
# libevl debug sources and the shared kernel-source directory.
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
