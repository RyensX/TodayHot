package com.su.todayhot.plugin

import com.su.mediabox.pluginapi.IPluginFactory
import com.su.mediabox.pluginapi.components.IBasePageDataComponent

class PluginFactory : IPluginFactory() {

    override val host: String = ""

    override fun <T : IBasePageDataComponent> createComponent(clazz: Class<T>): T? {
        TODO("Not yet implemented")
    }

}