#!/bin/sh
#Nagłówki odsyłane przez serwer oraz początek strony.
cat << EOF
Content-Type: text/html; charset=UTF-8
Date: $(LANG=C date -u +"%a, %d %b %y %H:%M:%S GMT")

EOF
cat ../inc/1_header.phtml
cat ../inc/2_navbar.phtml | sed \
	-e "s%@INFO_ACTIVE@%%" \
	-e "s%@LED_ACTIVE@% class=\"active\"%"

#Obsługa żądania. Najpierw "rozpakowanie".
qled=$(echo "$QUERY_STRING" | cut -d = -f 1)
qled_action=$(echo "$QUERY_STRING" | cut -d = -f 2)
#Następnie użycie w odpowiednim podkatalogu /sys/class/leds.
if [ "$qled" ]; then
  if [ "$qled_action" = "on" ]; then
    #Włącz na stałe
    echo none > /sys/class/leds/$qled/trigger
    echo 255 > /sys/class/leds/$qled/brightness
  elif [ "$qled_action" = "off" ]; then
    #Wyłącz na stałe
    echo none > /sys/class/leds/$qled/trigger
    echo 0 > /sys/class/leds/$qled/brightness
  elif [ "$qled_action" ]; then
    #Uruchom "włącznik"
    echo $qled_action > /sys/class/leds/$qled/trigger
  fi
fi

cat << EOF
<div class="container">
  <div class="row">
    <dl>
EOF
#Wyświetlanie listy - jedna dioda w linii:
for led in /sys/class/leds/*; do
  #Stan jest raportowany jako "jasność": 0-255 w pliku brightness
  if [ $(cat $led/brightness) -eq 0 ]; then
    ON="on"
    OFF="[off]"
  else
    ON="[on]"
    OFF="off"
  fi
  STATE="<a href=\"?$(basename $led)=on\">$ON</a>|\
         <a href=\"?$(basename $led)=off\">$OFF</a>"
  
  #Lista "włączników" - z pliku trigger
  TRIGGER=$(cat $led/trigger | \
    sed -e "s/[[:alnum:]-]*/<a href=\"?$(basename $led)=\0\">\0<\/a>/g")

  #Wypisz w linii: nazwę diody, aktualny stan, listę "włączników".
  echo "<dt>$(basename $led)</dt><dd>"
  echo $STATE
  echo $TRIGGER
  echo "</dd>"
done

cat << EOF
    </dl>
  </div>
</div>
EOF

cat ../inc/3_footer.phtml

