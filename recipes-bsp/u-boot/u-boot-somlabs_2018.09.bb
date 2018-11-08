# M.Wolowik
# Copyright (C) 2018 SoMLabs

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[md5sum] = "e3b8544439cf403ea2df6af53da70438"
SRC_URI[sha256sum] = "aadde146470ce7f1b350906f3eac98ed92c20364ef38068a00d7b7ccc7034921"

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
