package compose.project.virginmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import compose.project.virginmoney.domain.repository.PeopleRepository
import compose.project.virginmoney.domain.repository.RoomsRepository
import compose.project.virginmoney.domain.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    private val peopleRepo: PeopleRepository by inject()
    private val roomsRepo: RoomsRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //startKoin()
        startKoin {
            androidContext(this@MainActivity)
            modules(sharedModule)
        }

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}