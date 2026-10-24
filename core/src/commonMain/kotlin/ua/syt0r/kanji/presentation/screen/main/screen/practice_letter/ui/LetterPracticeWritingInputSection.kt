package ua.syt0r.kanji.presentation.screen.main.screen.practice_letter.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import ua.syt0r.kanji.presentation.common.resources.string.resolveString
import ua.syt0r.kanji.presentation.common.ui.kanji.Kanji
import ua.syt0r.kanji.presentation.screen.main.screen.practice_common.CharacterWritingProgress
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ua.syt0r.kanji.presentation.screen.main.screen.practice_common.CharacterWriter
import ua.syt0r.kanji.presentation.screen.main.screen.practice_common.CharacterWriterDecorations
import ua.syt0r.kanji.presentation.screen.main.screen.practice_letter.data.LetterPracticeReviewState

@Composable
fun LetterPracticeWritingInputSection(
    state: State<LetterPracticeReviewState.Writing>,
    tracingEnabled: Boolean,
    onTracingToggle: () -> Unit,
    modifier: Modifier = Modifier
) {

    val writerState = remember { derivedStateOf { state.value.writerState.value } }

    CharacterWriterDecorations(
        modifier = modifier,
        state = writerState
    ) {

        val transition = updateTransition(
            targetState = writerState.value,
            label = "Different Characters Transition"
        )

        transition.AnimatedContent(
            modifier = Modifier.fillMaxSize(),
            transitionSpec = {
                ContentTransform(
                    targetContentEnter = fadeIn(),
                    initialContentExit = fadeOut()
                )
            }
        ) { currentWriterState ->

            Box(modifier = Modifier.fillMaxSize()) {
                if (tracingEnabled &&
                    currentWriterState.progress.value == CharacterWritingProgress.Writing
                ) {
                    // Translucent reference strokes share the exact writing canvas coordinates.
                    // They do not consume touch events or modify the stroke evaluator.
                    Kanji(
                        strokes = currentWriterState.strokes,
                        modifier = Modifier.fillMaxSize().alpha(0.19f)
                    )
                }

                CharacterWriter(
                    state = currentWriterState,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }

        TextButton(
            onClick = onTracingToggle,
            modifier = Modifier.align(Alignment.TopStart).padding(4.dp)
        ) {
            Text(
                text = if (tracingEnabled) {
                    resolveString { letterPractice.tracingDisableButton }
                } else {
                    resolveString { letterPractice.tracingEnableButton }
                }
            )
        }

    }

}
