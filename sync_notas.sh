#!/bin/bash

# --- Configuración de Colores y Estética ---
C_BLUE='\033[1;34m'
C_GREEN='\033[1;32m'
C_YELLOW='\033[1;33m'
C_RED='\033[1;31m'
C_RESET='\033[0m'

echo -e "${C_BLUE}================================================${C_RESET}"
echo -e "${C_BLUE}🚀 Iniciando sincronización de UNLP-APU...${C_RESET}"
echo -e "${C_BLUE}================================================${C_RESET}"

REPO_PATH="/home/elian/Facultad/UNLP-APU"

cd "$REPO_PATH" || {
    echo -e "\n${C_RED}❌ Error: No se pudo acceder a $REPO_PATH${C_RESET}"
    exit 1
}

SYNC_DONE=0

echo -e "\n${C_YELLOW}🔍 Verificando estado local...${C_RESET}"

if [[ -n $(git status -s) ]]; then
    echo -e "${C_GREEN}📦 Cambios detectados. Guardando commit...${C_RESET}"
    git add .
    git commit -q -m "Sync automático notebook facultad: $(date +'%Y-%m-%d %H:%M:%S')"
    SYNC_DONE=1
else
    echo -e "${C_BLUE}✨ El directorio está limpio.${C_RESET}"
fi

echo -e "${C_YELLOW}☁️  Sincronizando con GitHub (Pull)...${C_RESET}"

if ! git pull -q origin main --rebase; then
    git rebase --abort
    echo -e "\n${C_RED}❌ Error de conflictos. Resolvé manualmente.${C_RESET}"
else
    echo -e "${C_GREEN}📥 Pull completado.${C_RESET}"

    if [[ -n $(git log origin/main..main) ]]; then
        echo -e "${C_YELLOW}📤 Subiendo cambios (Push)...${C_RESET}"
        if git push -q origin main; then
            echo -e "\n${C_GREEN}✅ ¡Todo sincronizado exitosamente!${C_RESET}"
        else
            echo -e "\n${C_RED}❌ Error en el Push.${C_RESET}"
        fi
    elif [ $SYNC_DONE -eq 1 ]; then
        echo -e "\n${C_GREEN}✅ Cambios guardados localmente.${C_RESET}"
    else
        echo -e "\n${C_BLUE}✅ Todo al día.${C_RESET}"
    fi
fi

# --- Pausa final estética para lectura ---
echo -e "\n${C_BLUE}================================================${C_RESET}"
echo -e "${C_YELLOW}🏁 Proceso finalizado.${C_RESET}"
echo -e "${C_YELLOW}⌨️  Presioná la tecla ESC para salir...${C_RESET}"
echo -e "${C_BLUE}================================================${C_RESET}"

# Bucle para detectar específicamente la tecla ESC (código ASCII 27)
while true; do
    read -rsn1 key
    if [[ $key == $'\e' ]]; then
        break
    fi
done

exit 0
