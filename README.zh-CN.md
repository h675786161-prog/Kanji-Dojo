# 日语道场 · 简体中文测试版

本项目是 [Kanji Dojo](https://github.com/syt0r/Kanji-Dojo) 的个人汉化分支，保留原项目许可、作者署名和历史。**并非原作者发布的官方中文版。**

## 修改声明与许可

- 原项目：Kanji Dojo，作者 Yaroslav Shuliak。
- 修改内容：2026-10-24 增加简体中文界面、中文名称、构建脚本与本地化校验。
- 本项目继续遵守 GPL-3.0-or-later，不是官方发行版本。
- 原作者署名、许可证、第三方数据来源与授权要求详见 [NOTICE.zh-CN.md](NOTICE.zh-CN.md)、[LICENSE](LICENSE) 和 [README.md](README.md)。
- **每个 APK 构建产物内的 SOURCE_AND_LICENSE.txt 对应且仅对应该版本源码**，不能随意使用更新后的分支来替代。

## 使用与安装

1. 打开 [Chinese Android APK 构建记录](https://github.com/h675786161-prog/Kanji-Dojo/actions/workflows/build-zh-apk.yml)，选择最近一次成功运行。
2. 在页面下方下载 `Kanji-Dojo-zh-CN-android-apk` 构建产物并解压 ZIP，阅读其中的 `SOURCE_AND_LICENSE.txt`，确认 APK 对应的源码提交。
3. 安装其中的 APK。该包使用 GitHub Actions 的**调试签名**，包名带有 `.fdroid.dev` 后缀，可与 F-Droid 正式版并存，但不能覆盖正式版。
4. 当手机系统语言为简体中文时，界面自动显示中文；当前尚未提供应用内手动切换语言。

## 当前完成

- 中文应用名称「日语道场」与常用界面、卡组、学习进度、提醒、反馈等翻译。
- Android 与 Compose 双资源系统适配中文。
- 构建前检查中文字符串接口、资源键及格式化参数，防止误翻译 Kotlin 属性名。
- 保留离线假名/汉字/词汇学习、手写练习与间隔复习功能。

## 已知限制与改进计划

- 部分词典释义仍来自上游英文数据；**界面汉化不代表日语词典全部中文化**。
- 目前是自动签名的调试版，适合自用测试，不适合直接作为商店正式发行版。
- 尚未完成手机实机安装、横竖屏与全部课程路径回归验证。
- 后续优先项：中文词典释义选项、新手五十音引导、易混淆假名专项训练、语言选择与正式版签名/稳定更新流程。

源码遵守原项目 GPL-3.0-or-later 许可。使用、改动与再分发请保留相应版权声明和许可证。

## 赞助链接归属

中文版目前不收取赞助。APP 内的“支持原作者（syt0r）”按钮和本仓库的 `.github/FUNDING.yml` 均指向 **Kanji Dojo 原作者的 Buy Me a Coffee 页面**：https://buymeacoffee.com/syt0r 。这是保留上游项目的赞助入口，**不是中文版维护者的收款渠道**。
