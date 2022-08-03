package com.imooc.webclient;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebClientApplicationTests {

    @Test
    void testGetToken() throws Exception {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("http://localhost:8082/todos")
            .get()
            .addHeader("authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDY1Mzk4NjUsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiLCJST0xFX1NUQUZGIiwiVVNFUl9BRE1JTiIsIlVTRVJfQ1JFQVRFIiwiVVNFUl9VUERBVEUiLCJST0xFX0FETUlOIiwiVVNFUl9SRUFEIl0sImp0aSI6IlFraUlETjBpWmN5YUgzNHhDRjVRYjhndzFsdyIsImNsaWVudF9pZCI6IndlYi1jbGllbnQiLCJzY29wZSI6WyJ0b2RvLnJlYWQiLCJ0b2RvLndyaXRlIl19.C1Arv7LfQtYQDwGBpVhheJAGZ13LNk3wGPu3JvUpDizFeJ344VjEAqVhvcCD6g6N57HjDxFiep4iEv6lcxROFaD5scz1mm_wuo2T615UmXj6pfLf68zlfxrO-0DNpF4zT8oKN4UCNEzyHROXLeljboWdhUdqW_bAYtTEO98BlSGs1eZIdw6DzfITvN4HpyaVhaags2wNVhDRcRAK3Eq7dMeibGrEQ_JgPXtwfOB_kj8pFyCF-pNA9TOMma-GNH0_SdY2U3WA0ONUcHI1E6a27vk6i5Np5xZHfCZWg9LJWW4EaxIdN0uSr4PulXnS85mZugVIj_TvoP_dYrMG9Lsc-Q")
            .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

}
