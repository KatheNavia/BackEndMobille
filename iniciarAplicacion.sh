cd /var/www/html/
echo "deteniendo servicios"
sudo pkill -f 'gradle'
echo "iniciando aplicacion"
sudo ./gradlew bootRun > /dev/null 2>&1 &