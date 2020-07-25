package com.example.soal2

object DataMenu {
    private val menuName = arrayOf(
        "Konsultasi Dokter",
        "Poliklinik",
        "Medical Check Up",
        "Farmasi",
        "Laboratorium",
        "Promo Bulan Ini",
        "Dokter Kami",
        "Location",
        "Hubungi Kami (Gawat Darurat)"
    )

    private val avatar = intArrayOf(
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img,
        R.drawable.img
    )


    val menuList: ArrayList<Menus>
        get() {
            val list = ArrayList<Menus>()
            for (pos in menuName.indices) {
                val menu = Menus()
                menu.menuName = menuName[pos]
                menu.img = avatar[pos]
                list.add(menu)
            }
            return list
        }

}