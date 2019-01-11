# M.Wolowik
# Copyright (C) 2018 SoMLabs

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DESCRIPTION = "i.MX U-Boot suppporting SoMLabs boards."
require recipes-bsp/u-boot/u-boot.inc

PV = "2018.09"
PR = "r0"

PROVIDES += "u-boot"

UBOOT_LOCALVERSION = "-somlabs"

SRCREV = "a046f68800bcd70699eccc185ebe4b3d43d42ff7"
SRC_URI = "git://github.com/SoMLabs/somlabs-uboot-imx.git;branch=${PV};protocol=git"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7)"
