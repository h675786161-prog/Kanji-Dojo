# 开源许可与第三方数据说明

**日语道场（非官方简体中文汉化版）**
- 原项目：Kanji Dojo
- 原作者：Yaroslav Shuliak
- 原项目地址：https://github.com/syt0r/Kanji-Dojo
- 修改类型：简体中文本地化、应用显示名称、构建与校验流程
- 主要修改日期：2026-10-24
- 许可证：GNU General Public License version 3 或更新版本（GPL-3.0-or-later）
- 完整许可证：仓库根目录 LICENSE，或 https://www.gnu.org/licenses/gpl-3.0.html
- 汉化源码：https://github.com/h675786161-prog/Kanji-Dojo/tree/feat/zh-cn-android

原始项目的著作权归原作者及各贡献者，汉化并不表示获得原作者的官方认可。
本汉化版遵守 GPL 授权，无额外限制用户获得、修改或再分发 GPL 涵盖的源码。

## 数据和第三方资源

该应用使用的字形、词典、假名、笔顺和其他数据包含独立授权内容，必须保留其版权与署名。

具体出处、版权方、许可类型请查看：
- 原项目 README.md 的 Credits：https://github.com/syt0r/Kanji-Dojo#credits
- 本仓库 core/credits/libraries/
- 原词典数据项目：https://github.com/syt0r/Kanji-Dojo-Data
- APP 内「关于 → 鸣谢」。

相关项目包括 KanjiVG、KANJIDIC、JMdict、JmdictFurigana、Tanos、Leeds 频率数据等；其中若干数据采用 CC BY / CC BY-SA 授权，其要求独立于主程序 GPL，修改或再次分发数据时应另外遵守。

## APK 与精确源码对应关系

通过 GitHub Actions 下载的 APK 构建产物应当连同 SOURCE_AND_LICENSE.txt、LICENSE、本文件和 README.zh-CN.md 一起提供。SOURCE_AND_LICENSE.txt 记录本次构建的 **完整 Git commit SHA** 以及直接取得该版本源代码的方法。

不要只引用不断变化的 develop 或 feat/zh-cn-android 分支来充当 APK 的对应源码。
