#!/bin/sh
#Nagłówki odsyłane przez serwer oraz początek strony.
cat << EOF
Content-Type: text/html; charset=UTF-8
Date: $(LANG=C date -u +"%a, %d %b %y %H:%M:%S GMT")

EOF
cat ../inc/1_header.phtml
cat ../inc/2_navbar.phtml | sed \
	-e "s%@INFO_ACTIVE@% class=\"active\"%" \
	-e "s%@LED_ACTIVE@%%"

cat << EOF
<div class="container">
  <div class="row">
    <h2>cpuinfo</h2>
<pre>
EOF
cat /proc/cpuinfo
cat << EOF
</pre>
  </div>
  <div class="row">
    <h2>uptime</h2>
<pre>
EOF
cat /proc/uptime
cat << EOF
</pre>
  </div>
  <div class="row">
    <h2>load</h2>
<pre>
EOF
cat /proc/loadavg
cat << EOF
</pre>
  </div>
  <div class="row">
    <h2>ps</h2>
<pre>
EOF
ps
cat << EOF
</pre>
  </div>
</div>
EOF
cat ../inc/3_footer.phtml

