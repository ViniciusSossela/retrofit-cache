package learn.vsossella.droidretrofitcache.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService
{
    @GET( "questions" )
    Call<List<Object>> getBooks();
}
