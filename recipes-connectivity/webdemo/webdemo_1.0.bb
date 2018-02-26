#
# This file adds simple webpanel demo recipe.
#

SUMMARY = "Simple webpanel demo application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r1"

SRC_URI = "\
	file://www/cgi-bin/info.sh \
	file://www/cgi-bin/leds.sh \
	file://www/fonts/glyphicons-halflings-regular.ttf \
	file://www/fonts/glyphicons-halflings-regular.woff \
	file://www/fonts/glyphicons-halflings-regular.svg \
	file://www/fonts/glyphicons-halflings-regular.eot \
	file://www/img/favicon.ico \
	file://www/js/bootstrap.min.js \
	file://www/js/jquery-1.10.2.min.js \
	file://www/inc/3_footer.phtml \
	file://www/inc/2_navbar.phtml \
	file://www/inc/1_header.phtml \
	file://www/index.html \
	file://www/css/bootstrap.min.css \
	file://www/css/bootstrap-theme.min.css \
	file://www/css/panel.css \
"

S = "${WORKDIR}"

do_compile() {
	:
}

do_install() {
	install -d ${D}/srv/www/cgi-bin
	install -m 755 www/cgi-bin/* ${D}/srv/www/cgi-bin/

	install -d ${D}/srv/www/fonts
	install -m 644 www/fonts/* ${D}/srv/www/fonts/

	install -d ${D}/srv/www/img
	install -m 644 www/img/* ${D}/srv/www/img/

	install -d ${D}/srv/www/js
	install -m 644 www/js/* ${D}/srv/www/js/

	install -d ${D}/srv/www/inc
	install -m 644 www/inc/* ${D}/srv/www/inc/

	install -d ${D}/srv/www/css
	install -m 644 www/css/* ${D}/srv/www/css/

	install -m 644 www/index.html ${D}/srv/www/index.html
}

FILES_${PN} += "/srv/www/*"
RDEPENDS_${PN} += "busybox-httpd"
