package com.example.jetbase.ui.activity.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberImagePainter
import com.example.domain.entity.PullRequestEntity
import com.example.domain.entity.PullRequestEntity.PullRequestEntityItem
import com.example.jetbase.R.string
import com.example.jetbase.ui.theme.JetBaseTheme
import com.example.jetbase.util.ViewModelFactory
import com.example.jetbase.util.ViewState
import com.example.jetbase.util.ViewState.Error
import com.example.jetbase.util.ViewState.Loading
import com.example.jetbase.util.ViewState.NoInternet
import com.example.jetbase.util.ViewState.Success

class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityVM by lazy {
        ViewModelProvider(this, ViewModelFactory())[MainActivityVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetBaseTheme {
                val pullRequestsState by viewModel.pullRequestsLiveData.collectAsState()
                MainActivityScreen(pullRequestsState)
            }
        }
        viewModel.getClosedPullRequests("mutualmobile", "Praxis")
    }
}

@Composable
fun MainActivityScreen(viewState: ViewState<PullRequestEntity>) {
    Scaffold {
        when (viewState) {
            is Success -> PullsList(pullRequestEntity = viewState.data)
            is Error -> {
                ShowToast(message = viewState.message)
            }

            Loading -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

            NoInternet -> {
                ShowToast(message = stringResource(string.no_internet))
            }
        }
    }
}

@Composable
fun PullsList(pullRequestEntity: PullRequestEntity) {
    LazyColumn {
        items(pullRequestEntity) { item: PullRequestEntityItem ->
            PullRequestItem(pullRequestEntityItem = item)
        }
    }
}

@Composable
fun PullRequestItem(pullRequestEntityItem: PullRequestEntityItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(pullRequestEntityItem.userImageUrl),
            contentDescription = stringResource(string.avatar),
            modifier = Modifier
                .size(64.dp)
                .padding(4.dp)
                .clip(CircleShape)
        )
        Column {
            CustomText(text = pullRequestEntityItem.title.toString(), FontWeight.Bold, Color.Black)
            CustomText(text = pullRequestEntityItem.userName.toString())
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(text = stringResource(string.opened_at), color = Color.Blue)
                CustomText(text = pullRequestEntityItem.createdDate.toString())
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(text = stringResource(string.closed_at), color = Color.Red)
                CustomText(text = pullRequestEntityItem.closedDate.toString())
            }
            Divider()
        }
    }
}

@Composable
fun ShowToast(message: String) {
    Toast.makeText(LocalContext.current, message, Toast.LENGTH_LONG).show()
}

@Composable
fun CustomText(
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Gray
) {
    Text(text = text, modifier = Modifier.padding(4.dp), fontWeight = fontWeight, color = color)
}
