#!/bin/bash

clear
echo "Compilando archivos..."
javac -cp .:postgresql-42.7.7.jar *.java

if [ $? -ne 0 ]; then
    echo "Error al compilar. Revisa el código."
    exit 1
fi

while true; do
    echo ""
    echo "Menú General del Sistema"
    echo "1. Categorías"
    echo "2. Títulos"
    echo "3. Películas"
    echo "4. Usuarios"
    echo "5. Alquiler o Compra"
    echo "0. Salir"
    echo -n "Seleccione una opción: "
    read opcion

    case $opcion in
        1)
            java -cp .:postgresql-42.7.7.jar MainCategoria
            ;;
        2)
            java -cp .:postgresql-42.7.7.jar MainTitulo
            ;;
        3)
            java -cp .:postgresql-42.7.7.jar MainPelicula
            ;;
        4)
            java -cp .:postgresql-42.7.7.jar MainUsuario
            ;;
        5)
            java -cp .:postgresql-42.7.7.jar MainAlquilerCompra
            ;;
        0)
            echo "Saliendo del sistema. ¡Gracias!"
            exit 0
            ;;
        *)
            echo "OOpción no válida"
            ;;
    esac
done
