SUMMARY = "A console image with wifi support application for SoMLabs Board"

NETWORK_APP = " \
    openssh openssh-keygen openssh-sftp-server \
"

IMAGE_FEATURES += "debug-tweaks package-management"

KERNEL_EXTRA_INSTALL = " \
	kernel-devicetree \
	kernel-modules \
	firmware-imx-brcm \
 "
 
WIFI_SUPPORT = " \
    crda \
    iw \
    network-config-misc \
    iproute2 \
    iproute2-tc \
    wireless-tools \
    wpa-supplicant \
"

UTILITIES_INSTALL = " \
    gdb \
    gdbserver \
    coreutils \
    i2c-tools \
    mtd-utils \
    tslib \
    tslib-tests \
    tslib-calibrate \
    devmem2 \
    cpufrequtils \
    resize-rootfs \
    ldd \
    tzdata \
    ppp \
"

CPP_LIB = " \
    libstdc++ \
"
#Always add cmake to sdk
TOOLCHAIN_HOST_TASK_append = " nativesdk-cmake"

IMAGE_INSTALL = "${CORE_IMAGE_EXTRA_INSTALL} ${NETWORK_APP} ${UTILITIES_INSTALL} ${KERNEL_EXTRA_INSTALL} ${WIFI_SUPPORT}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
