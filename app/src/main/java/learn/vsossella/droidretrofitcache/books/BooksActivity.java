package learn.vsossella.droidretrofitcache.books;

import android.app.Activity;
import android.os.Bundle;

import learn.vsossella.droidretrofitcache.R;
import learn.vsossella.droidretrofitcache.di.Injector;

public class BooksActivity extends Activity
{
    private BooksPresenter booksPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        booksPresenter = new BooksPresenter( Injector.provideBookService() );

        booksPresenter.initDataSet();
    }

    @Override
    protected void onResume ()
    {
        super.onResume();
        booksPresenter.initDataSet();
    }

}
