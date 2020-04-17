package com.hoon.dustsearch.model

import com.google.gson.annotations.SerializedName

data class CtprvnMesure(@SerializedName("busan") val busan: String,
                        @SerializedName("chungbuk") val chungbuk : String,
                        @SerializedName("chungnam") val chungnam : String,
                        @SerializedName("daegu") val daegu : String,

                        @SerializedName("daejeon") val daejeon: String,
                        @SerializedName("dataGubun") val dataGubun : String,
                        @SerializedName("dataTerm") val dataTerm : String,
                        @SerializedName("dataTime") val dataTime : String,

                        @SerializedName("gangwon") val gangwon: String,
                        @SerializedName("gwangju") val gwangju : String,
                        @SerializedName("gyeongbuk") val gyeongbuk : String,
                        @SerializedName("gyeonggi") val gyeonggi : String,

                        @SerializedName("gyeongnam") val gyeongnam: String,
                        @SerializedName("incheon") val incheon : String,
                        @SerializedName("itemCode") val itemCode : String,
                        @SerializedName("jeju") val jeju: String,

                        @SerializedName("jeonbuk") val jeonbuk: String,
                        @SerializedName("jeonnam") val jeonnam : String,
                        @SerializedName("numOfRows") val numOfRows : String,
                        @SerializedName("pageNo") val pageNo : String,

                        @SerializedName("resultCode") val resultCode: String,
                        @SerializedName("resultMsg") val resultMsg : String,
                        @SerializedName("searchCondition") val searchCondition : String,
                        @SerializedName("sejong") val sejong : String,

                        @SerializedName("seoul") val seoul: String,
                        @SerializedName("serviceKey") val serviceKey : String,
                        @SerializedName("totalCount") val totalCount : String,
                        @SerializedName("ulsan") val ulsan : String,

                        @SerializedName("_returnType") val _returnType: String)

