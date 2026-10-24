#!/usr/bin/env python3
"""Check Simplified Chinese localization keys and formatting before an Android build."""
from collections import Counter
from pathlib import Path
import re
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[2]
STRINGS = ROOT / "core/src/commonMain/kotlin/ua/syt0r/kanji/presentation/common/resources/string"
RES = ROOT / "core/src/commonMain/composeResources"
ANDROID_RES = ROOT / "app/src/main/res"
errors = []

def check(condition, message):
    if not condition:
        errors.append(message)

def override_keys(path):
    text = path.read_text(encoding="utf-8")
    return set(re.findall(r"^\s*override\s+(?:val|fun)\s+(\w+)", text, re.MULTILINE))

japanese = override_keys(STRINGS / "JapaneseStrings.kt")
chinese = override_keys(STRINGS / "ChineseStrings.kt")
english = override_keys(STRINGS / "EnglishStrings.kt")
check(japanese <= chinese, "Missing Kotlin override keys: " + ", ".join(sorted(japanese - chinese)))
check(chinese <= (japanese | english), "Unexpected Kotlin override keys: " + ", ".join(sorted(chinese - japanese - english)))

cn_kotlin = (STRINGS / "ChineseStrings.kt").read_text(encoding="utf-8")
check('override val appName: String = "日语道场"' in cn_kotlin, "Kotlin app title is inconsistent")

def get_entries(path):
    root = ET.parse(path).getroot()
    result = {}
    for elem in root:
        if elem.tag not in {"string", "plurals", "string-array"}:
            continue
        name = elem.attrib["name"]
        check(name not in result, "Duplicate resource: " + name)
        values = ["".join(elem.itertext())] if elem.tag == "string" else ["".join(ch.itertext()) for ch in elem]
        result[name] = (elem.tag, values)
    return result

def placeholders(text):
    return Counter(re.findall(r"%(?:\d+\$)?[sdf]", text))

original = get_entries(RES / "values/strings.xml")
localized = get_entries(RES / "values-zh/strings.xml")
check(set(localized) <= set(original), "Unexpected Compose locale keys: " + ", ".join(sorted(set(localized) - set(original))))
for name, (tag, translations) in localized.items():
    if name not in original:
        continue
    orig_tag, originals = original[name]
    check(orig_tag == tag, f"Resource type mismatch: {name}")
    if tag in {"plurals", "string-array"}:
        check(len(originals) == len(translations), f"Variant count mismatch: {name}")
    for i, translated in enumerate(translations):
        if i < len(originals):
            check(placeholders(originals[i]) == placeholders(translated), f"Format placeholders mismatch: {name}[{i}]")

launcher = get_entries(ANDROID_RES / "values-zh/strings.xml")
check(launcher.get("app_name") == ("string", ["日语道场"]), "Android launcher title is inconsistent")

if errors:
    for err in errors:
        print("ERROR:", err)
    raise SystemExit(1)
print(f"Chinese locale checks passed: {len(chinese)} Kotlin overrides, {len(localized)} Compose resources.")
