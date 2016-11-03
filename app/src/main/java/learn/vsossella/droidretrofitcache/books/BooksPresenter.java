package learn.vsossella.droidretrofitcache.books;

import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

import learn.vsossella.droidretrofitcache.data.BookService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class BooksPresenter
{
    private final BookService service;

    public BooksPresenter(BookService service)
    {
        this.service = service;
    }

    public void initDataSet ()
    {
        service.getBooks().enqueue( new Callback<List<Object>>()
        {
            @Override
            public void onResponse (Call<List<Object>> call, Response<List<Object>> response)
            {
                if ( response.isSuccessful() )
                {
                    LinkedTreeMap<String, String> o = (LinkedTreeMap<String, String>)response.body().get(0);

                    Timber.i( o.get("question") );
                }
            }

            @Override
            public void onFailure (Call<List<Object>> call, Throwable t)
            {
                Timber.e( t, "Unable to load the books data from API." );
            }
        } );
    }
}