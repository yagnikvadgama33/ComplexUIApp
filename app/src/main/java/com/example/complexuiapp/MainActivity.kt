package com.example.complexuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.complexuiapp.components.AirdropTimeline
import com.example.complexuiapp.components.BearContent
import com.example.complexuiapp.components.ExpandableText
import com.example.complexuiapp.components.MiddleGradientBackground
import com.example.complexuiapp.components.SocialLinksBottomSheet
import com.example.complexuiapp.components.SocialMediaIcons
import com.example.complexuiapp.components.WaveItems
import com.example.complexuiapp.components.WavyCanvasView
import com.example.complexuiapp.helper.sdp
import com.example.complexuiapp.ui.theme.ComplexUIAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                resources.getColor(R.color.transparent, null),
                resources.getColor(R.color.transparent, null)
            )
        )

        setContent {

            val scrollState = rememberScrollState()

            ComplexUIAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                        ),
                        title = {},
                        navigationIcon = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                CvIconButton(
                                    R.drawable.ic_back,
                                    modifier = Modifier
                                        .padding(start = 8.sdp),
                                    iconDescription = stringResource(R.string.back)
                                ) { }
                                CircularImageWithBackground(
                                    R.drawable.ic_airdrop,
                                    contentDescription = stringResource(R.string.airdrop),
                                    modifier = Modifier
                                        .padding(end = 26.sdp),
                                    bgColor = Color.White,
                                    imgSize = 46.sdp
                                )
                            }
                        }
                    )
                }) { innerPadding ->
                    MainAScreenUI(scrollState, innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainAScreenUI(
    scrollState: androidx.compose.foundation.ScrollState,
    paddingValues: PaddingValues
) {
    var isShowMoreSocialIconsClicked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.42f)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF00C7D8),
                            Color(0xFF23869A)
                        )
                    )
                ),
        ) {
            //Bear Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.sdp)
            ) {
                CvImageView(
                    painter = R.drawable.ic_bear,
                    stringResource(R.string.baer),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(290.sdp)
                )
            }
        }

        Box {

            //Bg Middle Fade Gradent
            MiddleGradientBackground()

            Column {
                //Bg Top Rounded Corner Shape
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.sdp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(topStart = 28.sdp, topEnd = 28.sdp)
                        ),
                ) {
                    Column(modifier = Modifier.padding(horizontal = 14.sdp)) {

                        //Win 10 with BOBER content
                        BearContent()

                        Spacer(Modifier.height(12.sdp))

                        //Social Icons
                        SocialMediaIcons(onClick = {
                            isShowMoreSocialIconsClicked = true
                        })

                        Spacer(Modifier.height(22.sdp))

                        //Desc Text for "Read More"
                        ExpandableText(
                            text = stringResource(R.string.desc_text),
                            modifier = Modifier.padding(horizontal = 4.sdp)
                        )

                        Spacer(Modifier.height(32.sdp))
                    }
                }

                //Wave and below content box
                Box {
                    WavyCanvasView()

                    Row(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        WaveItems()
                        WaveItems()
                        WaveItems()
                    }
                }

                Spacer(Modifier.height(20.sdp))

                //Airdrop Timeline
                AirdropTimeline()
            }
        }
    }

    //Check for icon click
    if (isShowMoreSocialIconsClicked) {
        SocialLinksBottomSheet()
    }
}