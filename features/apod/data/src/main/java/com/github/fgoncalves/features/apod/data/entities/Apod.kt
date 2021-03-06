package com.github.fgoncalves.features.apod.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Astronomy picture of the day
 *
 * Example:
 *```
 * {
 *   "copyright": "Tom\u00e1\u0161 Slovinsk\u00fd",
 *   "date": "2020-10-21",
 *   "explanation": "How many famous sky objects can you find in this image?  The featured dark sky composite combines over 60 exposures spanning over 220 degrees to create a veritable menagerie of night sky wonders. Visible celestial icons include the Belt of Orion, the Orion Nebula, the Andromeda Galaxy, the California Nebula, and bright stars Sirius and Betelgeuse.  You can verify that you found these, if you did, by checking an annotated version of the image.  A bit harder, though, is finding Polaris and the Big Dipper. Also discernible are several meteors from the Quandrantids meteor shower, red and green airglow, and two friends of the astrophotographer.  The picture was captured in January from Sardinia, Italy.  You can see sky wonders in your own night sky tonight -- including more meteors than usual -- because tonight is near peak of the yearly Orionids meteor shower.   News: NASA\u2019s OSIRIS-REx Spacecraft Successfully Touches Asteroid",
 *   "hdurl": "https://apod.nasa.gov/apod/image/2010/Quantrids_Slovinsky_2048.jpg",
 *   "media_type": "image",
 *   "service_version": "v1",
 *   "title": "A Night Sky Vista from Sardinia",
 *   "url": "https://apod.nasa.gov/apod/image/2010/Quantrids_Slovinsky_960.jpg"
 * }
 * ```
 */
@JsonClass(generateAdapter = true)
data class Apod(
    @Json(name = "copyright")
    val copyright: String? = null,
    @Json(name = "date")
    val date: String = "",
    @Json(name = "explanation")
    val explanation: String = "",
    @Json(name = "title")
    val title: String = "",
    @Json(name = "url")
    val url: String = "",
)
