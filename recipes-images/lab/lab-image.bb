DESCRIPTION = "A full featured image for SomLabs Board"

IMAGE_FEATURES += "ssh-server-openssh package-management "

# Base this image on core-image-minimal
require recipes-core/images/core-image-minimal.bb

#Time Zones
IMAGE_INSTALL += "tzdata"

#Kernel Device-Tree, modules and additional firmware
IMAGE_INSTALL += "\
	kernel-devicetree \
	kernel-modules \
	firmware-imx-brcm \
"

#Rootfs resizer - resize last partition to fill whole card.
IMAGE_INSTALL += "resize-rootfs"

#Sftp server is essential for debugging.
IMAGE_INSTALL += "\
    openssh-sftp-server \
"

#Misc tools
IMAGE_INSTALL += "\
    i2c-tools \
    devmem2 \
    cpufrequtils \
"

#Webdemo
IMAGE_INSTALL += "\
    avahi-daemon \
    webdemo \
    busybox-httpd \
"

#Always add cmake to sdk
TOOLCHAIN_HOST_TASK_append = " nativesdk-cmake"

IMAGE_INSTALL += " \
	bluez5 \
	wpa-supplicant \
	wpa-supplicant-passphrase \
	wpa-supplicant-cli \
	network-config-misc \
	crda \
	iproute2 \
	iproute2-tc \
	iw \
"

