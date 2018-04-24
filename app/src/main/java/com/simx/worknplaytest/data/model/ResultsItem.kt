package com.simx.worknplaytest.data.model

import com.google.gson.annotations.SerializedName


class ResultsItem(@field:SerializedName("overview")
                  var overview: String, @field:SerializedName("original_language")
                  var originalLanguage: String, @field:SerializedName("original_title")
                  var originalTitle: String, @field:SerializedName("video")
                  var isVideo: Boolean,
                  @field:SerializedName("title")
                  var title: String, @field:SerializedName("genre_ids")
                  var genreIds: List<Int>, @field:SerializedName("poster_path")
                  var posterPath: String, @field:SerializedName("backdrop_path")
                  var backdropPath: String,
                  @field:SerializedName("release_date")
                  var releaseDate: String, @field:SerializedName("vote_average")
                  var voteAverage: Double, @field:SerializedName("popularity")
                  var popularity: Double, @field:SerializedName("id")
                  var id: Int, @field:SerializedName("adult")
                  var isAdult: Boolean,
                  @field:SerializedName("vote_count")
                  var voteCount: Int)