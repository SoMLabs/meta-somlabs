# Copyright (C) 2018 SoMLabs

DESCRIPTION = "i.MX U-Boot suppporting SoMLabs boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"
# DEPENDS_append = "dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# SRCBRANCH = "imx_v2016.03_4.1.15_2.0.0_ga_somlabs"
SRCBRANCH = "2018.09"
SRC_URI = "git://gitlab.com/somlabs/somlabs-uboot-imx.git;protocol=git;branch=${SRCBRANCH}"
#SRCREV = "27a1dbf3a5bfaa453fe0fad24497eaf75822049f"
SRCREV = "38008b2fe909be9aaf204dcac99043cfed33cad7"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7)"
