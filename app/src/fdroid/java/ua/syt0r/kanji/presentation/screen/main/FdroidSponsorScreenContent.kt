package ua.syt0r.kanji.presentation.screen.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import ua.syt0r.kanji.presentation.common.resources.string.resolveString
import ua.syt0r.kanji.presentation.screen.main.screen.sponsor.SponsorScreenContract
import ua.syt0r.kanji.presentation.screen.main.screen.sponsor.SponsorScreenUI

// Add the Chinese edition maintainer's own payment URL here before enabling donations.
// Never point the milk-tea button at the upstream author's payment page.
private const val MaintainerMilkTeaUrl = ""

object FdroidSponsorScreenContent : SponsorScreenContract.Content {

    @Composable
    override fun invoke(state: MainNavigationState) {
        SponsorScreenUI(
            onUpClick = { state.navigateBack() },
            showRecentDonations = false
        ) {
            val uriHandler = LocalUriHandler.current
            Button(
                onClick = {
                    if (MaintainerMilkTeaUrl.isNotBlank()) {
                        uriHandler.openUri(MaintainerMilkTeaUrl)
                    }
                },
                enabled = MaintainerMilkTeaUrl.isNotBlank(),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(resolveString { sponsor.buttonText })
            }

            if (MaintainerMilkTeaUrl.isBlank()) {
                Text(resolveString { sponsor.unavailableMessage })
            }
        }
    }
}
