#!/bin/bash
set -Eeuo pipefail

rm script.pdf || true
pandoc SCRIPT.md -f markdown -t html -o script.pdf
