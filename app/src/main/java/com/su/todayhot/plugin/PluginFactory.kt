package com.su.todayhot.plugin

import com.su.mediabox.pluginapi.IPluginFactory
import com.su.mediabox.pluginapi.action.Action
import com.su.mediabox.pluginapi.action.CustomPageAction
import com.su.mediabox.pluginapi.action.HomeAction
import com.su.mediabox.pluginapi.components.IBasePageDataComponent
import com.su.todayhot.plugin.components.HotPageComponent

class PluginFactory : IPluginFactory() {

    override val host: String = ""

    override val initAction: Action
        get() = CustomPageAction.obtain(HotPageComponent::class.java)

    @Suppress("UNCHECKED_CAST")
    override fun <T : IBasePageDataComponent> createComponent(clazz: Class<T>): T? {
        return HotPageComponent() as? T?
    }

}