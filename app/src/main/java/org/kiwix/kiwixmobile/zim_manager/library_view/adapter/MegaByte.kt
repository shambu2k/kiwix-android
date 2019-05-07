package org.kiwix.kiwixmobile.zim_manager.library_view.adapter

import java.text.DecimalFormat

inline class MegaByte(val megabyteString: String?) {
  val humanReadable
    get() = megabyteString?.toLongOrNull()?.let {
      val units = arrayOf("KB", "MB", "GB", "TB")
      val conversion = (Math.log10(it.toDouble()) / Math.log10(1024.0)).toInt()
      (DecimalFormat("#,##0.#")
          .format(it / Math.pow(1024.0, conversion.toDouble()))
          + " "
          + units[conversion])
    } ?: ""

}