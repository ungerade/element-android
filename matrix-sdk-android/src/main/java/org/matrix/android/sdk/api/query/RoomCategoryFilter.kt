/*
 * Copyright (c) 2021 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.api.query

enum class RoomCategoryFilter {
    ONLY_DM,
    ONLY_ROOMS,
    ONLY_WITH_NOTIFICATIONS,
    UNREAD_NOTIFICATION_DMS,
    UNREAD_NOTIFICATION_ROOMS,
    ROOMS_WITH_NO_NOTIFICATION,
    DMS_WITH_NO_NOTIFICATION,
    ALL
}
