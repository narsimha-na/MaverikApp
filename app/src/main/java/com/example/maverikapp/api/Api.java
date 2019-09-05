package com.example.maverikapp.api;

import com.example.maverikapp.pojo_response.auth.AuthenticationResponse;
import com.example.maverikapp.pojo_response.posts.EditPostResponse;
import com.example.maverikapp.pojo_response.posts.PostLikeModel;
import com.example.maverikapp.pojo_response.posts.CreatePostResponse;
import com.example.maverikapp.pojo_response.posts.DisplayPostResponse;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("auth/register.php")
    Call<AuthenticationResponse> userSignUp(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender,
            @Field("dob") String dob,
            @Field("soy") String soy,
            @Field("college") String college,
            @Field("level") String level,
            @Field("role") String role

    );

    @FormUrlEncoded
    @POST("auth/login.php")
    Call<AuthenticationResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );



    @Headers("Content-Type: application/json")
    @GET("posts/display_all_posts.php")
    Call<DisplayPostResponse> getPosts(@Header("USER") String USER);

    @FormUrlEncoded
    @POST("posts/display_all_posts.php")
    Call<PostLikeModel> getLikePost(
            @Field("user_id") String user_id,
            @Field("post_id") String post_id

    );

    @FormUrlEncoded
    @POST("posts/create_post.php")
    Call<CreatePostResponse> createPost(
            @Field("p_title") String p_title,
            @Field("p_desc") String p_desc,
            @Field("p_user_id") String p_user_id,
            @Field("p_img_name") String p_img_name,
            @Field("p_img") String p_img
    );

    @FormUrlEncoded
    @POST("posts/edit_post.php")
    Call<EditPostResponse> editPost(
      @Field("title") String title,
      @Field("desc") String desc,
      @Field("img") String img,
      @Field("post_id") String post_id
    );
}
