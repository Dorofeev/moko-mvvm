/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.mvvm.livedata

import dev.icerock.moko.mvvm.utils.bind
import dev.icerock.moko.mvvm.utils.setEventHandler
import platform.UIKit.UIControlEventValueChanged
import platform.UIKit.UISwitch

fun LiveData<Boolean>.bindBoolToSwitchOn(
    switch: UISwitch
) {
    bind(switch) { this.on = it }
}

fun MutableLiveData<Boolean>.bindBoolTwoWayToSwitchOn(
    switch: UISwitch
) {
    bindBoolToSwitchOn(switch)

    switch.setEventHandler(UIControlEventValueChanged) {
        if (value == on) return@setEventHandler

        value = on
    }
}
