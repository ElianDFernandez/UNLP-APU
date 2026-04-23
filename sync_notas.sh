#!/bin/bash

REPO_PATH="/home/elian/Facultad/UNLP-APU"

cd "$REPO_PATH" || exit

if [[ -n $(git status -s) ]]; then
    git add .
    git commit -m "Sync automático notebook facultad: $(date +'%Y-%m-%d %H:%M:%S')"
    git push origin main
    notify-send "Repo Facultad" "Sincronización de UNLP-APU completada." -u normal
else
    notify-send "Repo Facultad" "No hay cambios nuevos en UNLP-APU." -u low
fi
#!/bin/bash

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

echo -e "\n${C_YELLOW}🔍 Verificando estado del repositorio local...${C_RESET}"

if [[ -n $(git status -s) ]]; then
    echo -e "${C_GREEN}📦 Cambios detectados. Guardando commit local...${C_RESET}"
    git add .
    git commit -q -m "Sync automático notebook facultad: $(date +'%Y-%m-%d %H:%M:%S')"
    SYNC_DONE=1
else
    echo -e "${C_BLUE}✨ El directorio de trabajo está limpio.${C_RESET}"
fi

echo -e "${C_YELLOW}☁️  Obteniendo cambios desde GitHub (Pull)...${C_RESET}"

if ! git pull -q origin main --rebase; then
    git rebase --abort
    echo -e "\n${C_RED}❌ Error de conflictos durante el pull. Requiere resolución manual.${C_RESET}"
    notify-send "Error Sync Facultad" "Conflicto al hacer pull. Debes resolverlo manualmente." -u critical
    exit 1
fi

echo -e "${C_GREEN}📥 Pull completado con éxito.${C_RESET}"

if [[ -n $(git log origin/main..main) ]]; then
    echo -e "${C_YELLOW}📤 Subiendo cambios a GitHub (Push)...${C_RESET}"
    
    if git push -q origin main; then
        echo -e "\n${C_GREEN}✅ ¡Sincronización completada exitosamente!${C_RESET}"
        notify-send "Repo Facultad" "Sincronización de UNLP-APU completada." -u normal
    else
        echo -e "\n${C_RED}❌ Error: Falló la subida a GitHub.${C_RESET}"
        notify-send "Error Sync Facultad" "Falló el push a GitHub." -u critical
    fi
elif [ $SYNC_DONE -eq 1 ]; then
    echo -e "\n${C_GREEN}✅ Cambios locales guardados. No hay nuevas actualizaciones en el remoto.${C_RESET}"
    notify-send "Repo Facultad" "Cambios locales guardados correctamente." -u normal
else
    echo -e "\n${C_BLUE}✅ Todo está al día. No se requirieron acciones.${C_RESET}"
    notify-send "Repo Facultad" "Todo está al día. No hay cambios." -u low
fi

echo -e "${C_BLUE}================================================${C_RESET}"
