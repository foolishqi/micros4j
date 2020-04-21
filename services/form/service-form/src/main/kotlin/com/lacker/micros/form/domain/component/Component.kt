package com.lacker.micros.form.domain.component

import com.lacker.micros.domain.entity.EntityImpl

open class Component(
        var name: String,
        val type: String,
        var properties: String
        // val archive: string,
) : EntityImpl(), Cloneable {

    public override fun clone() = super<EntityImpl>.clone() as Component
}
