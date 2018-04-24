package com.simx.worknplaytest.data.model

import com.google.gson.annotations.SerializedName

class ResponsePopular(@field:SerializedName("page")
                      var page: Int, @field:SerializedName("total_pages")
                      var totalPages: Int,
                      @field:SerializedName("results")
                      var results: List<ResultsItem>, @field:SerializedName("total_results")
                      var totalResults: Int)