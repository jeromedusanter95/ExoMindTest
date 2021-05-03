package com.jeromedusanter.exomindtest.domain.models

import com.jeromedusanter.base_android.domain.base.IModel

data class City(val name: String, val temperature: Double, val cloudiness: Int) : IModel