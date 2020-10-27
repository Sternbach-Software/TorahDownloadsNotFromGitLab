package tech.torah.aldis.androidapp

data class Speaker(
    val id: Int =                           64,
    val name: String =                      "Rabbi Yisroel Belsky",
    val last_name: String =                 "Belsky",
    val image_path: String =                "assets/speakers/64.jpg",
    val link: String =                      "s-64-rabbi-yisroel-belsky.html",
    val shiur_count: Int =                  31
) {
    public val description = "Insert description here.................."
}
