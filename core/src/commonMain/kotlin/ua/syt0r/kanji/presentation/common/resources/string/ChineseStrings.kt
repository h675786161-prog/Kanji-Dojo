package ua.syt0r.kanji.presentation.common.resources.string

import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import ua.syt0r.kanji.presentation.common.CommonDateTimeFormat
import ua.syt0r.kanji.presentation.common.theme.extraColorScheme
import ua.syt0r.kanji.presentation.common.withClickableUrl
import kotlin.time.Duration
import ua.syt0r.kanji.presentation.screen.main.screen.feedback.FeedbackScreen

object ChineseStrings : Strings {

    override val appName: String = "日语道场"

    override val hiragana: String = "平假名"
    override val katakana: String = "片假名"

    override val kunyomi: String = "训读"
    override val onyomi: String = "音读"

    override val loading: String = "加载中"

    override val letterPracticeTypeWriting: String = "书写练习"
    override val letterPracticeTypeReading: String = "认读练习"
    override val vocabPracticeTypeFlashcard: String = "记忆卡片"
    override val vocabPracticeTypeReadingPicker: String = "读音选择"
    override val vocabPracticeTypeWriting: String = "书写练习"

    override val reviewStateDone: String = "已完成"
    override val reviewStateDue: String = "待复习"
    override val reviewStateNew: String = "未学习"

    override val home: HomeStrings = ChineseHomeStrings
    override val commonDashboard = ChineseCommonDashboardStrings
    override val dailyLimit = ChineseDailyLimitStrings
    override val tutorialDialog: TutorialDialogStrings = ChineseTutorialDialogStrings
    override val stats: StatsStrings = ChineseStatsStrings
    override val search: SearchStrings = ChineseSearchStrings
    override val alternativeDialog: AlternativeDialogStrings = ChineseAlternativeDialogStrings

    override val settings: SettingsStrings = ChineseSettingsStrings
    override val reminderDialog: ReminderDialogStrings = ChineseReminderDialogStrings
    override val about: AboutStrings = ChineseAboutStrings
    override val backup: BackupStrings = ChineseBackupStrings
    override val feedback: FeedbackStrings = ChineseFeedbackStrings
    override val sponsor: SponsorStrings = ChineseSponsorStrings
    override val account: AccountScreenStrings = ChineseAccountScreenStrings
    override val sync: SyncScreenStrings = ChineseSyncScreenStrings
    override val syncDialog: SyncDialogStrings = ChineseSyncDialogStrings
    override val syncSnackbar: SyncSnackbarStrings = ChineseSyncSnackbarStrings

    override val deckPicker: DeckPickerStrings = ChineseDeckPickerStrings
    override val deckEdit: DeckEditStrings = ChineseDeckEditStrings
    override val deckDetails: DeckDetailsStrings = ChineseDeckDetailsStrings
    override val commonPractice: CommonPracticeStrings = ChineseCommonPracticeStrings
    override val letterPractice: LetterPracticeStrings = ChineseLetterPracticeStrings
    override val vocabPractice: VocabPracticeStrings = ChineseVocabPracticeStrings
    override val info: InfoScreenStrings = ChineseInfoScreenStrings

    override val urlPickerMessage: String = "打开"
    override val urlPickerErrorMessage: String = "未找到浏览器"

    override val reminderNotification: ReminderNotificationStrings =
        ChineseReminderNotificationStrings

}

object ChineseHomeStrings : HomeStrings {
    override val screenTitle: String = ChineseStrings.appName
    override val generalDashboardTabLabel: String = "首页"
    override val lettersDashboardTabLabel: String = "文字"
    override val vocabDashboardTabLabel: String = "单词"
    override val statsTabLabel: String = "统计"
    override val searchTabLabel: String = "搜索"
    override val settingsTabLabel: String = "设置"
}

object ChineseCommonDashboardStrings : CommonDashboardStrings {
    override val emptyScreenMessage: (inlineIconId: String) -> AnnotatedString = {
        buildAnnotatedString {
            append("请先创建一个学习卡组。")
            appendInlineContent(it)
            append("点击按钮创建卡组，之后就能记录学习进度。")
        }
    }

    override val mergeButton: String = "合并"
    override val mergeCancelButton: String = "取消"
    override val mergeAcceptButton: String = "合并"
    override val mergeTitle: String = "将多个卡组合并为一个"
    override val mergeTitleHint: String = "输入标题"
    override val mergeSelectedCount: (Int) -> String = { "已选 $it 项" }
    override val mergeClearSelectionButton: String = "清除"

    override val mergeDialogTitle: String = "确认合并"
    override val mergeDialogMessage: (String, List<String>) -> String = { newTitle, mergedTitles ->
        "以下 ${mergedTitles.size} 个卡组将合并到新卡组「$newTitle」：${mergedTitles.joinToString()}"
    }
    override val mergeDialogCancelButton: String = "取消"
    override val mergeDialogAcceptButton: String = "合并"

    override val sortButton: String = "排序"
    override val sortCancelButton: String = "取消"
    override val sortAcceptButton: String = "应用"
    override val sortTitle: String = "调整卡组顺序"
    override val sortByTimeTitle: String = "按上次练习时间排序"

    override val itemTimeMessage: (Duration?) -> String = {
        "上次练习：" + when {
            it == null -> "无"
            it.inWholeDays > 0 -> "${it.inWholeDays} 天前"
            else -> "不到 1 天"
        }
    }

    override val itemTotal: String = "总计"
    override val itemDone: String = "已完成"
    override val itemReview: String = "待复习"
    override val itemNew: String = "未学习"
    override val dailyPracticeTitle: String = "每日练习"
    override val dailyPracticeNew: (Int) -> String = { "新学 ($it)" }
    override val dailyPracticeDue: (Int) -> String = { "复习 ($it)" }
    override val itemGraphProgressTitle: String = "完成率"

    override val selectedPracticeTypeTemplate: (practiceType: String) -> String =
        { "练习方式：$it" }

}

object ChineseDailyLimitStrings : DailyLimitStrings {
    override val enableSwitchTitle: String = "启用"
    override val enableSwitchDescription: String =
        "限制每天推荐的练习数量"
    override val lettersSectionTitle: String = "文字"
    override val vocabSectionTitle: String = "单词"
    override val combinedLimitSwitchTitle: String = "统一限额"
    override val combinedLimitSwitchDescription: String = "为所有练习方式设置统一限额"
    override val newLabel: String = "新学"
    override val dueLabel: String = "到期"
    override val noteMessage: String = "注意：书写与认读练习分别计入限额"
    override val button: String = "保存"
    override val changesSavedMessage: String = "已完成"
}


object ChineseTutorialDialogStrings : TutorialDialogStrings {
    override val title: String = "使用教程"

    override val page1: String = """
        • 本应用采用间隔重复系统（SRS），帮助你安排复习时间
        • 每次复习后，系统会根据你的表现计算下一次复习时间
        • 记得越牢，下次复习间隔越长；记不住则会更快复习
    """.trimIndent()

    override val page2Top: String = """
        • 复习后请根据回忆难度为自己的表现评分
    """.trimIndent()

    override val page2Bottom: String = """
        • 请选择最符合实际记忆情况的选项
        • 系统会据此安排更适合你的学习节奏
    """.trimIndent()

    override val page3Top: String = """
        • 卡片复习状态每天都会更新
        • 应用会安排新卡和到期卡片进行学习
    """.trimIndent()

    override val page3Bottom: String = """
        • 可设置每日练习上限，避免负担过重
    """.trimIndent()

    override val page4Top: String = """
        • 首先创建一个卡组开始学习
        • 卡组用于整理学习内容，分为文字卡组与词汇卡组
    """.trimIndent()

    override val page4Bottom: String = """
        • 可以创建自己的卡组，也可以选用内置卡组
    """.trimIndent()

    override val page5: String = """
        • 创建卡组后就可以开始练习
        • 可以尝试不同的练习模式
        • 坚持比突击更重要。每天练习一点，必要时降低每日练习量
        • 祝你日语学习顺利！\(^_^)/ 
    """.trimIndent()
}


private fun formatDuration(duration: Duration): String = when {
    duration.inWholeHours > 0 -> "${duration.inWholeHours}小时 ${duration.inWholeMinutes % 60}分钟"
    duration.inWholeMinutes > 0 -> "${duration.inWholeMinutes}分钟 ${duration.inWholeSeconds % 60}秒"
    else -> "${duration.inWholeSeconds}秒"
}

object ChineseStatsStrings : StatsStrings {
    override val todayTitle: String = "今天"
    override val monthTitle: String = "本月"
    override val monthLabel: (day: LocalDate) -> String =
        { "${it.year}年${it.monthNumber}月" }
    override val yearTitle: String = "今年"
    override val yearDaysPracticedLabel = { practicedDays: Int, daysInYear: Int ->
        "练习天数：$practicedDays/$daysInYear"
    }
    override val totalTitle: String = "总计"
    override val timeSpentTitle: String = "练习时长"
    override val reviewsCountTitle: String = "练习次数"
    override val formattedDuration: (Duration) -> String = { formatDuration(it) }
    override val uniqueLettersReviewed: String = "已练习不同文字数"
    override val uniqueWordsReviewed: String = "已练习不同单词数"
}


object ChineseSearchStrings : SearchStrings {
    override val inputHint: String = "输入文字或单词"
    override val charactersTitle: (count: Int) -> String = { "文字 ($it)" }
    override val wordsTitle: (count: Int) -> String = { "单词 ($it)" }
    override val radicalsSheetTitle: String = "按部首搜索"
    override val radicalsFoundCharacters: String = "找到的文字"
    override val radicalsEmptyFoundCharacters: String = "没有找到结果"
    override val radicalSheetRadicalsSectionTitle: String = "部首"
}

object ChineseAlternativeDialogStrings : AlternativeDialogStrings {
    override val title: String = "其他词语"
    override val readingsTitle: String = "读音"
    override val meaningsTitle: String = "释义"
    override val reportButton: String = "反馈"
    override val closeButton: String = "关闭"
}

object ChineseSettingsStrings : SettingsStrings {
    override val analyticsTitle: String = "数据分析"
    override val analyticsMessage: String = "允许发送匿名使用数据以改进应用"
    override val themeTitle: String = "主题"
    override val themeSystem: String = "跟随系统"
    override val themeLight: String = "浅色"
    override val themeDark: String = "深色"
    override val themeAmoled: String = "AMOLED（纯黑）"
    override val reminderTitle: String = "学习提醒"
    override val reminderEnabled: String = "启用"
    override val reminderDisabled: String = "关闭"
    override val defaultTab: String = "默认页面"
    override val feedbackTitle: String = "意见反馈"
    override val account: String = "账户"
    override val sync: String = "同步（预览）"
    override val backupTitle: String = "备份与恢复"
    override val aboutTitle: String = "关于应用"
    override val pickerDialogCancel: String = "取消"
    override val pickerDialogApply: String = "应用"
}

object ChineseReminderDialogStrings : ReminderDialogStrings {
    override val title: String = "学习提醒"
    override val noPermissionLabel: String = "未获得通知权限"
    override val noPermissionButton: String = "允许"
    override val enabledLabel: String = "通知"
    override val timeLabel: String = "时间"
    override val cancelButton: String = "取消"
    override val applyButton: String = "应用"
}

object ChineseAboutStrings : AboutStrings {
    override val derivativeNotice: String = "基于 Yaroslav Shuliak 的 Kanji Dojo 修改；2026-10-24 汉化。非官方版本，依 GPL-3.0 或更新版本授权。"
    override val upstreamTitle: String = "原版 Kanji Dojo"
    override val upstreamDescription: String = "原作者及原项目仓库"
    override val gplTitle: String = "GNU GPLv3 开源许可证"
    override val gplDescription: String = "查看使用、修改及再分发条款"
    override val title: String = "关于应用"
    override val version: (versionName: String) -> String = { "版本：$it" }
    override val githubTitle: String = "项目 GitHub 页面"
    override val versionChangesTitle: String = "更新日志"
    override val versionChangesDescription: String = "查看更新日志"
    override val versionChangesButton: String = "关闭"
    override val githubDescription: String = "源码、问题反馈和讨论"
    override val creditsTitle: String = "鸣谢"
    override val creditsDescription: String = "使用的代码库与数据来源"
}

object ChineseBackupStrings : BackupStrings {
    override val title: String = "备份"
    override val backupButton: String = "创建备份"
    override val restoreButton: String = "从备份恢复"
    override val unknownError: String = "未知错误"
    override val restoreVersionMessage: (Long, Long) -> String = { backupVersion, currentVersion ->
        "数据库版本：$backupVersion（当前：$currentVersion）"
    }
    override val restoreTimeMessage: (LocalDateTime) -> String = {
        "创建时间：${it.format(CommonDateTimeFormat)}"
    }
    override val restoreNote: String =
        "警告：当前学习记录将被所选备份覆盖"
    override val restoreApplyButton: String = "恢复"
    override val completeMessage: String = "已完成"
}

object ChineseFeedbackStrings : FeedbackStrings by EnglishFeedbackStrings {
    override val topicGeneral: String = "常规问题"
    override val topicExpression: (id: Long, screen: FeedbackScreen) -> String = { id, screen ->
        val screenName = when (screen) {
            FeedbackScreen.WritingPractice -> "书写练习"
            FeedbackScreen.ReadingPractice -> "认读练习"
            FeedbackScreen.Search -> "搜索"
            FeedbackScreen.CharacterInfo -> "文字详情"
            FeedbackScreen.VocabPractice -> "单词练习"
        }
        "$screenName · 条目 $id"
    }
    override val title: String = "意见反馈"
    override val topicTitle: String = "主题"
    override val messageLabel: String = "请输入反馈内容"
    override val button: String = "发送"
    override val successMessage: String = "反馈已发送"
    override val errorMessage: (String?) -> String = { "错误：$it" }
}

object ChineseSponsorStrings : SponsorStrings {
    override val pageTitle: String = "支持日语道场中文版"
    override val buttonText: String = "🥤 请中文版作者喝杯奶茶"
    override val unavailableMessage: String = "还没有配置中文版作者的收款链接，暂时无法赞助。"
    override val message: String = """
        「日语道场」是基于 Kanji Dojo 开发的非官方简体中文版本。
        原项目作者为 Yaroslav Shuliak，原项目地址与 GPL 许可仍保留在「关于」页面。

        这里的奶茶赞助计划提供给中文版维护者，不代表原作者收款。
        当前还未配置收款链接，因此尚未开放赞助。
    """.trimIndent()
}

object ChineseDeckPickerStrings : DeckPickerStrings {

    override val title: String = "选择"

    override val customDeckButton: String = "新建空白卡组"
    override val kanaTitle: String = "假名"

    override val kanaDescription = { urlColor: Color ->
        buildAnnotatedString {
            append("假名是日语的基础文字，分为两类：\n")
            append("・平假名：主要用于日语固有词与语法。\n")
            append("・片假名：常用于外来词与拟声词。")
            withClickableUrl(
                url = "https://ja.wikibooks.org/wiki/%E3%81%B2%E3%82%89%E3%81%8C%E3%81%AA%E3%83%BB%E3%82%AB%E3%82%BF%E3%82%AB%E3%83%8A",
                color = urlColor
            ) {
                append("了解更多")
            }
        }
    }
    override val hiragana: String = ChineseStrings.hiragana
    override val katakana: String = ChineseStrings.katakana

    override val jltpTitle: String = "日本语能力测试"
    override val jlptDescription: StringResolveScope<AnnotatedString> = {
        buildAnnotatedString {
            append("JLPT 是面向非日语母语者的日语能力测试，难度从 N5 到 N1。")
            withClickableUrl(
                url = "https://ja.wikipedia.org/wiki/%E6%97%A5%E6%9C%AC%E8%AA%9E%E8%83%BD%E5%8A%9B%E8%A9%A6%E9%A8%93",
                color = MaterialTheme.extraColorScheme.link
            ) {
                append("更多信息")
            }
        }
    }
    override val jlptItem: (level: Int) -> String = { "JLPT N$it" }

    override val gradeTitle: String = "常用汉字"
    override val gradeDescription = { urlColor: Color ->
        buildAnnotatedString {
            withClickableUrl(
                url = "https://ja.wikipedia.org/wiki/%E5%B8%B8%E7%94%A8%E6%BC%A2%E5%AD%97",
                color = urlColor
            ) {
                append("常用汉字")
            }
            append("包含日本常用的 2,136 个汉字，分为：\n")
            append("・前 1,026 字在小学一年级至六年级学习（")
            withClickableUrl(
                url = "https://ja.wikipedia.org/wiki/%E6%95%99%E8%82%B2%E6%BC%A2%E5%AD%97",
                color = urlColor
            ) {
                append("教育汉字")
            }
            append("）。\n")
            append("・其余 1,110 字在初中及以后学习。")
        }
    }
    override val gradeItemNumbered: (Int) -> String = { "小学 ${it} 年级" }
    override val gradeItemSecondary: String = "初中及以上"
    override val gradeItemNames: String = "人名用汉字（一）"
    override val gradeItemNamesVariants: String = "人名用汉字（二）（常用汉字异体字）"

    override val wanikaniTitle: String = EnglishDeckPickerStrings.wanikaniTitle
    override val wanikaniDescription = { urlColor: Color ->
        buildAnnotatedString {
            append("按照 Tofugu 的 WaniKani 学习等级划分的汉字列表。")
            withClickableUrl("https://www.wanikani.com/kanji?difficulty=pleasant", urlColor) {
                append("更多信息")
            }
        }
    }
    override val wanikaniItem: (Int) -> String = { "WaniKani 等级 $it" }

    override val vocabOtherTitle: String = "其他"
    override val vocabOtherDescription: AnnotatedString =
        AnnotatedString("按常见主题整理的入门词汇卡组。")

    override val vocabDeckItemWordsCountLabel: (words: Int) -> String = { "$it 个词" }
    override val vocabDeckTitleTime: String = "时间"
    override val vocabDeckTitleWeek: String = "星期"
    override val vocabDeckTitleCommonVerbs: String = "常用动词"
    override val vocabDeckTitleColors: String = "颜色"
    override val vocabDeckTitleRegularFood: String = "日常食物"
    override val vocabDeckTitleJapaneseFood: String = "日本料理"
    override val vocabDeckTitleGrammarTerms: String = "语法术语"
    override val vocabDeckTitleAnimals: String = "动物"
    override val vocabDeckTitleBody: String = "身体"
    override val vocabDeckTitleCommonPlaces: String = "常见地点"
    override val vocabDeckTitleCities: String = "城市"
    override val vocabDeckTitleTransport: String = "交通"

}

object ChineseDeckEditStrings : DeckEditStrings {
    override val createTitle: String = "创建卡组"
    override val ediTitle: String = "编辑卡组"
    override val searchHint: String = "输入文字"
    override val editingModeSearchTitle: String = "搜索"
    override val editingModeDetailsTitle: String = "详情"
    override val editingModeRemovalTitle: String = "删除"
    override val vocabDetailsEmptyMessage: (inlineIconId: String) -> AnnotatedString = {
        buildAnnotatedString {
            append("尚无卡片。请先保存卡组，再通过搜索或练习添加卡片。")
            appendInlineContent(it)
            append("也可以在应用内其他页面点击添加图标。")
        }
    }
    override val completeMessage: String = "已完成"
    override val saveTitle: String = "保存更改"
    override val saveInputHint: String = "名称"
    override val saveButtonDefault: String = "保存"
    override val saveButtonCompleted: String = "已完成"
    override val deleteTitle: String = "确认删除"
    override val deleteMessage: (practiceTitle: String) -> String = {
        "确定删除卡组「$it」吗？"
    }
    override val deleteButtonDefault: String = "删除"
    override val deleteButtonCompleted: String = "已完成"
    override val unknownTitle: String = "未知文字"
    override val unknownMessage: (characters: List<String>) -> String = {
        "没有找到 ${it.joinToString()} 的数据"
    }
    override val unknownButton: String = "OK"

    override val leaveConfirmationTitle: String = "要放弃编辑吗？"
    override val leaveConfirmationMessage: String = "未保存的更改将丢失"
    override val leaveConfirmationCancel: String = "取消"
    override val leaveConfirmationAccept: String = "放弃"

}

object ChineseDeckDetailsStrings : DeckDetailsStrings {
    override val emptyListMessage: String = "暂无内容"
    override val detailsGroupTitle: (index: Int) -> String = { "第 $it 组" }
    override val firstTimeReviewMessage: (LocalDateTime?) -> String = {
        "首次练习：" + when (it) {
            null -> "无"
            else -> groupDetailsDateTimeFormatter(it)
        }
    }
    override val lastTimeReviewMessage: (LocalDateTime?) -> String = {
        "上次练习：" + when (it) {
            null -> "无"
            else -> groupDetailsDateTimeFormatter(it)
        }
    }
    override val groupDetailsButton: String = "开始练习"
    override val expectedReviewDate: (LocalDate?) -> String = {
        "计划复习日期：${it ?: "-"}"
    }
    override val lastReviewDate: (LocalDateTime?) -> String = {
        "上次复习日期：${it?.date ?: "-"}"
    }
    override val repetitions: (Int) -> String = { "连续答对次数：$it" }
    override val lapses: (Int) -> String = { "遗忘次数：$it" }

    override val dialogCommon: LetterDeckDetailDialogCommonStrings =
        ChineseLetterDeckDetailDialogCommonStrings
    override val filterDialog: FilterDialogStrings = ChineseFilterDialogStrings
    override val sortDialog: SortDialogStrings = ChineseSortDialogStrings
    override val layoutDialog: PracticePreviewLayoutDialogStrings =
        ChinesePracticePreviewLayoutDialogStrings

    override val multiselectTitle: (selectedCount: Int) -> String = { "已选 $it 项" }
    override val multiselectDataNotLoaded: String = "请稍候…"
    override val multiselectNoSelected: String = "至少选择一项"

    override val filterAllLabel: String = "全选"
    override val filterNoneLabel: String = "全不选"
    override val kanaGroupsModeActivatedLabel: String = "假名分组模式"

    override val shareLetterDeckClipboardMessage: String =
        "卡组文字已复制到剪贴板"
}

object ChineseLetterDeckDetailDialogCommonStrings : LetterDeckDetailDialogCommonStrings {
    override val buttonCancel: String = "取消"
    override val buttonApply: String = "应用"
}

object ChineseFilterDialogStrings : FilterDialogStrings {
    override val title: String = "显示的文字"
}

object ChineseSortDialogStrings : SortDialogStrings {
    override val title: String = "排序"
    override val sortOptionAddOrder: String = "按添加时间"
    override val sortOptionAddOrderHint: String = "↑ 新文字排最后\n↓ 新文字排最前"
    override val sortOptionFrequency: String = "按使用频率"
    override val sortOptionFrequencyHint: String =
        "根据报纸使用频率\n↑ 高频排前\n↓ 高频排后"
    override val sortOptionName: String = "按编码"
    override val sortOptionNameHint: String = "↑ 编码小的排前\n↓ 编码大的排前"
    override val sortOptionReviewTime: String = "按预计复习时间"
    override val sortOptionReviewTimeHint: String =
        "↑ 未复习卡片排前\n↓ 复习日期最远的排前"
}

object ChinesePracticePreviewLayoutDialogStrings : PracticePreviewLayoutDialogStrings {
    override val title: String = "布局"
    override val singleCharacterOptionLabel: String = "列表"
    override val groupsOptionLabel: String = "分组"
    override val kanaGroupsTitle: String = "假名分组"
    override val kanaGroupsSubtitle: String =
        "包含全部假名时，按照五十音顺序分组"
}

object ChineseCommonPracticeStrings : CommonPracticeStrings {

    override val configurationTitle: String = "练习设置"
    override val configurationSelectedItemsLabel: String = "练习数量："
    override val configurationCharactersPreview: String = "文字预览"
    override val shuffleConfigurationTitle: String = "打乱顺序"
    override val shuffleConfigurationMessage: String = "随机排列复习顺序"
    override val configurationCompleteButton: String = "开始"

    override val additionalKanaReadingsNote: (List<String>) -> String = {
        "注意：也可写作 ${it.joinToString { "「$it」" }}"
    }

    override val formattedSrsInterval: (Duration) -> String = {
        val duration = formattedSrsDuration(
            duration = it,
            dayLabel = "天",
            hourLabel = "小时",
            minuteLabel = "分",
            secondLabel = "秒",
            separator = ""
        )
        "${duration}后"
    }
    override val flashcardRevealButton: String = "查看答案"
    override val againButton: String = "重来"
    override val hardButton: String = "困难"
    override val goodButton: String = "正确"
    override val easyButton: String = "简单"

    override val summaryTimeSpentValue: (Duration) -> String = { formatDuration(it) }

    override val earlyFinishDialogTitle: String = "确定结束练习吗？"
    override val earlyFinishDialogMessage: String =
        "将进入练习总结。当前进度已保存。"
    override val earlyFinishDialogCancelButton: String = "取消"
    override val earlyFinishDialogAcceptButton: String = "结束"

}

object ChineseLetterPracticeStrings : LetterPracticeStrings {
    override val configurationTitle: (practiceType: String) -> String = { "文字练习 · $it" }
    override val hintStrokesTitle: String = "显示笔画提示"
    override val hintStrokesMessage: String = "设置什么时候显示提示"
    override val hintStrokeNewOnlyMode: String = "仅新卡"
    override val hintStrokeAllMode: String = "始终"
    override val hintStrokeNoneMode: String = "不显示"
    override val inputModeTitle: String = "输入模式"
    override val inputModeMessage: String = "选择逐笔验证或整字验证"
    override val inputModeStroke: String = "笔画"
    override val inputModeCharacter: String = "文字"
    override val kanaRomajiTitle: String = "显示罗马音"
    override val kanaRomajiMessage: String =
        "练习假名时以罗马音代替假名提示"
    override val noTranslationLayoutTitle: String = "隐藏释义"
    override val noTranslationLayoutMessage: String = "书写练习时隐藏字义翻译"
    override val leftHandedModeTitle: String = "左手模式"
    override val leftHandedModeMessage: String = "横屏书写时将书写区域移至左侧"

    override val headerWordsMessage: (count: Int) -> String = { "单词 ($it)" }
    override val studyFinishedButton: String = "待复习"
    override val altStrokeEvaluatorTitle: String = "备用笔画识别"
    override val altStrokeEvaluatorMessage: String =
        "使用备用算法代替原本的笔画识别"
    override val noKanjiTranslationsLabel: String = "[暂无释义]"

    override val variantsTitle: String = "异体字"
    override val variantsHint: String = "点击显示"
    override val unicodeTitle: (String) -> String = EnglishLetterPracticeStrings.unicodeTitle
    override val strokeCountTitle: (count: Int) -> String = { "$it 画" }
}

object ChineseVocabPracticeStrings : VocabPracticeStrings {
    override val configurationTitle: (String) -> String = { "单词练习 · $it" }
    override val readingMeaningConfigurationTitle: String = "始终显示释义"
    override val readingMeaningConfigurationMessage: String =
        "设置未选答案时是否显示释义"
    override val translationInFrontConfigurationTitle: String = "卡片正面显示释义"
    override val translationInFrontConfigurationMessage: String =
        "卡片翻面前显示释义而不是单词"
    override val writingKanaReadingConfigurationTitle: String = "显示假名读音"
    override val writingKanaReadingConfigurationMessage: String =
        "答题前也显示假名读音"
    override val detailsButton: String = "详情"
}

object ChineseInfoScreenStrings : InfoScreenStrings {
    override val strokesMessage: (count: Int) -> AnnotatedString = {
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("$it 画") }
        }
    }
    override val clipboardCopyMessage: String = "已复制"
    override val radicalsSectionTitle: (count: Int) -> String = { "部首 ($it)" }
    override val noRadicalsMessage: String = "无部首"
    override val wordsSectionTitle: (count: Int) -> String = { "单词 ($it)" }
    override val romajiMessage: (romaji: List<String>) -> String = {
        "罗马音：${it.joinToString { "「$it」" }}"
    }
    override val gradeMessage: (grade: Int) -> String = {
        when {
            it <= 6 -> "常用汉字，小学 $it 年级学习"
            it == 8 -> "常用汉字，初中及以上学习"
            it >= 9 -> "人名用汉字"
            else -> throw IllegalStateException("未知年级 $it")
        }
    }
    override val jlptMessage: (level: Int) -> String = { "JLPT 等级 $it" }
    override val frequencyMessage: (frequency: Int) -> String = {
        "报纸常见汉字 2500 字中排名第 $it"
    }

}

object ChineseReminderNotificationStrings : ReminderNotificationStrings {
    override val channelName: String = "学习提醒"
    override val title: String = "该学习啦！"
    override val noDetailsMessage: String = "继续学习日语"
    override val newOnlyMessage: (Int) -> String = {
        "今天有 $it 张新卡待学习"
    }
    override val dueOnlyMessage: (Int) -> String = {
        "今天有 $it 张卡待复习"
    }
    override val message: (Int, Int) -> String = { new, due ->
        "今天有 $new 张新卡，$due 张待复习"
    }
}

object ChineseAccountScreenStrings : AccountScreenStrings {
    override val title = "账户"
    override val loggedOutMessage = "尚未登录"
    override val signInButton = "登录"
    override val signOutButton = "退出登录"
    override val emailTitle = "邮箱"
    override val subscriptionTitle = "订阅"
    override val subscriptionStatusActive = "有效"
    override val subscriptionStatusExpired = "已过期"
    override val subscriptionStatusInactive = "未激活"
    override val subscriptionValidUntilTemplate = "有效期至：%s"
    override val issueNoConnectionTitle = "无法连接"
    override val issueNoConnectionMessage = "正在显示缓存数据"
    override val issueSessionExpiredTitle = "登录会话已过期"
    override val issueSessionExpiredMessage = "点击重新登录"
    override val issueSubscriptionOutdatedTitle = "订阅状态需要刷新"
    override val issueSubscriptionOutdatedMessage = "点击刷新"
    override val issueOtherTitle = "错误"
    override val issueOtherMessageFallback = "未知错误"
}

object ChineseSyncScreenStrings : SyncScreenStrings {
    override val title = "同步（预览）"
    override val guideTitle: String = "跨设备同步学习进度"
    override val guideMessage =
        "自动上传学习数据到云端备份，并在设备间同步"
    override val guideStepAccountTitle = "创建账户并登录"
    override val guideStepAccountMessage: String = "打开账户页面"
    override val guideStepSubscriptionTitle =
        "开通订阅（预览期间免费）"
    override val guideStepSubscriptionMessage: String =
        "更新消息请见 Discord"
    override val accountErrorMessage: String = "账户存在问题"
    override val syncButton = "立即同步"
    override val statusTitle = "状态"
    override val statusMessageLoading = "正在检查服务器更新..."
    override val statusMessageDataDiffer = "本地与云端数据不同"
    override val statusMessageLocalNewer = "可以上传更新的数据"
    override val statusMessageUpToDate = "已与服务器同步"
    override val statusMessageError = "错误"
    override val statusMessageUploading = "正在上传"
    override val statusMessageDownloading = "正在下载"
    override val statusMessageCanceled =
        "操作已取消，点击同步可重新开始"
    override val localDataTitle = "本地数据"
    override val localDataIdTemplate = "ID: %s"
    override val localDataTimestampTemplate = "时间戳：%s"

    override val errorNoConnectionTitle = "无法连接"
    override val errorNoConnectionMessage = "无法连接服务器"
    override val errorSessionExpiredTitle = "登录会话已过期"
    override val errorSessionExpiredMessage = "点击重新登录"
    override val errorNoSubscriptionTitle = "订阅状态需要刷新"
    override val errorNoSubscriptionMessage = "请在账户页面刷新订阅状态"
    override val errorOtherTitle = "错误"
    override val errorOtherMessageFallback = "未知错误"
}

object ChineseSyncDialogStrings : SyncDialogStrings {
    override val title = "同步"
    override val buttonCancel = "取消"
    override val buttonUpload = "上传"
    override val buttonDownload = "下载"
    override val buttonAccount = "账户"
    override val uploadingMessage = "正在上传..."
    override val downloadingMessage = "正在下载..."
    override val conflictRemoteNewerTitle = "发现新数据"
    override val conflictRemoteNewerMessage = "云端数据比本地数据更新"
    override val conflictIncompatibleTitle = "数据冲突"
    override val conflictIncompatibleMessage =
        "本地和云端数据都发生变化，无法自动合并"
    override val errorNoNetworkTitle = "无网络连接"
    override val errorNoNetworkMessage = "无法建立网络连接"
    override val errorNoSubscriptionTitle = "订阅已过期"
    override val errorNoSubscriptionMessage =
        "订阅已过期，同步将被禁用。请在账户页面更新订阅状态。"
    override val errorNotAuthenticatedTitle = "登录会话已过期"
    override val errorNotAuthenticatedMessage = "请重新登录账户"
    override val errorUnexpectedErrorTitle = "意外错误"
    override val errorUnexpectedErrorMessage = "出现未知问题"
    override val errorUnsupportedDataTitle = "服务器数据格式不受支持"
    override val errorUnsupportedDataMessage =
        "云端数据由较新版本创建，与当前版本不兼容。请更新应用，或上传本地数据。"
}

object ChineseSyncSnackbarStrings : SyncSnackbarStrings {
    override val errorNoConnection = "无法连接"
    override val errorNoSubscription = "订阅已过期"
    override val errorNotAuthenticated = "登录信息已过期"
    override val errorDataNotSupported = "不支持此云端数据"
    override val errorMessageTemplate = "同步错误：%s"
    override val errorMessageNoReason = "同步错误"
    override val actionButton = "详情"
}
