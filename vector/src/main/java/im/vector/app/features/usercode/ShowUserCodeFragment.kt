/*
 * Copyright (c) 2020 New Vector Ltd
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

package im.vector.app.features.usercode

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import im.vector.app.R
import im.vector.app.core.extensions.setTextOrHide
import im.vector.app.core.platform.VectorBaseFragment
import im.vector.app.features.home.AvatarRenderer
import kotlinx.android.synthetic.main.fragment_user_code_show.*
import javax.inject.Inject

class ShowUserCodeFragment @Inject constructor(
        private val avatarRenderer: AvatarRenderer
) : VectorBaseFragment() {

    override fun getLayoutResId() = R.layout.fragment_user_code_show

    val sharedViewModel: UserCodeSharedViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showUserCodeClose.debouncedClicks {
            sharedViewModel.handle(UserCodeActions.DismissAction)
        }
        showUserCodeScanButton.debouncedClicks {
            doOpenQRCodeScanner()
        }
    }

    private fun doOpenQRCodeScanner() {
        sharedViewModel.handle(UserCodeActions.SwitchMode(UserCodeState.Mode.SCAN))
    }

    override fun invalidate() = withState(sharedViewModel) { state ->
        state.matrixItem?.let { avatarRenderer.render(it, showUserCodeAvatar) }
        state.shareLink?.let { showUserCodeQRImage.setData(it) }
        showUserCodeCardNameText.setTextOrHide(state.matrixItem?.displayName)
        showUserCodeCardUserIdText.setTextOrHide(state.matrixItem?.id)
        Unit
    }
}
