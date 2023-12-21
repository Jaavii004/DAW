$extension = Read-Host "Dime la extension? "

foreach ($letra in 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z') {
    $archivos = Get-ChildItem  -Path "$($letra):\" -Filter *.$($extension) -Recurse
    foreach ($archivo in $archivos) {
        $($archivo.FullName) | Out-File -Append -FilePath $env:USERPROFILE\Desktop\listado.txt 
    }
}