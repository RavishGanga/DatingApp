package com.quintus.labs.datingapp.introduction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.PagerState
import com.quintus.labs.datingapp.introduction.ComposeUtils.PageIndicator

val selectedColour = Color.Red
val normalColour = Color.Gray
object ComposeUtils {
    @JvmStatic
    fun setContentForComposeView(composeView: ComposeView, pagerState: PagerState) {
        composeView.setContent {
            MaterialTheme {
                PageIndicator(count = 5, pagerState = pagerState)
            }
        }
    }

    @Composable
    fun PageIndicator(
        count: Int,
        pagerState: PagerState,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
        ) {
            repeat(count) { index ->

                // play with size and corner shape to get the desired result
                // following displays a dot
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(50))
                        .background(
                            if (pagerState.currentPage == index) selectedColour else normalColour
                        )
                )

                // to add space between indicators
                if (index != count) {
                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Page Indicator Preview")
@Composable
fun PreviewPageIndicator() {
    // Create a dummy PagerState.
    // Note: This may require additional setup to mimic real behavior.
    val dummyPagerState = PagerState(
        currentPage = 2  // Current page index for preview
    )

    MaterialTheme {
        PageIndicator(
            count = 5,
            pagerState = dummyPagerState
            // You can adjust the modifier if needed
        )
    }
}