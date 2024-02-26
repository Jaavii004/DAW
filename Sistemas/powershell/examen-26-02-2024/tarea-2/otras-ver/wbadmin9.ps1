# COPIA LOCAL
wbadmin start backup -backupTarget:F: -include:X:\DAW1 -quiet

# COPIA REMOTA
wbadmin start backup -backupTarget:\\192.168.5.117\compartir -include:X:\DAW1 -user:prova -password:1234QWERasdf -quiet

# RECOVER (Coger fecha y hora del indentificador, no de la hora que tienes)
wbadmin start recovery -version:02/19/2024-15:40 -backupTarget:\\WSERVER-PROFE\compartir -machine:Jorge -items:X: -itemtype:Volume -quiet

# RECOVER SOLO FICHEROS
wbadmin start recovery -version:02/19/2024-15:40 -backupTarget:\\WSERVER-PROFE\compartir -machine:Jorge -items:X:\DAW1 -itemtype:File -quiet

# SCHEDULE (Server profe)
wbadmin enable backup -addtarget:\\WSERVER-PROFE\compartir -include:X: -schedule:22:00,14:00 -user:prova -password:1234QWERasdf

# SCHEDULE (Local)
wbadmin enable backup -addtarget:F: -include:X: -schedule:22:00,14:00