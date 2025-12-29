#!/usr/bin/env python3

import os
import shutil
import time

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SOURCE_DIR = os.path.join(BASE_DIR, "src", "test")
DEST_DIR = "/home/coder/Workspace/test_saved"

# Create destination ONCE
os.makedirs(DEST_DIR, exist_ok=True)

while True:
    if os.path.isdir(SOURCE_DIR):
        try:
            shutil.copytree(
                SOURCE_DIR,
                DEST_DIR,
                dirs_exist_ok=True
            )
        except Exception as e:
            pass  # ignore transient copy errors

    time.sleep(0.5)
