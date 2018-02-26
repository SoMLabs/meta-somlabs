# Copyright (C) 2018 SoMLABS

DESCRIPTION = "i.MX U-Boot suppporting SomLABS boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"
DEPENDS_append = "dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2016.03_4.1.15_2.0.0_ga_somlabs"
SRC_URI = "git://gitlab.com/somlabs/somlabs-uboot-imx.git;protocol=https;branch=${SRCBRANCH}"
SRCREV = "27a1dbf3a5bfaa453fe0fad24497eaf75822049f"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7)"
