#!/usr/bin/env bash

#WARNING: Use only Termux

DEST="/sdcard/_apks"
PROJECT_DIR="$HOME/Doom"

echo "[*] Подготовка..."
mkdir -p "$DEST"
rm -f "$DEST"/*.apk

echo "[*] Переход в проект..."
cd "$PROJECT_DIR" || exit 1

echo "[*] Сборка проекта..."

if ./gradlew assembleDebug; then
    echo "[+] Сборка успешна"

    APK_PATH="$PROJECT_DIR/app/build/outputs/apk/debug/app-debug.apk"

    if [ -f "$APK_PATH" ]; then
        echo "[*] Найден APK: $APK_PATH"

        cp "$APK_PATH" "$DEST/"
        echo "[+] APK скопирован в $DEST"
    else
        echo "[-] APK не найден: $APK_PATH"
        exit 1
    fi
else
    echo "[-] Ошибка сборки"
    exit 1
fi
