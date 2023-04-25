package org.readium.r2.testapp.bookshelf.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import org.readium.r2.testapp.Application
import org.readium.r2.testapp.bookshelf.detail.domain.BookDetailViewModel
import org.readium.r2.testapp.bookshelf.detail.theme.AppTheme
import org.readium.r2.testapp.bookshelf.detail.ui.BookDetailScreen

class BookDetailActivity : AppCompatActivity() {

    private val viewModel: BookDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BookDetailScreen(viewModel)
                }
            }
        }
    }

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory {
        val bookId = intent.getLongExtra("bookId", 0)
        return BookDetailViewModel.createFactory(application as Application, bookId)
    }
}

@Composable
public fun DetailContent() {

}