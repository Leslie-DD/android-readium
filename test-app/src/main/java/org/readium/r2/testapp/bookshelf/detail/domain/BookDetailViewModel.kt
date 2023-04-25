package org.readium.r2.testapp.bookshelf.detail.domain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import org.readium.r2.testapp.Application
import org.readium.r2.testapp.domain.model.Book
import org.readium.r2.testapp.utils.createViewModelFactory

class BookDetailViewModel(
    application: Application,
    bookId: Long
) : ViewModel() {

    private val bookRepository = application.bookRepository

    val book: Flow<Book> = bookRepository.getByFlow(bookId)


    companion object {
        fun createFactory(application: Application, bookId: Long) =
            createViewModelFactory {
                BookDetailViewModel(application, bookId)
            }
    }

}
