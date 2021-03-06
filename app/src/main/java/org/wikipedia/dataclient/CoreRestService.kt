package org.wikipedia.dataclient

import org.wikipedia.dataclient.restbase.DiffResponse
import org.wikipedia.dataclient.restbase.EditCount
import org.wikipedia.dataclient.restbase.Revision
import retrofit2.http.GET
import retrofit2.http.Path

interface CoreRestService {

    @GET("revision/{oldRev}/compare/{newRev}")
    suspend fun getDiff(
        @Path("oldRev") oldRev: Long,
        @Path("newRev") newRev: Long
    ): DiffResponse

    @GET("page/{title}/history/counts/{editType}")
    suspend fun getEditCount(
            @Path("title") title: String,
            @Path("editType") editType: String
    ): EditCount

    @GET("revision/{rev}")
    suspend fun getRevision(
        @Path("rev") rev: Long
    ): Revision

    companion object {
        const val CORE_REST_API_PREFIX = "w/rest.php/v1/"
    }
}
