#!/bin/bash

id=$(id -u)

if [ "$id" -ne 0 ]; then
    PASSWORD=$(zenity --password --title="Contraseña ROOT: " --timeout=20)
    if [ $? -eq 1 ]; then
        zenity --info --text "Operación cancelada." --timeout=20
        exit 1
    fi

    echo "$PASSWORD" | sudo -S "$0"
    exit $?
fi

PATH_TO_POLKIT="/var/lib/polkit-1/localauthority/90-mandatory.d"
PATH_TO_RSRC="/usr/share/senia-virtual-tic/rsrc/" 

clean_firefox(){
	zenity --info --text "Su firefox se cerrará"
	killall firefox || true
	rm -rf $HOME/.mozilla
	
}

fix_usb(){
    cp ${PATH_TO_RSRC}/senia-polkit.pkla  ${PATH_TO_POLKIT}/
    zenity --info --text "Es necesario reniciar el equipo"
    reboot
}

shut-down(){
    zenity --info --text "El equipo se apagará"
    shutdown -h now
}

display-rare(){
    xfce4-display-settings
    zenity --info --text "Gracias por utilizar el TIC Virtual"
}

#firefox "https://forms.office.com/pages/designpagev2.aspx?lang=es-ES&origin=OfficeDotCom&route=Start&subpage=design&id=FBHdc33vx0CGaVadMufimztbgGDMSPRPs_ZodsS_8A9UMFBSTExLVjFTQTZCTjQ1NkdXWE1CNzdVQi4u"

ans=$(zenity  --title "Virtual TIC" --width 800 --height 600 --list  --text "Parece que está teniendo problemas, en que le puedo ayudar?" --radiolist  --column "Elija una" --column "Acción" TRUE "Apaga el Equipo" FALSE "Las pantallas se ven raro" FALSE "Limpia el Firefox" FALSE "Los USBs me piden contrasenya")
echo $ans
case "$ans" in        
    "Las pantallas se ven raro")
        display-rare
    ;;
    "Limpia el Firefox")
        clean_firefox
    ;;
    "Los USBs me piden contrasenya")
        fix_usb
    ;;
	"Apaga el Equipo")
        shut-down
    ;;	  
	*)
	    echo "Desconocido"
	;;
esac
zenity --info --text=" Gracias por utilizar el TIC Virtual"

exit 0
