FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

SRC_URI += "\
	file://0001-kernel-logo-change.patch \
	file://somlabs-visionsom-6ul.dts \
	file://somlabs-visionsom-6ul-emmc.dts \
	file://somlabs-visionsom-6ul-nand.dts \
	file://somlabs-visionsom-6ull.dts \
	file://somlabs-visionsom-6ull-emmc.dts \
	file://somlabs-visionsom-6ull-nand.dts \
"

do_compile_prepend () {
	cp ${WORKDIR}/*.dts ${S}/arch/${ARCH}/boot/dts
}
