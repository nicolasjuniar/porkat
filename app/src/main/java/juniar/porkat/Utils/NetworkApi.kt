package juniar.porkat.Utils

import io.reactivex.Observable
import juniar.porkat.auth.login.LoginRequest
import juniar.porkat.auth.login.LoginResponse
import juniar.porkat.auth.register.RegisterKateringRequest
import juniar.porkat.auth.register.RegisterPelangganRequest
import juniar.porkat.auth.register.RegisterResponse
import juniar.porkat.detailkatering.menu.GetListMenuResponse
import juniar.porkat.detailkatering.review.*
import juniar.porkat.homekatering.setting.ChangePasswordKateringRequest
import juniar.porkat.homepelanggan.setting.ChangePasswordPelangganRequest
import juniar.porkat.homepelanggan.setting.ChangePasswordResponse
import juniar.porkat.homepelanggan.setting.EditProfilePelangganRequest
import juniar.porkat.homepelanggan.setting.EditProfileResponse
import juniar.porkat.homepelanggan.transaction.GetTransactionResponse
import juniar.porkat.homepelanggan.transaction.MenuTransactionResponse
import juniar.porkat.homescreen.ListKateringResponse
import juniar.porkat.transaction.TransactionRequest
import juniar.porkat.transaction.TransactionResponse
import retrofit2.http.*

/**
 * Created by Nicolas Juniar on 12/02/2018.
 */
interface NetworkApi {
    @GET("katering/list/rating")
    fun GetListKateringByRating(): Observable<ListKateringResponse>

    @GET("katering/list/distance")
    fun GetListKateringByDistance(@Query("latitude") latitude: Double,
                                  @Query("longitude") longitude: Double): Observable<ListKateringResponse>

    @POST("pengguna/login")
    fun login(@Body request: LoginRequest): Observable<LoginResponse>

    @POST("pelanggan/register")
    fun registerPelanggan(@Body request: RegisterPelangganRequest): Observable<RegisterResponse>

    @PUT("pelanggan/update/profile")
    fun editProfilePelanggan(@Body request: EditProfilePelangganRequest): Observable<EditProfileResponse>

    @PUT("pelanggan/update/password")
    fun changePasswordPelanggan(@Body requestBody: ChangePasswordPelangganRequest): Observable<ChangePasswordResponse>

    @GET("menu/list")
    fun getListMenu(@Query("id_katering") idKatering: Int): Observable<GetListMenuResponse>

    @GET("pelanggan/ulasan/list")
    fun getListUlasan(@Query("id_katering") idKatering: Int,
                      @Query("id_pelanggan") idPelanggan: Int): Observable<GetReviewResponse>

    @DELETE("pelanggan/ulasan/delete/{id_ulasan}")
    fun deleteUlasan(@Path("id_ulasan") idUlasan: Int): Observable<DeleteReviewResponse>

    @POST("pelanggan/ulasan/insert")
    fun insertUlasan(@Body request: InsertReviewRequest): Observable<InsertReviewResponse>

    @PUT("pelanggan/ulasan/update")
    fun updateUlasan(@Body request: UpdateReviewRequest): Observable<UpdateReviewResponse>

    @POST("pelanggan/pesan/insert")
    fun orderKatering(@Body request: TransactionRequest): Observable<TransactionResponse>

    @GET("pelanggan/pesan/list")
    fun getListTransactionPelanggan(@Query("id_pelanggan") idPelanggan: Int): Observable<GetTransactionResponse>

    @GET("pelanggan/pesan/menu")
    fun getMenuTransaction(@Query("id_pesan") idPesan: Int): Observable<MenuTransactionResponse>

    @POST("katering/register")
    fun registerKatering(@Body request: RegisterKateringRequest): Observable<RegisterResponse>

    @PUT("katering/update/password")
    fun changePasswordKatering(@Body request: ChangePasswordKateringRequest): Observable<ChangePasswordResponse>
}