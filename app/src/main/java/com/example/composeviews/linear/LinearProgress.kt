package com.example.composeviews.linear

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.composeviews.R
import com.intuit.sdp.R as DP
import com.intuit.ssp.R as SP

@Composable
fun LinearProgress() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    text = "Compose Rating",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Ratings(
                headerTitle = rating.title,
                headerDes = rating.description,
                average = rating.avg,
                data = rating.items!!
            )
        }
    }
}

fun Number.separated() = "%,d".format(this)

@Composable
fun Ratings(
    headerTitle: String?,
    headerDes: String?,
    average: Float?,
    data: Rating.Items
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            SectionHeader(
                title = headerTitle,
                desc = headerDes,
                modifier = Modifier.weight(1f)
            )
            average?.let {
                Column(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = DP.dimen._8sdp))
                        .border(
                            border = BorderStroke(
                                width = dimensionResource(id = DP.dimen._1sdp),
                                color = MaterialTheme.colors.secondary.copy(alpha = 0.3f)
                            ),
                            shape = RoundedCornerShape(dimensionResource(id = DP.dimen._8sdp))
                        )
                        .clip(RoundedCornerShape(dimensionResource(id = DP.dimen._8sdp)))
                        .clickable { }
                        .padding(dimensionResource(id = DP.dimen._6sdp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = average.toString(),
                        color = MaterialTheme.colors.primary,
                        fontSize = dimensionResource(id = SP.dimen._24ssp).value.sp,
                        fontWeight = FontWeight.Bold
                    )
                    if (data?.numberOfVotes() ?: 0 > 0) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Person",
                                modifier = Modifier.size(dimensionResource(id = DP.dimen._15sdp)),
                                tint = MaterialTheme.colors.secondary.copy(alpha = 0.7f)
                            )
                            Spacer(modifier = Modifier.width(dimensionResource(id = DP.dimen._1sdp)))

                            Text(
                                text = data?.numberOfVotes()!!.separated(),
                                color = MaterialTheme.colors.secondary,
                                fontSize = dimensionResource(id = SP.dimen._10ssp).value.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
        if (data.toPairList().isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = DP.dimen._8sdp))
            ) {
                data.toPairList().forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(id = DP.dimen._8sdp)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.first,
                            modifier = Modifier.padding(end = dimensionResource(id = DP.dimen._8sdp)),
                            color = MaterialTheme.colors.secondary,
                            fontSize = dimensionResource(id = SP.dimen._13ssp).value.sp,
                            fontWeight = FontWeight.Bold
                        )
                        LinearProgressIndicator(
                            (it.second ?: 0).toFloat().div(data.numberOfVotes()),
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(dimensionResource(id = DP.dimen._5sdp)))
                                .height(dimensionResource(id = DP.dimen._7sdp)),
                            color = MaterialTheme.colors.primary.copy(alpha = 0.5f),
                            backgroundColor = MaterialTheme.colors.secondary.copy(0.3f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String?,
    desc: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        if (!title.isNullOrBlank()) {
            Text(
                text = title,
                modifier = Modifier.padding(horizontal = dimensionResource(id = DP.dimen._8sdp)),
                color = Color.Blue,
                fontSize = dimensionResource(id = SP.dimen._14ssp).value.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        if (!desc.isNullOrEmpty()) {
            Text(
                text = desc,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = DP.dimen._8sdp)),
                color = MaterialTheme.colors.secondary,
                fontSize = dimensionResource(id = SP.dimen._12ssp).value.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}