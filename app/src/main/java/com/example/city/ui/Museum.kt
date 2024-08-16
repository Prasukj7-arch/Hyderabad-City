package com.example.city.ui

/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

public val Icons.Filled.Museum: ImageVector
    get() {
        if (_museum != null) {
            return _museum!!
        }
        _museum = materialIcon(name = "Filled.Museum") {
            materialPath {
                moveTo(22.0f, 11.0f)
                verticalLineTo(9.0f)
                lineTo(12.0f, 2.0f)
                lineTo(2.0f, 9.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(2.0f)
                verticalLineToRelative(9.0f)
                horizontalLineTo(2.0f)
                verticalLineToRelative(2.0f)
                horizontalLineToRelative(20.0f)
                verticalLineToRelative(-2.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(-9.0f)
                horizontalLineTo(22.0f)
                close()
                moveTo(16.0f, 18.0f)
                horizontalLineToRelative(-2.0f)
                verticalLineToRelative(-4.0f)
                lineToRelative(-2.0f, 3.0f)
                lineToRelative(-2.0f, -3.0f)
                verticalLineToRelative(4.0f)
                horizontalLineTo(8.0f)
                verticalLineToRelative(-7.0f)
                horizontalLineToRelative(2.0f)
                lineToRelative(2.0f, 3.0f)
                lineToRelative(2.0f, -3.0f)
                horizontalLineToRelative(2.0f)
                verticalLineTo(18.0f)
                close()
            }
        }
        return _museum!!
    }

private var _museum: ImageVector? = null
